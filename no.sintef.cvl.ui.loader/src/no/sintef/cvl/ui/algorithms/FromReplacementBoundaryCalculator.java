package no.sintef.cvl.ui.algorithms;

import java.util.ArrayList;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.CVLModelException;

import cvl.FromPlacement;
import cvl.VariationPoint;

public class FromReplacementBoundaryCalculator extends
		BoundaryCalculatorStrategy {

	FromPlacement nullFromPlacement = null;
	@Override
	public ArrayList<VariationPoint> getCompliedBoundaries(
			VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError {
		ArrayList<VariationPoint> fromPlacements = new ArrayList<VariationPoint>();
		for(VariationPoint boundary : options){
			if(Utility.isNullBoundary(boundary)){
				nullFromPlacement = (FromPlacement) boundary;
			}else{
				//smart things here
				fromPlacements.add(boundary);
			}
		}
		if(nullFromPlacement == null){
			throw new CVLModelException("can not find NULL boundary of the type FromPlacement");
		}
		fromPlacements.add(0, nullFromPlacement);
		return fromPlacements;
	}

}
