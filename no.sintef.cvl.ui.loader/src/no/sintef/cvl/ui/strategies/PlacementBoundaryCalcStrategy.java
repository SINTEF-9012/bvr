package no.sintef.cvl.ui.strategies;

import cvl.PlacementFragment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface PlacementBoundaryCalcStrategy {
	
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection);	
}
