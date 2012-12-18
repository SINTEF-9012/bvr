package no.sintef.cvl.engine.operation.impl;

import java.util.HashSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;

import no.sintef.cvl.engine.common.CVLFragmentCopier;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.IllegalCVLOperation;
import no.sintef.cvl.engine.error.IncorrectCVLModel;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.operation.Substitution;

public class FragmentSubOperation implements Substitution {

	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private CVLFragmentCopier rplCopier;
	private FragmentSubstitutionHolder fragSubHolder;


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

	private void bindBounderies(boolean replace) throws BasicCVLEngineException{
		EList<ToBinding> toBindings = fragSubHolder.getToBindings();
		EList<FromBinding> fromBindings = fragSubHolder.getFromBinding();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			ToReplacement toReplacement = toBinding.getToReplacement();
			if(toPlacement != null && toReplacement != null){
				String propertyName = toPlacement.getPropertyName();
				EObject outsideBEPlac = toPlacement.getOutsideBoundaryElement();
				EList<EObject> insideBERepl = this.getInsideBEToReplacement(toReplacement);
				EStructuralFeature property = outsideBEPlac.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				EList<EObject> insideBEPlacCurrent = toPlacement.getInsideBoundaryElement();
				int upperBound = property.getUpperBound();
				if(upperBound == -1 || upperBound > 1){
					EList<EObject> propertyValueOutBEPlac = this.getListPropertyValue(outsideBEPlac, property);
					EList<EObject> elemenetsToRemove = (replace) ? insideBEPlacCurrent : new BasicEList<EObject>();
					EList<EObject> propertyValueNew = this.subtractAugmentList(propertyValueOutBEPlac, elemenetsToRemove, insideBERepl);
					if(upperBound != -1 && propertyValueNew.size() > upperBound){
						throw new IllegalCVLOperation("Cordinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					outsideBEPlac.eSet(property, propertyValueNew);
					EList<EObject> propertyValueSet = this.getListPropertyValue(outsideBEPlac, property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					
					//update insideBoundaryElements of the reference 
					EList<EObject> insideBEPlacNew = this.subtractAugmentList(insideBEPlacCurrent, elemenetsToRemove, insideBERepl);
					insideBEPlacCurrent.clear();
					insideBEPlacCurrent.addAll(insideBEPlacNew);
				}else{
					//property.getUpperBound() == 0 || == 1
					if(upperBound == 0){
						throw new IncorrectCVLModel("Model is incorrect, cardianlity for reference is set to 0, but something is there" + outsideBEPlac.eGet(property));
					}
					if(insideBERepl.size() != upperBound){
						throw new IllegalCVLOperation("Cardinality does not match for property :" + propertyName + "of" + fragSubHolder.getFragment());
					}
					Object propertyValueOutBEPlac = outsideBEPlac.eGet(property);
					if(propertyValueOutBEPlac != null && !replace){
						throw new IllegalCVLOperation("Replace flag is set to false, but the cardinality is 1 and property is not empty already");
					}
					if(insideBEPlacCurrent.size() > 1){
						throw new GeneralCVLEngineException("EPIC FAIL: Holy crap, the insideBoundatyElement reference seems to reference more then one element, while the cardinality is 1");
					}
					
					EObject propertyValueNew = insideBERepl.get(0);
					outsideBEPlac.eSet(property, propertyValueNew);
					Object propertyValueSet = outsideBEPlac.eGet(property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					
					//update insideBoundaryElements of the reference 
					insideBEPlacCurrent.clear();
					insideBEPlacCurrent.add(propertyValueNew);
				}
			}else if(toPlacement != null && toReplacement == null){
				String propertyName = toPlacement.getPropertyName();
				EObject outsideBEPlac = toPlacement.getOutsideBoundaryElement();
				EStructuralFeature property = outsideBEPlac.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				EList<EObject> insideBEPlacCurrent = toPlacement.getInsideBoundaryElement();
				int upperBound = property.getUpperBound();
				if(upperBound == -1 || upperBound > 1){
					EList<EObject> propertyValueOutBEPlac = this.getListPropertyValue(outsideBEPlac, property);
					EList<EObject> propertyValueNew = this.subtractAugmentList(propertyValueOutBEPlac, insideBEPlacCurrent, new BasicEList<EObject>());
					if(upperBound != -1 && propertyValueNew.size() > upperBound){
						throw new IllegalCVLOperation("Cordinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					outsideBEPlac.eSet(property, propertyValueNew);
					EList<EObject> propertyValueSet = this.getListPropertyValue(outsideBEPlac, property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					
					//update insideBoundaryElements of the reference 
					insideBEPlacCurrent.clear();
				}else{
					if(upperBound == 0){
						throw new IncorrectCVLModel("Model is incorrect, cardianlity for reference is set to 0, but something is there" + outsideBEPlac.eGet(property));
					}
					if(insideBEPlacCurrent.size() > 1){
						throw new GeneralCVLEngineException("EPIC FAIL: Holy crap, the insideBoundatyElement reference seems to reference more then one element, while the cardinality is 1");
					}
					outsideBEPlac.eSet(property, null);
					Object propertyValueSet = outsideBEPlac.eGet(property);
					if(propertyValueSet != null){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					
					//update insideBoundaryElements of the reference 
					insideBEPlacCurrent.clear();
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
				EList<EObject> outsideBEPlac = fromPlacement.getOutsideBoundaryElement();
				EObject insideBERepl = this.getInsideBEFromReplacement(fromReplacement);
				EStructuralFeature property = insideBERepl.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				EList<EObject> outsideBEReplCurrent = fromReplacement.getOutsideBoundaryElement();
				int upperBound = property.getUpperBound();
				if(upperBound == -1 || upperBound > 1){
					EList<EObject> propertyValueInsBERepl = this.getListPropertyValue(insideBERepl, property);
					EList<EObject> propertyValueNew = this.subtractAugmentList(propertyValueInsBERepl, outsideBEReplCurrent, outsideBEPlac);
					if(upperBound != -1 && propertyValueNew.size() > upperBound){
						throw new IllegalCVLOperation("Cordinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					insideBERepl.eSet(property, propertyValueNew);
					EList<EObject> propertyValueSet = this.getListPropertyValue(insideBERepl, property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
				}else{
					//property.getUpperBound() == 0 || == 1
					if(upperBound == 0){
						throw new IncorrectCVLModel("Model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBERepl.eGet(property));
					}
					if(outsideBEPlac.size() != upperBound){
						throw new IllegalCVLOperation("Cardinality does not match for property :" + propertyName + "of" + fragSubHolder.getFragment());
					}
					Object propertyValueInsBERepl = insideBERepl.eGet(property);
					if(propertyValueInsBERepl != null && !replace){
						throw new IllegalCVLOperation("Replace flag is set to false, but the cardinality is 1 and property is not empty already");
					}
					if(outsideBEReplCurrent.size() > 1){
						throw new GeneralCVLEngineException("EPIC FAIL: Holy crap, the outsideBoundatyElement reference seems to point more then one element, while the cardinality is 1");
					}
					
					EObject propertyValueNew = outsideBEPlac.get(0);
					insideBERepl.eSet(property, propertyValueNew);
					Object propertyValueSet = insideBERepl.eGet(property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}				
				}
			}else if(fromReplacement != null && fromPlacement == null){
				String propertyName = fromReplacement.getPropertyName();
				EObject insideBERepl = fromReplacement.getInsideBoundaryElement();
				EStructuralFeature property = insideBERepl.eClass().getEStructuralFeature(propertyName);
				if(property == null){
					throw new GeneralCVLEngineException("failed to find property to bind, property name : " + propertyName);
				}
				EList<EObject> outsideBEReplCurrent = fromReplacement.getOutsideBoundaryElement();
				int upperBound = property.getUpperBound();
				if(upperBound == -1 || upperBound > 1){
					EList<EObject> propertyValueInsBERepl = this.getListPropertyValue(insideBERepl, property);
					EList<EObject> propertyValueNew = this.subtractAugmentList(propertyValueInsBERepl, outsideBEReplCurrent, new BasicEList<EObject>());
					if(upperBound != -1 && propertyValueNew.size() > upperBound){
						throw new IllegalCVLOperation("Cordinality does not correspond for property : " + propertyName + "of" + fragSubHolder.getFragment());
					}
					insideBERepl.eSet(property, propertyValueNew);
					EList<EObject> propertyValueSet = this.getListPropertyValue(insideBERepl, property);
					if(!propertyValueNew.equals(propertyValueSet)){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
				}else{
					if(upperBound == 0){
						throw new IncorrectCVLModel("Model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBERepl.eGet(property));
					}
					if(outsideBEReplCurrent.size() > 1){
						throw new GeneralCVLEngineException("EPIC FAIL: Holy crap, the insideBoundatyElement reference seems to reference more then one element, while the cardinality is 1");
					}
					insideBERepl.eSet(property, null);
					Object propertyValueSet = insideBERepl.eGet(property);
					if(propertyValueSet != null){
						throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragSubHolder.getFragment());
					}
				}
			}else{
				throw new IncorrectCVLModel("fromPlacement and fromReplacement are null or fromReplacement is null! It seems to be incorrect!");
			}	
		}
	}
		
	private EList<EObject> subtractAugmentList(EList<EObject> elementsOrig, EList<EObject> elementsToRemove, EList<EObject> elementsToAdd){
		elementsOrig.removeAll(elementsToRemove);
		elementsOrig.addAll(elementsToAdd);
		EList<EObject> eList = new BasicEList<EObject>();
		eList.addAll(elementsOrig);
		return eList;
	}

	private void copyReplacementElements() {
		rplCopier = new CVLFragmentCopier();
		HashSet<EObject> replacementInnerElements = replacement.getElements();
		rplCopier.copyAll(replacementInnerElements);
		rplCopier.copyReferences();
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
		EList<EObject> insideBERepl = toReplacement.getInsideBoundaryElement();
		return this.getReplCopyElementFromOriginal(insideBERepl);
	}
	
	private EObject getInsideBEFromReplacement(FromReplacement fromReplacement) throws GeneralCVLEngineException{
		return this.getReplCopyElementFromOriginal(fromReplacement.getInsideBoundaryElement());
	}
	
	private EList<EObject> getListPropertyValue(EObject holder, EStructuralFeature property) throws GeneralCVLEngineException{
		Object propertyValue = holder.eGet(property);
		if(!(propertyValue instanceof EList)){
			throw new GeneralCVLEngineException("property is not the list " + propertyValue);
		}
		EList<EObject> eList = (EList<EObject>) propertyValue;
		return eList;
	}
}
