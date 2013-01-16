package no.sintef.cvl.engine.adjacent.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FromBinding;
import cvl.ObjectHandle;
import cvl.ToBinding;

import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentResolverImpl implements AdjacentResolver {

	private AdjacentFinder adjacentFinder;

	public AdjacentResolverImpl(AdjacentFinder finder){
		this.adjacentFinder = finder;
	}
	
	@Override
	public void resolve(FragSubHolder fragmentHolder) throws GeneralCVLEngineException {
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
				EList<ObjectHandle> outsideBOHElmtsRplc = fromBinding.getFromReplacement().getOutsideBoundaryElement();
								
				if(this.isOutsideBoundaryInvalid(outsideBOHElmtsPlc)){
					fromBinding.getFromPlacement().getOutsideBoundaryElement().clear();
					fromBinding.getFromPlacement().getOutsideBoundaryElement().addAll(outsideBOHElmtsRplc);
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
		EList<EObject> resolvedObjects = this.resolveObjectHandles(objectHandles);
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
	
	private EList<EObject> resolveObjectHandles(EList<ObjectHandle> objectHandles){
		EList<EObject> list = new BasicEList<EObject>();
		for(ObjectHandle oh : objectHandles){
			list.add(oh.getMOFRef());
		}
		return list;
	}
}
