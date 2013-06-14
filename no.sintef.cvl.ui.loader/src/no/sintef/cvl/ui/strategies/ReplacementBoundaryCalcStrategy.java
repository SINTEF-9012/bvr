package no.sintef.cvl.ui.strategies;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.ReplacementFragmentType;

public interface ReplacementBoundaryCalcStrategy {

	public void calculateBoundaries(ReplacementFragmentType replacement, EList<EObject> selection);
}
