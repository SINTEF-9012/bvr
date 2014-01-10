package no.sintef.cvl.tool.strategy.impl;

import no.sintef.cvl.tool.strategy.PlacementBoundaryCalcStrategy;
import no.sintef.cvl.tool.strategy.ReplacementBoundaryCalcStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

public class CreateBoundaryContext {

	private PlacementBoundaryCalcStrategy defaultPlacementCalc;
	private ReplacementBoundaryCalcStrategy defaultReplacementCalc;

	public CreateBoundaryContext(){
		defaultPlacementCalc = new DefaultPlacementBoundaryCalcStrategy();
		defaultReplacementCalc = new DefaultReplacementBoundaryCalcStrategy();
	}
	
	public CreateBoundaryContext(PlacementBoundaryCalcStrategy placementCalcStrategy, ReplacementBoundaryCalcStrategy replacementCalcStrategy){
		defaultPlacementCalc = placementCalcStrategy;
		defaultReplacementCalc = replacementCalcStrategy;
	}
	
	public void creatBoundaries(NamedElement fragment, EList<EObject> selectedElements){
		PlacementFragment placement = null;
		ReplacementFragmentType replacement = null;
		if(fragment instanceof PlacementFragment && defaultPlacementCalc != null){
			placement = (PlacementFragment) fragment;
			defaultPlacementCalc.calculateBoundaries(placement, selectedElements);
		}else if (fragment instanceof ReplacementFragmentType && defaultReplacementCalc != null){
			replacement = (ReplacementFragmentType) fragment;
			defaultReplacementCalc.calculateBoundaries(replacement, selectedElements);
		}else{
			throw new UnsupportedOperationException("fragment should be either PlacementFragment or ReplacementFragmentType; is corresponding strategy set?");
		}
	}
}
