package no.sintef.cvl.ui.strategies.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.CvlFactory;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.strategies.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategies.ReplacementBoundaryCalcStrategy;

public class DefaultReplacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements ReplacementBoundaryCalcStrategy {
	
	@Override
	public void calculateBoundaries(ReplacementFragmentType replacement, EList<EObject> selection) {
		for(EObject eObject : selection){
			//calculate toReplacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				if(!isReferenceToCut(property))
					continue;
				this.testToReplacementBoundary(replacement, sourceEObject, eObject, property);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				this.testToReplacementBoundary(replacement, sourceEObject, eObject, property);
			}
			
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
					this.testFromReplacementBoundary(replacement, eObject, targetEObject, reference);
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
						this.testFromReplacementBoundary(replacement, eObject, trgEObject, reference);
					}
				}
			}
		}
		this.createNullToReplacement(replacement);
	}
}
