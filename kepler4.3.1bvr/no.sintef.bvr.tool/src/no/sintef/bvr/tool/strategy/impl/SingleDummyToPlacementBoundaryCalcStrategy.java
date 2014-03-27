package no.sintef.bvr.tool.strategy.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ToPlacement;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.strategy.AbstractBoundaryCalculator;
import no.sintef.bvr.tool.strategy.PlacementBoundaryCalcStrategy;

public class SingleDummyToPlacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements PlacementBoundaryCalcStrategy {

	@Override
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection) {
		for(EObject eObject : selection){
			//calculate toPlacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				if(!isReferenceToCut(property))
					continue;
				ToPlacement toPlacement = testToPlacementBoundary(placement, sourceEObject, eObject, property);
				
				//since when we generate a a new toPlacement, the boundary does not really cut any reference going inside the placement fragment
				//therefore insideBoundaryElement should not point to any specific element
				//toPlacement.getInsideBoundaryElement().clear();
				//toPlacement.getInsideBoundaryElement().add(LoaderUtility.testObjectHandle(placement, null));
				Context.eINSTANCE.getEditorCommands().clearInsideBElementToPlacement(toPlacement);
				ObjectHandle objectHandle = LoaderUtility.testObjectHandle(placement, null);
				Context.eINSTANCE.getEditorCommands().addInsideBElementToPlacement(toPlacement, objectHandle);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				ToPlacement toPlacement = testToPlacementBoundary(placement, sourceEObject, eObject, property);
				//since when we generate a a new toPlacement, the boundary does not really cut any reference going inside the placement fragment
				//therefore insideBoundaryElement should not point to any specific element
				//toPlacement.getInsideBoundaryElement().clear();
				//toPlacement.getInsideBoundaryElement().add(LoaderUtility.testObjectHandle(placement, null));
				Context.eINSTANCE.getEditorCommands().clearInsideBElementToPlacement(toPlacement);
				ObjectHandle objectHandle = LoaderUtility.testObjectHandle(placement, null);
				Context.eINSTANCE.getEditorCommands().addInsideBElementToPlacement(toPlacement, objectHandle);
			}
		}
	}
}
