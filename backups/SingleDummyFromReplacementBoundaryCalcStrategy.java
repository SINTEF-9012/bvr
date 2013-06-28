package no.sintef.cvl.ui.strategies.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import cvl.FromReplacement;
import cvl.ReplacementFragmentType;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.strategies.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategies.ReplacementBoundaryCalcStrategy;

public class SingleDummyFromReplacementBoundaryCalcStrategy extends
	AbstractBoundaryCalculator implements ReplacementBoundaryCalcStrategy {

	@Override
	public void calculateBoundaries(ReplacementFragmentType replacement, EList<EObject> selection) {
		//calculate fromReplacement-s
		for(EObject eObject : selection){
			//calculate fromReplacement-s
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
					FromReplacement fromReplacement = testFromReplacementBoundary(replacement, eObject, targetEObject, reference);
					fromReplacement.setInsideBoundaryElement(Utility.testObjectHandle(replacement, null));
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
						FromReplacement fromReplacement = testFromReplacementBoundary(replacement, eObject, trgEObject, reference);
						fromReplacement.setInsideBoundaryElement(Utility.testObjectHandle(replacement, null));
					}
				}
			}
		}
	}
}