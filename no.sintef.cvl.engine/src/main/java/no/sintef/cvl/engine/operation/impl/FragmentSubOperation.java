package no.sintef.cvl.engine.operation.impl;

import java.util.HashMap;
import java.util.HashSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;

import no.sintef.cvl.engine.common.CVLFragmentCopier;
import no.sintef.cvl.engine.common.SubstitutionContext;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.ContainmentCVLModelException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.IllegalCVLOperation;
import no.sintef.cvl.engine.error.IncorrectCVLModel;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.logging.Logger;
import no.sintef.cvl.engine.operation.Substitution;

public class FragmentSubOperation implements Substitution {

	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private CVLFragmentCopier rplCopier;
	private FragmentSubstitutionHolder fragSubHolder;
	private Logger logger = SubstitutionContext.ME.getLogger();

	public FragmentSubOperation(FragmentSubstitutionHolder fsh){
		fragSubHolder = fsh;
		this.placement = fsh.getPlacement();
		this.replacement = fsh.getReplacement();
	}
	
	@Override
	public void execute(boolean replace) throws BasicCVLEngineException {
		this.copyReplacementElements();
		this.bindBounderies(replace);
	}
	
	public void checkConsistence() throws ContainmentCVLModelException{
		checkPlacementElementsContainment();
		checkContainmentOutsideBoundaryElement();
	}

