package no.sintef.cvl.ui.dropdowns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JLabel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.adapters.impl.DataBoundaryItem;
import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.CVLModelException;
import no.sintef.cvl.ui.exceptions.PlacementReplacementNullException;
import no.sintef.ict.splcatool.CVLException;
import cvl.BoundaryElementBinding;
import cvl.FragmentSubstitution;
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

public class BoundariesDropDownCalculator {
	
	private static String TOPLCMNT = "toPlacement";
	private static String FROMPLCMNT = "fromPlacement";
	private static String TOREPLCMNT = "toReplacement";
	private static String FROMREPLCMNT = "fromReplacement";

	public static HashMap<DataItem, ArrayList<DataItem>> calulateAllowedBoundaries(FragmentSubstitution fs) throws AbstractError{
		HashMap<DataItem, ArrayList<DataItem>> map = new HashMap<DataItem, ArrayList<DataItem>>();
		PlacementFragment placement = fs.getPlacement();
		ReplacementFragmentType replacement = fs.getReplacement();
		if(placement == null || replacement == null){
			throw new PlacementReplacementNullException("placement or replacement is null however it should be at this point this way, or we should handle it somehow"); 
		}
		
		HashMap<String, ArrayList<VariationPoint>> fileterdBoundaries = filterOutBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacements = fileterdBoundaries.get(TOPLCMNT);
		ArrayList<VariationPoint> toReplacements = fileterdBoundaries.get(TOREPLCMNT);
		VariationPoint nullToReplacement = getNullBoundary(toReplacements);
		if(nullToReplacement == null){
			throw new CVLModelException("can not find NULL boundary of the type ToReplacement");
		}
		toReplacements.remove(nullToReplacement);
		for(VariationPoint toPlacement : toPlacements){
			ArrayList<VariationPoint> toReplcmnts = getCompliedToReplacements((ToPlacement) toPlacement, toReplacements);
			toReplcmnts.add(0, nullToReplacement);
			
			DataNamedElementItem toPlacementDataItem = new DataNamedElementItem(new JLabel(toPlacement.getName()), toPlacement);
			ArrayList<DataItem> toReplcmntsDataItem = wrapBoundaries(toReplcmnts);
			
			map.put(toPlacementDataItem, toReplcmntsDataItem);
		}
		
		ArrayList<VariationPoint> fromReplacements = fileterdBoundaries.get(FROMREPLCMNT);
		ArrayList<VariationPoint> fromPlacements = fileterdBoundaries.get(FROMPLCMNT);
		VariationPoint nullFromPlacement = getNullBoundary(fromPlacements);
		if(nullFromPlacement == null){
			throw new CVLModelException("can not find NULL boundary of the type FromPlacement");
		}
		fromPlacements.remove(nullFromPlacement);
		for(VariationPoint fromReplacement : fromReplacements){
			ArrayList<VariationPoint> fromPlcmnts = getCompliedFromPlacements((FromReplacement) fromReplacement, fromPlacements);
			fromPlcmnts.add(0, nullFromPlacement);
			
			DataNamedElementItem fromReplacementDataItem = new DataNamedElementItem(new JLabel(fromReplacement.getName()), fromReplacement);
			ArrayList<DataItem> fromPlcmntsDataItem = wrapBoundaries(fromPlcmnts);
			
			map.put(fromReplacementDataItem, fromPlcmntsDataItem);
		}
		
		return map;
	}
	
	private static VariationPoint getNullBoundary(ArrayList<VariationPoint> boundaries){
		for(VariationPoint boundary : boundaries){
			if(boundary instanceof ToReplacement){
				ToReplacement toReplacement = (ToReplacement) boundary;
				if(toReplacement.getName().equals(Constants.NULL_NAME) && toReplacement.getInsideBoundaryElement().isEmpty() && toReplacement.getOutsideBoundaryElement() == null){
					return boundary;
				}
			}else if(boundary instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) boundary;
				if(fromPlacement.getName().equals(Constants.NULL_NAME) && fromPlacement.getInsideBoundaryElement() == null && fromPlacement.getOutsideBoundaryElement().isEmpty()){
					return boundary;
				}
			}
		}
		return null;
	}
	
	private static ArrayList<VariationPoint> getCompliedToReplacements(ToPlacement toPlacement, ArrayList<VariationPoint> toReplacements) {
		ArrayList<VariationPoint> toRplcmnts = new ArrayList<VariationPoint>();
		
		//we should have here smart algorithm!!!:) Let us have a stub for now
		toRplcmnts.addAll(toReplacements);
		return toRplcmnts;
	}
	
	private static ArrayList<VariationPoint> getCompliedFromPlacements(FromReplacement fromReplacement, ArrayList<VariationPoint> fromPlacements) {
		ArrayList<VariationPoint> fromPlcmnts = new ArrayList<VariationPoint>();
		
		//we should have here smart algorithm!!!:) Let us have a stub for now
		fromPlcmnts.addAll(fromPlacements);
		return fromPlcmnts;
	}	

	private static HashMap<String, ArrayList<VariationPoint>> filterOutBoundariesByType(PlacementFragment placement, ReplacementFragmentType replacement){
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
	
	private static ArrayList<DataItem> wrapBoundaries(ArrayList<VariationPoint> boundaries){
		ArrayList<DataItem> wrappedItems = new ArrayList<DataItem>();
		for(VariationPoint boundary : boundaries){
			DataBoundaryItem item = new DataBoundaryItem(new JLabel(boundary.getName()), boundary);
			wrappedItems.add(item);
		}
		return wrappedItems;
	}
}
