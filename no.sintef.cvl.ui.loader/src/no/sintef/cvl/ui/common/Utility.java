package no.sintef.cvl.ui.common;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;

public class Utility {

	public static boolean isNullBoundary(VariationPoint boundary){
		if(boundary instanceof ToReplacement){
			ToReplacement toReplacement = (ToReplacement) boundary;
			if(toReplacement.getName().equals(Constants.NULL_NAME) && toReplacement.getInsideBoundaryElement().isEmpty() && toReplacement.getOutsideBoundaryElement() == null){
				return true;
			}
		}else if(boundary instanceof FromPlacement){
			FromPlacement fromPlacement = (FromPlacement) boundary;
			if(fromPlacement.getName().equals(Constants.NULL_NAME) && fromPlacement.getInsideBoundaryElement() == null && fromPlacement.getOutsideBoundaryElement().isEmpty()){
				return true;
			}
		}else if(boundary instanceof FromReplacement){
			FromReplacement fromReplacement = (FromReplacement) boundary;
			if(fromReplacement.getName().equals(Constants.NULL_NAME) && fromReplacement.getInsideBoundaryElement() == null && fromReplacement.getOutsideBoundaryElement().isEmpty()){
				return true;
			}			
		} else if(boundary instanceof ToPlacement){
			ToPlacement toPlacement = (ToPlacement) boundary;
			if(toPlacement.getName().equals(Constants.NULL_NAME) && toPlacement.getInsideBoundaryElement().isEmpty() && toPlacement.getOutsideBoundaryElement() == null){
				return true;
			}
		}
		return false;
	}
}