	private void bindBounderies(boolean replace) throws BasicCVLEngineException{
		EList<ToBinding> toBindings = fragSubHolder.getToBindings();
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			ToReplacement toReplacement = toBinding.getToReplacement();
			if(toPlacement != null && toReplacement != null){
				String propertyName = toPlacement.getPropertyName();
				EObject outsideBEPlac = Utility.resolveProxies(toPlacement.getOutsideBoundaryElement());	
				EList<EObject> insideBERepl = this.getInsideBEToReplacement(toReplacement);
				EStructuralFeature property = outsideBEPlac.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				
				if(!property.isDerived() && !property.isTransient()){
					Boolean isChangeable = property.isChangeable();
					if(!isChangeable){
						setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(true));
						if(!property.isChangeable()){
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to set changeable to true, howevere we have to adjust the property : " + propertyName);
						}
					}
					
					EList<ObjectHandle> insideBoundaryObjectHandlesCurrentPlc = toPlacement.getInsideBoundaryElement();
					EList<EObject> insideBEPlacCurrent = Utility.resolveProxies(insideBoundaryObjectHandlesCurrentPlc);
					int upperBound = property.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> propertyValueOutBEPlac = Utility.getListPropertyValue(outsideBEPlac, property);
						EList<EObject> elemenetsToRemove = (replace) ? insideBEPlacCurrent : new BasicEList<EObject>();
						EList<EObject> propertyValueNew = Utility.subtractAugmentList(propertyValueOutBEPlac, elemenetsToRemove, insideBERepl);
						if(upperBound != -1 && propertyValueNew.size() > upperBound){
							throw new IllegalCVLOperation("cardinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
						}
						
						setProperty(propertyValueOutBEPlac, elemenetsToRemove, insideBERepl);
						//this.setProperty(outsideBEPlac, property, propertyValueNew);
						
						EList<EObject> propertyValueSet = Utility.getListPropertyValue(outsideBEPlac, property);
						if(!propertyValueNew.equals(propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}
						
						//update insideBoundaryElements of the reference 
						EList<EObject> insideBEPlacNew = Utility.subtractAugmentList(insideBEPlacCurrent, elemenetsToRemove, insideBERepl);
						updateToPlacementInsideBoundaryElements(toPlacement, insideBEPlacNew);
					}else{
						//property.getUpperBound() == 0 || == 1
						if(upperBound == 0){
							throw new IncorrectCVLModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + outsideBEPlac.eGet(property));
						}
						if(insideBERepl.size() > upperBound){
							throw new IllegalCVLOperation("cardinality does not match for property :" + propertyName + "of" + fragSubHolder.getFragment());
						}
						Object propertyValueOutBEPlac = outsideBEPlac.eGet(property);
						if(propertyValueOutBEPlac != null && !replace){
							throw new IllegalCVLOperation("replace flag is set to false, but the cardinality is 1 and property is not empty already");
						}
						if(insideBEPlacCurrent.size() > 1){
							throw new GeneralCVLEngineException("EPIC FAIL: holy crap, the insideBoundatyElement reference seems to reference more then one element, while the cardinality is 1");
						}
						
						EObject propertyValueNew = (insideBERepl.size() == 1) ? insideBERepl.get(0) : null;
						setProperty(outsideBEPlac, property, propertyValueNew);
						Object propertyValueSet = outsideBEPlac.eGet(property);
						if((propertyValueNew != null && !propertyValueNew.equals(propertyValueSet)) || (propertyValueNew == null && propertyValueNew != propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}
						
						//update insideBoundaryElements of the reference
						this.updateToPlacementInsideBoundaryElement(toPlacement, propertyValueNew);
					}
					
					if(!isChangeable){
						setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(false));
						if(property.isChangeable())
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to restore changeble property:" + propertyName);
					}
				}else{
					logger.warn("derived and transient properties should not been used for toBinding, skip it " + property);
				}
				
			}else {
				throw new IncorrectCVLModel("toPlacement and toReplacement are null or toPlacement is null! It seems to be incorrect!");
			}
		}
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			FromReplacement fromReplacement = fromBinding.getFromReplacement();
			if(fromPlacement != null && fromReplacement != null){
				String propertyName = fromReplacement.getPropertyName();
				EList<EObject> outsideBEPlac = Utility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
				outsideBEPlac = (outsideBEPlac.size() == 1 && outsideBEPlac.get(0) == null) ? new BasicEList<EObject>() : outsideBEPlac; 
				EObject insideBERepl = this.getInsideBEFromReplacement(fromReplacement);
				EStructuralFeature property = insideBERepl.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				
				if(!property.isDerived() && !property.isTransient()){
					Boolean isChangeable = property.isChangeable();
					if(!isChangeable){
						setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(true));
						if(!property.isChangeable()){
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to set changeable to true, howevere we have to adjust the property : " + propertyName);
						}
					}
					
					ObjectHandle insideBoundaryObjectHandleCurrentPlc = fromPlacement.getInsideBoundaryElement();
					EList<EObject> outsideBEReplCurrent = Utility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
					int upperBound = property.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> propertyValueInsBERepl = Utility.getListPropertyValue(insideBERepl, property);
						EList<EObject> propertyValueNew = Utility.subtractAugmentList(propertyValueInsBERepl, outsideBEReplCurrent, outsideBEPlac);
						if(upperBound != -1 && propertyValueNew.size() > upperBound){
							throw new IllegalCVLOperation("cardinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
						}
						
						setProperty(propertyValueInsBERepl, outsideBEReplCurrent, outsideBEPlac);
						EList<EObject> propertyValueSet = Utility.getListPropertyValue(insideBERepl, property);
						if(!propertyValueNew.equals(propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}
					}else{
						//property.getUpperBound() == 0 || == 1
						if(upperBound == 0){
							throw new IncorrectCVLModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBERepl.eGet(property));
						}
						if(outsideBEPlac.size() > upperBound){
							throw new IllegalCVLOperation("cardinality does not match for property :" + propertyName + "of" + fragSubHolder.getFragment());
						}
						Object propertyValueInsBERepl = insideBERepl.eGet(property);
						if(propertyValueInsBERepl != null && !replace){
							throw new IllegalCVLOperation("replace flag is set to false, but the cardinality is 1 and property is not empty already");
						}
						if(outsideBEReplCurrent.size() > 1){
							throw new GeneralCVLEngineException("EPIC FAIL: holy crap, the outsideBoundatyElement reference seems to point more then one element, while the cardinality is 1");
						}
						EObject propertyValueNew = (outsideBEPlac.size() == 1) ? outsideBEPlac.get(0) : null;
						
						setProperty(insideBERepl, property, propertyValueNew);
						Object propertyValueSet = insideBERepl.eGet(property);
						if((propertyValueNew != null && !propertyValueNew.equals(propertyValueSet)) || (propertyValueNew == null && propertyValueNew != propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}				
					}
					//update insideBoundaryElementReference for fromPlacement;
					EObject insideBoundaryElement = this.getReplCopyElementFromOriginal(Utility.resolveProxies(fromReplacement.getInsideBoundaryElement()));
					ObjectHandle rplObjectHandle = this.getInsideBoundaryElementObjectHandleFromPlacement(fromPlacement, insideBoundaryElement);
					updateInsideBoundaryElementObjectHandleBoundaries(insideBoundaryObjectHandleCurrentPlc, rplObjectHandle, replace);
					
					if(!isChangeable){
						setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(false));
						if(property.isChangeable())
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to restore changeble property:" + propertyName);
					}
				}else{
					logger.warn("derived or transient properties should not been used for fromBinding, skip it " + property);
				}
			}else{
				throw new IncorrectCVLModel("fromPlacement and fromReplacement are null or fromReplacement is null! It seems to be incorrect!");
			}	
		}
		//testOutsideBoundaryElementsContainment();
		fragSubHolder.update(replace);
	}

	private void setProperty(EList<EObject> original, EList<EObject> toRemove, EList<EObject> toAdd){
		for(EObject eObject : toRemove){
			original.remove(eObject);
		}
		original.addAll(toAdd);
	}
	
	//DEPRICATED
	private void setProperty(EObject targetEObject, EStructuralFeature feature, EList<EObject> values){
		targetEObject.eSet(feature, values);
	}
	
	private void setProperty(EObject targetEObject, EStructuralFeature feature, Object value){
		targetEObject.eSet(feature, value);
	}
	
	private void checkPlacementElementsContainment() throws ContainmentCVLModelException {
		HashSet<EObject> placementElements = placement.getElements();
		for(EObject eObject : placementElements){
			Resource resource = eObject.eResource();
			if(resource == null)
				throw new ContainmentCVLModelException("placement element:" + eObject + " is not contained by any element, check your VM");
		}
		
	}
	
	private void checkContainmentOutsideBoundaryElement() throws ContainmentCVLModelException {
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			EList<EObject> outsideBoundaryElements = Utility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
			for(EObject outsideBoundaryElement : outsideBoundaryElements){
				Resource resource = outsideBoundaryElement.eResource();
				if(resource == null)
					throw new ContainmentCVLModelException("outsideBoundaryElement element:" + outsideBoundaryElement + " is not contained by any element, check your VM");
			}
		}
		EList<ToBinding> toBindings = fragSubHolder.getToBindings();
		HashMap<ToPlacement, HashSet<ObjectHandle>> outsideToBoundaryMap = fragSubHolder.getToPlacementOutsideBoundaryElementMap();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			EObject outsideBoundaryElement = Utility.resolveProxies(toPlacement.getOutsideBoundaryElement());
			Resource resource = outsideBoundaryElement.eResource();
			if(resource == null)
				throw new ContainmentCVLModelException("outsideBoundaryElement element:" + outsideBoundaryElement + " is not contained by any element, check your VM");
			HashSet<ObjectHandle> objectHandles = outsideToBoundaryMap.get(toPlacement);
			if(objectHandles != null){
				EList<EObject> outsideBoundaryElements = Utility.resolveProxies(new BasicEList<ObjectHandle>(objectHandles));
				for(EObject eObject : outsideBoundaryElements){
					resource = eObject.eResource();
					if(resource == null)
						throw new ContainmentCVLModelException("outsideBoundaryElement element:" + eObject + " is not contained by any element, check your VM");
				}
			}
		}
	}
	
	private void testOutsideBoundaryElementsContainment() throws BasicCVLEngineException{
		HashSet<EObject> placementElements = placement.getElements();
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			EList<EObject> outsideBoundaryElements = Utility.resolveProxies(fromBinding.getFromPlacement().getOutsideBoundaryElement());
			outsideBoundaryElements = (outsideBoundaryElements.size() == 1 && outsideBoundaryElements.get(0) == null) ? new BasicEList<EObject>() : outsideBoundaryElements;
			for(EObject outsideBoundaryElement : outsideBoundaryElements){
				EObject container = outsideBoundaryElement.eContainer();
				if(placementElements.contains(container)){
					EObject referencer = Utility.resolveProxies(fromBinding.getFromPlacement().getInsideBoundaryElement());
					EObject referencerContainer = referencer.eContainer();
					EStructuralFeature feature = referencer.eContainingFeature();
					int upperBound = feature.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> propertyValue = Utility.getListPropertyValue(referencerContainer, feature);
						if(upperBound != -1 && propertyValue.size() >= upperBound){
							throw new IncorrectCVLModel("cardinality of the containment property is less than amount of the contined elements " + fragSubHolder.getFragment() + " property " + feature + "values " + propertyValue);
						}
						propertyValue.add(outsideBoundaryElement);
						propertyValue = new BasicEList<EObject>(propertyValue);
						this.setProperty(referencerContainer, feature, propertyValue);
						//referencerContainer.eSet(feature, propertyValue);
						
						EList<EObject> propertySet = Utility.getListPropertyValue(referencerContainer, feature);
						if(!propertySet.equals(propertyValue)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + feature + "of" + fragSubHolder.getFragment());
						}
					}else{
						//upperBound == 0 || == 1
						Object propertyValue = referencerContainer.eGet(feature);
						if(upperBound == 0){
							throw new IncorrectCVLModel("cardinality of the containment is 0, but we need to add an element " + fragSubHolder.getFragment() + " property " + feature + " element to add " + outsideBoundaryElement);
						}
						if(propertyValue != null){
							throw new IncorrectCVLModel("cardinality of the containment is 1, there is one element " + propertyValue + " but we need to add one more: " + fragSubHolder.getFragment() + " property " + feature + " element to add " + outsideBoundaryElement);
						}
						this.setProperty(referencerContainer, feature, outsideBoundaryElement);
						//referencerContainer.eSet(feature, outsideBoundaryElement);
						
						Object propertySet = referencerContainer.eGet(feature);
						if(propertySet.equals(outsideBoundaryElement)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + feature + "of" + fragSubHolder.getFragment());
						}
					}
				}
			}
		}
	}
	
	private void copyReplacementElements() {
		rplCopier = new CVLFragmentCopier();
		HashSet<EObject> replacementInnerElements = replacement.getElements();
		rplCopier.copyFragment(replacementInnerElements);
	}

	private EObject getReplCopyElementFromOriginal(EObject originalObject) throws GeneralCVLEngineException{
		EObject copyObject = rplCopier.get(originalObject);
		if(copyObject == null){
			throw new GeneralCVLEngineException("Copy map for replacement is incorrect, can not find a copy for " + originalObject);
		}
		return copyObject;
	}
	
	private EList<EObject> getReplCopyElementFromOriginal(EList<EObject> originalList) throws GeneralCVLEngineException{
		EList<EObject> copyEList = new BasicEList<EObject>();
		for(EObject object : originalList){
			EObject copyObject = rplCopier.get(object);
			if(copyObject == null){
				throw new GeneralCVLEngineException("Copy map for replacement is incorrect, can not find a copy for " + object);
			}
			copyEList.add(copyObject);
		}
		return copyEList;
	}
	
	private EList<EObject> getInsideBEToReplacement(ToReplacement toReplacement) throws GeneralCVLEngineException{
		EList<EObject> nullList = new BasicEList<EObject>();
		EList<EObject> insideBERepl = (!Utility.isDummyToReplacement(toReplacement)) ? this.getReplCopyElementFromOriginal(Utility.resolveProxies(toReplacement.getInsideBoundaryElement())) : nullList;
		return insideBERepl;
	}
	
	private EObject getInsideBEFromReplacement(FromReplacement fromReplacement) throws GeneralCVLEngineException{
		return this.getReplCopyElementFromOriginal(Utility.resolveProxies(fromReplacement.getInsideBoundaryElement()));
	}
		
	private void updateToPlacementInsideBoundaryElements(ToPlacement toPlacement, EList<EObject> insideBoundaryElements) throws UnexpectedOperationFailure{
		toPlacement.getInsideBoundaryElement().clear();
		toPlacement.getInsideBoundaryElement().addAll(Utility.getObjectHandlesByEObjects(fragSubHolder.getFragment(), insideBoundaryElements));
	}
	
	private void updateToPlacementInsideBoundaryElement(ToPlacement toPlacement, EObject insideBoundaryElement) throws UnexpectedOperationFailure{
		toPlacement.getInsideBoundaryElement().clear();
		EList<EObject> insideBoundaryElements = new BasicEList<EObject>();
		insideBoundaryElements.add(insideBoundaryElement);
		EList<ObjectHandle> objectHandles = Utility.getObjectHandlesByEObjects(fragSubHolder.getFragment(), insideBoundaryElements);
		toPlacement.getInsideBoundaryElement().add(objectHandles.get(0));
	}
		
	private ObjectHandle getInsideBoundaryElementObjectHandleFromPlacement(FromPlacement fromPlacement, EObject insideBoundaryElement) throws UnexpectedOperationFailure{
		EList<EObject> insideBoundaryElements = new BasicEList<EObject>();
		insideBoundaryElements.add(insideBoundaryElement);
		EList<ObjectHandle> objectHandles = Utility.getObjectHandlesByEObjects(fragSubHolder.getFragment(), insideBoundaryElements);
		return objectHandles.get(0);
	}
	
	private void updateInsideBoundaryElementObjectHandleBoundaries(ObjectHandle objectHandle, ObjectHandle replacementObjectHandle, boolean replace) throws GeneralCVLEngineException{
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementFragment().getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : placementBoundaries){
			if(boundary instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) boundary;
				if(fromPlacement.getInsideBoundaryElement().equals(objectHandle)){
					fromPlacement.setInsideBoundaryElement(replacementObjectHandle);
					//we should store all insideBoundary references if we do not replace a placement fragment 
					HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementMap = fragSubHolder.getFromPlacementInsideBoundaryElementMap();
					HashSet<ObjectHandle> insideBoundaryElementsSet = (replace) ? new HashSet<ObjectHandle>() : fromPlacementMap.get(fromPlacement);
					if(insideBoundaryElementsSet == null){
						throw new GeneralCVLEngineException("insideBoundaryElement set is null for given fromPlacement, should not happen");
					}
					insideBoundaryElementsSet.add(replacementObjectHandle);
					fromPlacementMap.put(fromPlacement, insideBoundaryElementsSet);
					fragSubHolder.setFromPlacementInsideBoundaryElementMap(fromPlacementMap);
				}
			}
		}
	}
}
