package no.sintef.cvl.engine.operation.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.utils.EMFCompareCopier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.BoundaryElementBinding;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;

import no.sintef.cvl.engine.common.CVLFragmentCopier;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.UnimplementedException;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.operation.Substitution;

public class FragmentSubOperation implements Substitution {

	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private CVLFragmentCopier rplCopier;
	private boolean replace;


	public FragmentSubOperation(PlacementElementHolder placement, ReplacementElementHolder replacement){
		this.placement = placement;
		this.replacement = replacement;
	}
	
	@Override
	public void execute(boolean replace) throws BasicCVLEngineException {
		this.copyReplacementElements();
		this.replace = replace;
		this.bindBounderies();
	}
	
	private void copyReplacementElements() {
		rplCopier = new CVLFragmentCopier();
		HashSet<EObject> replacementInnerElements = replacement.getElements();
		rplCopier.copyAll(replacementInnerElements);
		rplCopier.copyReferences();
	}


	private EObject getInsideBoundaryElementReplCopy(EObject originalObject) throws GeneralCVLEngineException{
		EObject copyObject = rplCopier.get(originalObject);
		if(copyObject == null){
			throw new GeneralCVLEngineException("Copy map for replacement is incorrect, can not find a copy for " + originalObject);
		}
		return copyObject;
	}
	
	private EList<EObject> getInsideBoundaryElementReplCopyList(EList<EObject> originalList) throws GeneralCVLEngineException{
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
	
	private void bindBounderies() throws BasicCVLEngineException {
		FragmentSubstitution fragSub = placement.getFragmentSubstitution();
		EList<BoundaryElementBinding> bindings = fragSub.getBoundaryElementBinding();
		for(BoundaryElementBinding be : bindings){
			if(be instanceof ToBinding){
				ToBinding tb = (ToBinding) be;
				ToPlacement toPlacement = tb.getToPlacement();
				ToReplacement toReplacement = tb.getToReplacement();
				String propertyName = toPlacement.getPropertyName();				
				
				EObject outsidePla = toPlacement.getOutsideBoundaryElement();
				EList<EObject> propertyValue = (EList) outsidePla.eGet(outsidePla.eClass().getEStructuralFeature(propertyName));
				propertyValue = this.calcultePropertyList(propertyValue, (this.replace) ? toPlacement.getInsideBoundaryElement() : new BasicEList<EObject>(), this.getInsideBoundaryElementReplCopyList(toReplacement.getInsideBoundaryElement()));
				outsidePla.eSet(outsidePla.eClass().getEStructuralFeature(propertyName), propertyValue);
				
			}
			if(be instanceof FromBinding){
				FromBinding fb = (FromBinding) be;
				FromPlacement fromPlacement = fb.getFromPlacement();
				FromReplacement fromReplacement = fb.getFromReplacement();
				String propertyName = fromReplacement.getPropertyName();
				
				EObject objectInsideRepl = getInsideBoundaryElementReplCopy(fromReplacement.getInsideBoundaryElement());
				EList<EObject> propertyValue = (EList) objectInsideRepl.eGet(objectInsideRepl.eClass().getEStructuralFeature(propertyName));
				propertyValue = this.calcultePropertyList(propertyValue, fromReplacement.getOutsideBoundaryElement(), fromPlacement.getOutsideBoundaryElement());
				objectInsideRepl.eSet(objectInsideRepl.eClass().getEStructuralFeature(propertyName), propertyValue);
			}
		}
		
	}
	
	
	private EList<EObject> calcultePropertyList(EList<EObject> elementsOrig, EList<EObject> elementsToRemove, EList<EObject> elementsToAdd){
		elementsOrig.removeAll(elementsToRemove);
		elementsOrig.addAll(elementsToAdd);
		EList<EObject> eList = new BasicEList<EObject>();
		eList.addAll(elementsOrig);
		return eList;
	}

}
