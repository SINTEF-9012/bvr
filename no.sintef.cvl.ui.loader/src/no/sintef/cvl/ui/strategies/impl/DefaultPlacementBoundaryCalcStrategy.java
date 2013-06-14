package no.sintef.cvl.ui.strategies.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.PlacementFragment;
import no.sintef.cvl.ui.strategies.PlacementBoundaryCalcStrategy;

public class DefaultPlacementBoundaryCalcStrategy implements
		PlacementBoundaryCalcStrategy {

	@Override
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection) {
		for(EObject eObject : selection){
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			EList<EObject> referencers = new BasicEList<EObject>();
			for(Setting setting : refSittings){
				EObject refEObject = setting.getEObject();
				if(selection.indexOf(refEObject) < 0){
					referencers.add(refEObject);
				}
			}
		}
	}
}
