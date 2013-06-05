package no.sintef.cvl.ui.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;

public class Utility {

	public static String TOPLCMNT = "toPlacement";
	public static String FROMPLCMNT = "fromPlacement";
	public static String TOREPLCMNT = "toReplacement";
	public static String FROMREPLCMNT = "fromReplacement";
	
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
	
	public static EList<EObject> resolveProxies(EList<ObjectHandle> proxyList){
		EList<EObject> resolvedList = new BasicEList<EObject>();
		for(ObjectHandle proxy : proxyList){
			EObject resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
			resolvedList.add(resolvedProxy);
		}
		return resolvedList;
	}
	
	public static HashMap<String, ArrayList<VariationPoint>> filterOutBoundariesByType(PlacementFragment placement, ReplacementFragmentType replacement){
		HashMap<String, ArrayList<VariationPoint>> boundariesMap = new HashMap<String, ArrayList<VariationPoint>>();
		ArrayList<VariationPoint> toPlacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> fromPlacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> toReplacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> fromReplacements = new ArrayList<VariationPoint>();
		
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		for(PlacementBoundaryElement boundary : placementBoundaries){
			if(boundary instanceof ToPlacement){
				toPlacements.add((ToPlacement) boundary);
			}
			if(boundary instanceof FromPlacement){
				fromPlacements.add((FromPlacement) boundary);
			}
		}
		for(ReplacementBoundaryElement boundary : replacementBoundaries){
			if(boundary instanceof ToReplacement){
				toReplacements.add((ToReplacement) boundary);
			}
			if(boundary instanceof FromReplacement){
				fromReplacements.add((FromReplacement) boundary);
			}			
		}
		boundariesMap.put(TOPLCMNT, toPlacements);
		boundariesMap.put(FROMPLCMNT, fromPlacements);
		boundariesMap.put(TOREPLCMNT, toReplacements);
		boundariesMap.put(FROMREPLCMNT, fromReplacements);
		return boundariesMap;
	}
}
