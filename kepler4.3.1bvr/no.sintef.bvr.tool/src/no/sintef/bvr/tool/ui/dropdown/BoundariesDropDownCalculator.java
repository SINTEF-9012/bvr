package no.sintef.bvr.tool.ui.dropdown;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.PlacementReplacementNullException;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.primitive.impl.DataBoundaryItem;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.strategy.impl.BoundaryCalculatorContext;
import bvr.FragmentSubstitution;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.ToPlacement;
import bvr.VariationPoint;

public class BoundariesDropDownCalculator {

	public static HashMap<DataItem, ArrayList<DataItem>> calulateAllowedBoundaries(FragmentSubstitution fs) throws AbstractError{
		BoundaryCalculatorContext boundaryCalculator = new BoundaryCalculatorContext();
		HashMap<DataItem, ArrayList<DataItem>> map = new HashMap<DataItem, ArrayList<DataItem>>();
		PlacementFragment placement = fs.getPlacement();
		ReplacementFragmentType replacement = fs.getReplacement();
		if(placement == null || replacement == null){
			throw new PlacementReplacementNullException("placement or replacement is null however it should not be here this way, or we should handle it somehow"); 
		}
		
		HashMap<String, ArrayList<NamedElement>> fileterdBoundaries = LoaderUtility.sortBoundariesByType(placement, replacement);
		ArrayList<NamedElement> toPlacements = fileterdBoundaries.get(LoaderUtility.TOPLCMNT);
		ArrayList<NamedElement> toReplacements = fileterdBoundaries.get(LoaderUtility.TOREPLCMNT);
		for(NamedElement toPlacement : toPlacements){
			ArrayList<NamedElement> toReplcmnts = boundaryCalculator.getCompliedBoundaries((ToPlacement) toPlacement, toReplacements);		
			DataNamedElementItem toPlacementDataItem = new DataNamedElementItem(new JLabel(toPlacement.getName()), toPlacement);
			ArrayList<DataItem> toReplcmntsDataItem = wrapBoundaries(toReplcmnts);
			map.put(toPlacementDataItem, toReplcmntsDataItem);
		}
		
		ArrayList<NamedElement> fromReplacements = fileterdBoundaries.get(LoaderUtility.FROMREPLCMNT);
		ArrayList<NamedElement> fromPlacements = fileterdBoundaries.get(LoaderUtility.FROMPLCMNT);
		for(NamedElement fromReplacement : fromReplacements){
			ArrayList<NamedElement> fromPlcmnts = boundaryCalculator.getCompliedBoundaries((FromReplacement) fromReplacement, fromPlacements);
			DataNamedElementItem fromReplacementDataItem = new DataNamedElementItem(new JLabel(fromReplacement.getName()), fromReplacement);
			ArrayList<DataItem> fromPlcmntsDataItem = wrapBoundaries(fromPlcmnts);
			map.put(fromReplacementDataItem, fromPlcmntsDataItem);
		}
		
		return map;
	}
	
	private static ArrayList<DataItem> wrapBoundaries(ArrayList<NamedElement> boundaries){
		ArrayList<DataItem> wrappedItems = new ArrayList<DataItem>();
		for(NamedElement boundary : boundaries){
			DataBoundaryItem item = new DataBoundaryItem(new JLabel(boundary.getName()), boundary);
			wrappedItems.add(item);
		}
		return wrappedItems;
	}
}
