package no.sintef.cvl.ui.algorithms;

import java.util.ArrayList;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.CVLModelException;

import cvl.ToReplacement;
import cvl.VariationPoint;

public class ToPlacementBoundaryCalculator extends BoundaryCalculatorStrategy {
	
	ToReplacement nullToReplacement = null;

	@Override
	public ArrayList<VariationPoint> getCompliedBoundaries(
			VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError {
		ArrayList<VariationPoint> toReplacements = new ArrayList<VariationPoint>();
		for(VariationPoint boundary : options){
			if(Utility.isNullBoundary(boundary)){
				nullToReplacement = (ToReplacement) boundary;
			}else{
				//smart things here;
				toReplacements.add(boundary);
			}
		}
		if(nullToReplacement == null){
			throw new CVLModelException("can not find NULL boundary of the type ToReplacement");
		}
		toReplacements.add(0, nullToReplacement);
		return toReplacements;
	}

}
