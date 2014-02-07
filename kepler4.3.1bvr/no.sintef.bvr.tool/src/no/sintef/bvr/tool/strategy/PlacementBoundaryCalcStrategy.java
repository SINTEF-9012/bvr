package no.sintef.bvr.tool.strategy;

import bvr.PlacementFragment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface PlacementBoundaryCalcStrategy {
	
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection);	
}
