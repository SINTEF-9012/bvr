package no.sintef.cvl.ui.strategies.impl;

import java.util.ArrayList;

import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.strategies.BoundaryCalculatorStrategy;

import cvl.FromReplacement;
import cvl.ToPlacement;
import cvl.VariationPoint;

public class BoundaryCalculatorContext {

	private BoundaryCalculatorStrategy defualtToPlacementStrategy;
	private BoundaryCalculatorStrategy defaultFromReplacementStrategy;

	public BoundaryCalculatorContext(BoundaryCalculatorStrategy toPlacementStrategy, BoundaryCalculatorStrategy fromReplacementStrategy){
		defualtToPlacementStrategy = toPlacementStrategy;
		defaultFromReplacementStrategy = fromReplacementStrategy;
	}
	
	public BoundaryCalculatorContext(){
		defualtToPlacementStrategy = new ToPlacementBoundaryCalculator();
		defaultFromReplacementStrategy = new FromReplacementBoundaryCalculator();
	}
	
	public ArrayList<VariationPoint> getCompliedBoundaries(VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError{
		ArrayList<VariationPoint> compliedVP;
		if(forBoundary instanceof ToPlacement){
			compliedVP = defualtToPlacementStrategy.getCompliedBoundaries(forBoundary, options);
		} else if(forBoundary instanceof FromReplacement){
			compliedVP = defaultFromReplacementStrategy.getCompliedBoundaries(forBoundary, options);
		}else{
			throw new UnsupportedOperationException("stategy is not defined for this type of boundary" + forBoundary.eClass());
		}
		return compliedVP;
	}
}
