package no.sintef.bvr.engine.operation.impl;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.common.engine.error.ContainmentBVRModelException;
import no.sintef.bvr.common.engine.error.GeneralBVREngineException;
import no.sintef.bvr.common.engine.error.IllegalBVROperation;
import no.sintef.bvr.common.engine.error.IncorrectBVRModel;
import no.sintef.bvr.common.engine.error.UnexpectedOperationFailure;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.BVRFragmentCopier;
import no.sintef.bvr.engine.common.SubstitutionContext;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.fragment.impl.PlacementElementHolder;
import no.sintef.bvr.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.bvr.engine.operation.Substitution;

public class FragmentSubOperation implements Substitution {

	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private BVRFragmentCopier rplCopier;
	private FragmentSubstitutionHolder fragSubHolder;
	private Logger logger = SubstitutionContext.ME.getLogger();

	public FragmentSubOperation(FragmentSubstitutionHolder fsh){
		fragSubHolder = fsh;
		placement = fsh.getPlacement();
		replacement = fsh.getReplacement();
	}
	
	@Override
	public void execute(boolean replace) throws BasicBVREngineException {
		replacement.update();
		copyReplacementElements();
		bindBounderies(replace);
	}
	
	public void checkConsistence() throws ContainmentBVRModelException{
		checkPlacementElementsContainment();
		checkContainmentOutsideBoundaryElement();
	}

