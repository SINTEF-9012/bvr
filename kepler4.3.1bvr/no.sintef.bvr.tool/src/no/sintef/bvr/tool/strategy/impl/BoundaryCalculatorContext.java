package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;

import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.strategy.BoundaryCalculatorStrategy;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ToPlacement;
import bvr.VariationPoint;

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
	
	public ArrayList<NamedElement> getCompliedBoundaries(NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError{
		ArrayList<NamedElement> compliedVP;
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
