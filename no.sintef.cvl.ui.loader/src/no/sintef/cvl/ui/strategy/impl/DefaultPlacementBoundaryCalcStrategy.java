package no.sintef.cvl.ui.strategy.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.PlacementFragment;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.strategy.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategy.PlacementBoundaryCalcStrategy;

public class DefaultPlacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements PlacementBoundaryCalcStrategy {
	
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
				this.testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				this.testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			
			//calculate fromPlacement-s
			EList<EReference> references = eObject.eClass().getEAllReferences();
			for(EStructuralFeature reference : references){
				Object targetObject = eObject.eGet(reference);
				if(reference.getUpperBound() == 1){
					if(!(targetObject instanceof EObject))
						continue;
					EObject targetEObject = (EObject) targetObject;
					if(selection.indexOf(targetEObject) >= 0)
						continue;
					if(!isReferenceToCut(reference))
						continue;
					this.testFromPlacementBoundary(placement, eObject, targetEObject, reference);
				}else{
					EList<?> targetListObjects = (EList<?>) targetObject;
					for(Object object : targetListObjects){
						if(!(object instanceof EObject))
							continue;
						EObject trgEObject = (EObject) object;
						if(selection.indexOf(trgEObject) >= 0)
							continue;
						if(!isReferenceToCut(reference))
							continue;
						this.testFromPlacementBoundary(placement, eObject, trgEObject, reference);
					}
				}
			}
		}
		Utility.testNullFromPlacement(placement);
	}
}