	private void bindBounderies(boolean replace) throws BasicBVREngineException{
		EList<ToBinding> toBindings = fragSubHolder.getToBindings();
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			ToReplacement toReplacement = toBinding.getToReplacement();
			if(toPlacement != null && toReplacement != null){
				String propertyName = toPlacement.getPropertyName();
				
				HashSet<ObjectHandle> outsideBoundaryOHToPlacementMap = fragSubHolder.getToPlacementOutsideBoundaryElementMap().get(toPlacement);
				if(outsideBoundaryOHToPlacementMap == null || outsideBoundaryOHToPlacementMap.isEmpty())
					throw new UnexpectedOperationFailure("outside boundary map does not have any elements for toPlacement " + toPlacement);
					
				EList<EObject> outsideBoundaryList = EngineUtility.resolveProxies(new BasicEList<ObjectHandle>(outsideBoundaryOHToPlacementMap));
				EList<EObject> insideBEPlacCurrent = EngineUtility.resolveProxies(toPlacement.getInsideBoundaryElement());
				for(EObject outsideBEPlac : outsideBoundaryList){					
					EList<EObject> insideBERepl = this.getInsideBEToReplacement(toReplacement);
					EStructuralFeature property = outsideBEPlac.eClass().getEStructuralFeature(propertyName);
					if(property == null){
						throw new GeneralBVREngineException("failed to find property to bind, property name : " + propertyName);
					}
					
					if(!property.isDerived() && !property.isTransient()){
						Boolean isChangeable = property.isChangeable();
						if(!isChangeable){
							EngineUtility.setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(true));
							if(!property.isChangeable()){
								throw new UnexpectedOperationFailure("EPIC FAIL: failed to set changeable to true, howevere we have to adjust the property : " + propertyName);
							}
						}
						
						int upperBound = property.getUpperBound();
						if(upperBound == -1 || upperBound > 1){
							EList<EObject> propertyValueOutBEPlac = EngineUtility.getListPropertyValue(outsideBEPlac, property);
							EList<EObject> elemenetsToRemove = (replace) ? insideBEPlacCurrent : new BasicEList<EObject>();
							EList<EObject> propertyValueNew = EngineUtility.subtractAugmentList(propertyValueOutBEPlac, elemenetsToRemove, insideBERepl);
							if(upperBound != -1 && propertyValueNew.size() > upperBound){
								throw new IllegalBVROperation("cardinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
							}
							
							EngineUtility.setProperty(propertyValueOutBEPlac, elemenetsToRemove, insideBERepl);
							
							EList<EObject> propertyValueSet = EngineUtility.getListPropertyValue(outsideBEPlac, property);
							if(!propertyValueNew.equals(propertyValueSet)){
								throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
							}
							
							//update insideBoundaryElements of the reference 
							EList<EObject> insideBEPlacNew = EngineUtility.subtractAugmentList(insideBEPlacCurrent, elemenetsToRemove, insideBERepl);
							updateToPlacementInsideBoundaryElements(toPlacement, insideBEPlacNew);
						}else{
							//property.getUpperBound() == 0 || == 1
							if(upperBound == 0){
								throw new IncorrectBVRModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + outsideBEPlac.eGet(property));
							}
							if(insideBERepl.size() > upperBound){
								throw new IllegalBVROperation("cardinality does not match for property :" + propertyName + "of" + fragSubHolder.getFragment());
							}
							Object propertyValueOutBEPlac = outsideBEPlac.eGet(property);
							if(propertyValueOutBEPlac != null && !replace){
								throw new IllegalBVROperation("replace flag is set to false, but the cardinality is 1 and property is not empty already");
							}
							if(insideBEPlacCurrent.size() > 1){
								throw new GeneralBVREngineException("EPIC FAIL: holy crap, the insideBoundatyElement reference seems to reference more then one element, while the cardinality is 1");
							}
							
							EObject propertyValueNew = (insideBERepl.size() == 1) ? insideBERepl.get(0) : null;
							EngineUtility.setProperty(outsideBEPlac, property, propertyValueNew);
							Object propertyValueSet = outsideBEPlac.eGet(property);
							if((propertyValueNew != null && !propertyValueNew.equals(propertyValueSet)) || (propertyValueNew == null && propertyValueNew != propertyValueSet)){
								throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
							}
							
							//update insideBoundaryElements of the reference
							updateToPlacementInsideBoundaryElement(toPlacement, propertyValueNew);
						}
						
						if(!isChangeable){
							EngineUtility.setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(false));
							if(property.isChangeable())
								throw new UnexpectedOperationFailure("EPIC FAIL: failed to restore changeble property:" + propertyName);
						}
					}else{
						logger.warn("derived and transient properties should not been used for toBinding, skip it " + property);
					}
				
				
				}
			}else {
				throw new IncorrectBVRModel("toPlacement and toReplacement are null or toPlacement is null! It seems to be incorrect!");
			}
		}
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			FromReplacement fromReplacement = fromBinding.getFromReplacement();
			if(fromPlacement != null && fromReplacement != null){
				String propertyName = fromReplacement.getPropertyName();
				EList<EObject> outsideBEPlac = EngineUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
				outsideBEPlac = (outsideBEPlac.size() == 1 && outsideBEPlac.get(0) == null) ? new BasicEList<EObject>() : outsideBEPlac; 
				EObject insideBERepl = this.getInsideBEFromReplacement(fromReplacement);
				EStructuralFeature property = insideBERepl.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralBVREngineException("failed to find property to bind, property name : " + propertyName);
				}
				
				if(!property.isDerived() && !property.isTransient()){
					Boolean isChangeable = property.isChangeable();
					if(!isChangeable){
						EngineUtility.setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(true));
						if(!property.isChangeable()){
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to set changeable to true, howevere we have to adjust the property : " + propertyName);
						}
					}
					
					ObjectHandle insideBoundaryObjectHandleCurrentPlc = fromPlacement.getInsideBoundaryElement();
					EList<EObject> outsideBEReplCurrent = EngineUtility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
					int upperBound = property.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> propertyValueInsBERepl = EngineUtility.getListPropertyValue(insideBERepl, property);
						EList<EObject> propertyValueNew = EngineUtility.subtractAugmentList(propertyValueInsBERepl, outsideBEReplCurrent, outsideBEPlac);
						if(upperBound != -1 && propertyValueNew.size() > upperBound){
							throw new IllegalBVROperation("cardinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
						}
						
						EngineUtility.setProperty(propertyValueInsBERepl, outsideBEReplCurrent, outsideBEPlac);
						EList<EObject> propertyValueSet = EngineUtility.getListPropertyValue(insideBERepl, property);
						if(!propertyValueNew.equals(propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}
					}else{
						//property.getUpperBound() == 0 || == 1
						if(upperBound == 0){
							throw new IncorrectBVRModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBERepl.eGet(property));
						}
						if(outsideBEPlac.size() > upperBound){
							throw new IllegalBVROperation("cardinality does not match for property :'" + propertyName + "'of " + fragSubHolder.getFragment());
						}
						if(outsideBEReplCurrent.size() > 1){
							throw new GeneralBVREngineException("EPIC FAIL: holy crap, the outsideBoundatyElement reference seems to point more then one element, while the cardinality is 1");
						}
						EObject propertyValueNew = (outsideBEPlac.size() == 1) ? outsideBEPlac.get(0) : null;
						
						EngineUtility.setProperty(insideBERepl, property, propertyValueNew);
						Object propertyValueSet = insideBERepl.eGet(property);
						if((propertyValueNew != null && !propertyValueNew.equals(propertyValueSet)) || (propertyValueNew == null && propertyValueNew != propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
						}				
					}
					//update insideBoundaryElementReference for fromPlacement;
					EObject insideBoundaryElement = this.getReplCopyElementFromOriginal(EngineUtility.resolveProxies(fromReplacement.getInsideBoundaryElement()));
					ObjectHandle rplObjectHandle = this.getInsideBoundaryElementObjectHandleFromPlacement(fromPlacement, insideBoundaryElement);
					updateInsideBoundaryElementObjectHandleBoundaries(insideBoundaryObjectHandleCurrentPlc, rplObjectHandle, replace);
					
					if(!isChangeable){
						EngineUtility.setProperty(property, property.eClass().getEStructuralFeature("changeable"), new Boolean(false));
						if(property.isChangeable())
							throw new UnexpectedOperationFailure("EPIC FAIL: failed to restore changeble property:" + propertyName);
					}
				}else{
					logger.warn("derived or transient properties should not been used for fromBinding, skip it " + property);
				}
			}else{
				throw new IncorrectBVRModel("fromPlacement and fromReplacement are null or fromReplacement is null! It seems to be incorrect!");
			}	
		}
		fragSubHolder.update(replace);
	}
		
	private void checkPlacementElementsContainment() throws ContainmentBVRModelException {
		HashSet<EObject> placementElements = placement.getElements();
		for(EObject eObject : placementElements){
			Resource resource = eObject.eResource();
			if(resource == null)
				throw new ContainmentBVRModelException("placement element:" + eObject + " is not contained by any element, check your VM");
		}
		
	}
	
	private void checkContainmentOutsideBoundaryElement() throws ContainmentBVRModelException {
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			EList<EObject> outsideBoundaryElements = EngineUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
			for(EObject outsideBoundaryElement : outsideBoundaryElements){
				Resource resource = outsideBoundaryElement.eResource();
				if(resource == null)
					throw new ContainmentBVRModelException("outsideBoundaryElement element:" + outsideBoundaryElement + " is not contained by any element, check your VM");
			}
		}
		EList<ToBinding> toBindings = fragSubHolder.getToBindings();
		HashMap<ToPlacement, HashSet<ObjectHandle>> outsideToBoundaryMap = fragSubHolder.getToPlacementOutsideBoundaryElementMap();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			EObject outsideBoundaryElement = EngineUtility.resolveProxies(toPlacement.getOutsideBoundaryElement());
			Resource resource = outsideBoundaryElement.eResource();
			if(resource == null)
				throw new ContainmentBVRModelException("outsideBoundaryElement element:" + outsideBoundaryElement + " is not contained by any element, check your VM");
			HashSet<ObjectHandle> objectHandles = outsideToBoundaryMap.get(toPlacement);
			if(objectHandles != null){
				EList<EObject> outsideBoundaryElements = EngineUtility.resolveProxies(new BasicEList<ObjectHandle>(objectHandles));
				for(EObject eObject : outsideBoundaryElements){
					resource = eObject.eResource();
					if(resource == null)
						throw new ContainmentBVRModelException("outsideBoundaryElement element:" + eObject + " is not contained by any element, check your VM");
				}
			}
		}
	}
		
	private void copyReplacementElements() {
		rplCopier = new BVRFragmentCopier();
		HashSet<EObject> replacementInnerElements = replacement.getElements();
		rplCopier.copyFragment(replacementInnerElements);
	}

	private EObject getReplCopyElementFromOriginal(EObject originalObject) throws GeneralBVREngineException{
		EObject copyObject = rplCopier.get(originalObject);
		if(copyObject == null){
			throw new GeneralBVREngineException("Copy map for replacement is incorrect, can not find a copy for " + originalObject);
		}
		return copyObject;
	}
	
	private EList<EObject> getReplCopyElementFromOriginal(EList<EObject> originalList) throws GeneralBVREngineException{
		EList<EObject> copyEList = new BasicEList<EObject>();
		for(EObject object : originalList){
			EObject copyObject = rplCopier.get(object);
			if(copyObject == null){
				throw new GeneralBVREngineException("Copy map for replacement is incorrect, can not find a copy for " + object);
			}
			copyEList.add(copyObject);
		}
		return copyEList;
	}
	
	private EList<EObject> getInsideBEToReplacement(ToReplacement toReplacement) throws GeneralBVREngineException{
		EList<EObject> nullList = new BasicEList<EObject>();
		EList<EObject> insideBERepl = (!EngineUtility.isDummyToReplacement(toReplacement)) ? this.getReplCopyElementFromOriginal(EngineUtility.resolveProxies(toReplacement.getInsideBoundaryElement())) : nullList;
		return insideBERepl;
	}
	
	private EObject getInsideBEFromReplacement(FromReplacement fromReplacement) throws GeneralBVREngineException{
		return this.getReplCopyElementFromOriginal(EngineUtility.resolveProxies(fromReplacement.getInsideBoundaryElement()));
	}
		
	private void updateToPlacementInsideBoundaryElements(ToPlacement toPlacement, EList<EObject> insideBoundaryElements) throws UnexpectedOperationFailure{
		toPlacement.getInsideBoundaryElement().clear();
		toPlacement.getInsideBoundaryElement().addAll(EngineUtility.getPlacementObjectHandlesByEObjects(fragSubHolder.getFragment().getPlacement(), insideBoundaryElements));
	}
	
	private void updateToPlacementInsideBoundaryElement(ToPlacement toPlacement, EObject insideBoundaryElement) throws UnexpectedOperationFailure{
		toPlacement.getInsideBoundaryElement().clear();
		EList<EObject> insideBoundaryElements = new BasicEList<EObject>();
		insideBoundaryElements.add(insideBoundaryElement);
		EList<ObjectHandle> objectHandles = EngineUtility.getPlacementObjectHandlesByEObjects(fragSubHolder.getFragment().getPlacement(), insideBoundaryElements);
		toPlacement.getInsideBoundaryElement().add(objectHandles.get(0));
	}
		
	private ObjectHandle getInsideBoundaryElementObjectHandleFromPlacement(FromPlacement fromPlacement, EObject insideBoundaryElement) throws UnexpectedOperationFailure{
		EList<EObject> insideBoundaryElements = new BasicEList<EObject>();
		insideBoundaryElements.add(insideBoundaryElement);
		EList<ObjectHandle> objectHandles = EngineUtility.getPlacementObjectHandlesByEObjects(fragSubHolder.getFragment().getPlacement(), insideBoundaryElements);
		return objectHandles.get(0);
	}
	
	private void updateInsideBoundaryElementObjectHandleBoundaries(ObjectHandle objectHandle, ObjectHandle replacementObjectHandle, boolean replace) throws GeneralBVREngineException{
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
						throw new GeneralBVREngineException("insideBoundaryElement set is null for given fromPlacement, should not happen");
					}
					insideBoundaryElementsSet.add(replacementObjectHandle);
					fromPlacementMap.put(fromPlacement, insideBoundaryElementsSet);
					fragSubHolder.setFromPlacementInsideBoundaryElementMap(fromPlacementMap);
				}
			}
		}
	}
}
