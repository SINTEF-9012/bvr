package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cvl.BoundaryElementBinding;
import cvl.FromBinding;
import cvl.ObjectHandle;
import cvl.ToBinding;

import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.IllegalCVLOperation;
import no.sintef.cvl.engine.error.IncorrectCVLModel;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentResolverImpl implements AdjacentResolver {

	private AdjacentFinder adjacentFinder;

	public AdjacentResolverImpl(AdjacentFinder finder){
		this.adjacentFinder = finder;
	}
	
	@Override
	public void resolve(FragSubHolder fragmentHolder) throws BasicCVLEngineException {
		AdjacentFragment aFrag = this.adjacentFinder.getAdjacentMap().get(fragmentHolder);
		if(aFrag == null){
			return;
		}
		EList<AdjacentFragment> adjacentFragments = aFrag.getAdjacentFragments();
		if(adjacentFragments.isEmpty()){
			throw new GeneralCVLEngineException("can not find any adjacent fragments to the fragment that seems to be adjacent" + fragmentHolder);
		}
		for(AdjacentFragment adjacentFragment : adjacentFragments){
			FragSubHolder fragHolder = adjacentFragment.getFragmentHolder();
			EList<FromBinding> fromBindings = fragHolder.getFromBinding();
			EList<ToBinding> toBindings = fragHolder.getToBindings();
			
			for(FromBinding fromBinding : fromBindings){
				EList<ObjectHandle> outsideBOHElmtsPlc = fromBinding.getFromPlacement().getOutsideBoundaryElement();
								
				if(this.isOutsideBoundaryInvalid(outsideBOHElmtsPlc)){		
					//update references of the object which point to outside elements
					HashMap<FromBinding, ToBinding> adjacentBindings = Utility.reverseMap(aFrag.getAdjacentBindingsRev(adjacentFragment));
					EList<ObjectHandle> insideBOHElmtsPlcReplaced = adjacentBindings.get(fromBinding).getToPlacement().getInsideBoundaryElement();
					EObject insideBoundaryElementPlc = Utility.resolveProxies(fromBinding.getFromPlacement().getInsideBoundaryElement());
					String propertyName = fromBinding.getFromReplacement().getPropertyName();
					EStructuralFeature property = insideBoundaryElementPlc.eClass().getEStructuralFeature(propertyName);
					if(property == null){
						throw new GeneralCVLEngineException("failed to find property to adjust, property name : " + propertyName);
					}
					int upperBound = property.getUpperBound();
					if(upperBound == -1 || upperBound > 1){
						EList<EObject> values = Utility.getListPropertyValue(insideBoundaryElementPlc, property);
						EList<EObject> propertyValueNew = Utility.subtractAugmentList(values, Utility.resolveProxies(outsideBOHElmtsPlc), Utility.resolveProxies(insideBOHElmtsPlcReplaced));
						if(upperBound != -1 && propertyValueNew.size() > upperBound){
							throw new IllegalCVLOperation("cardinality does not correspond for property : " + propertyName + "of" + fragHolder.getFragment());
						}
						insideBoundaryElementPlc.eSet(property, propertyValueNew);
						EList<EObject> propertyValueSet = Utility.getListPropertyValue(insideBoundaryElementPlc, property);
						if(!propertyValueNew.equals(propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragHolder.getFragment());
						}
					}else{
						//property.getUpperBound() == 0 || == 1
						if(upperBound == 0){
							throw new IncorrectCVLModel("model is incorrect, cardianlity for reference is set to 0, but something is there" + insideBoundaryElementPlc.eGet(property));
						}
						if(insideBOHElmtsPlcReplaced.size() != upperBound){
							throw new IllegalCVLOperation("cardinality does not match for property :" + propertyName + "of" + fragHolder.getFragment());
						}

						EObject propertyValueNew = Utility.resolveProxies(insideBOHElmtsPlcReplaced).get(0);
						insideBoundaryElementPlc.eSet(property, propertyValueNew);
						Object propertyValueSet = insideBoundaryElementPlc.eGet(property);
						if(!propertyValueNew.equals(propertyValueSet)){
							throw new UnexpectedOperationFailure("EPIC FAIL: property has not been adjusted : " + propertyName + "of" + fragHolder.getFragment());
						}						
					}
					
					//update variability model : boundaries so the point to the correct elements
					fromBinding.getFromPlacement().getOutsideBoundaryElement().clear();
					fromBinding.getFromPlacement().getOutsideBoundaryElement().addAll(insideBOHElmtsPlcReplaced);
				}
			}
			for(ToBinding toBinding : toBindings){
				ObjectHandle outsideBOHElmtPlc = toBinding.getToPlacement().getOutsideBoundaryElement();
				ObjectHandle outsideBOHElmtRplc = toBinding.getToReplacement().getOutsideBoundaryElement();
				
				EList<ObjectHandle> outsideList = new BasicEList<ObjectHandle>();
				outsideList.add(outsideBOHElmtPlc);
				if(this.isOutsideBoundaryInvalid(outsideList)){
					toBinding.getToPlacement().setOutsideBoundaryElement(outsideBOHElmtRplc);
				}
			}
		}
	}
	
	private boolean isOutsideBoundaryInvalid(EList<ObjectHandle> objectHandles) throws GeneralCVLEngineException{
		EList<EObject> resolvedObjects = Utility.resolveProxies(objectHandles);
		if(resolvedObjects.size() != objectHandles.size()){
			throw new GeneralCVLEngineException("EPIC FAIL: we lose something after resolution");
		}
		boolean allInvalid = this.isAllInvalid(resolvedObjects);
		boolean allValid = this.isAllValid(resolvedObjects);
		if(!allInvalid && !allValid){
			throw new GeneralCVLEngineException("EPIC FAIL: Some elements in the resource, while others not");
		}
		return allInvalid;
	}
	
	private boolean isAllValid(EList<EObject> objectList){
		for(EObject eObject : objectList){
			if(eObject.eResource() == null){
				return false;
			}
		}
		return true;
	}
	
	private boolean isAllInvalid(EList<EObject> objectList){
		for(EObject eObject : objectList){
			if(eObject.eResource() != null){
				return false;
			}
		}
		return true;
	}
}
