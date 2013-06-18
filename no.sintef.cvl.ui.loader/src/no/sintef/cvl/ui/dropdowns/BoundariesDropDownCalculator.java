package no.sintef.cvl.ui.dropdowns;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.PlacementReplacementNullException;
import no.sintef.cvl.ui.primitives.DataItem;
import no.sintef.cvl.ui.primitives.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitives.impl.DataNamedElementItem;
import no.sintef.cvl.ui.strategies.impl.BoundaryCalculatorContext;
import cvl.FragmentSubstitution;
import cvl.FromReplacement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.VariationPoint;

public class BoundariesDropDownCalculator {

	public static HashMap<DataItem, ArrayList<DataItem>> calulateAllowedBoundaries(FragmentSubstitution fs) throws AbstractError{
		BoundaryCalculatorContext boundaryCalculator = new BoundaryCalculatorContext();
		HashMap<DataItem, ArrayList<DataItem>> map = new HashMap<DataItem, ArrayList<DataItem>>();
		PlacementFragment placement = fs.getPlacement();
		ReplacementFragmentType replacement = fs.getReplacement();
		if(placement == null || replacement == null){
			throw new PlacementReplacementNullException("placement or replacement is null however it should not be here this way, or we should handle it somehow"); 
		}
		
		HashMap<String, ArrayList<VariationPoint>> fileterdBoundaries = Utility.sortBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacements = fileterdBoundaries.get(Utility.TOPLCMNT);
		ArrayList<VariationPoint> toReplacements = fileterdBoundaries.get(Utility.TOREPLCMNT);
		for(VariationPoint toPlacement : toPlacements){
			ArrayList<VariationPoint> toReplcmnts = boundaryCalculator.getCompliedBoundaries((ToPlacement) toPlacement, toReplacements);		
			DataNamedElementItem toPlacementDataItem = new DataNamedElementItem(new JLabel(toPlacement.getName()), toPlacement);
			ArrayList<DataItem> toReplcmntsDataItem = wrapBoundaries(toReplcmnts);
			map.put(toPlacementDataItem, toReplcmntsDataItem);
		}
		
		ArrayList<VariationPoint> fromReplacements = fileterdBoundaries.get(Utility.FROMREPLCMNT);
		ArrayList<VariationPoint> fromPlacements = fileterdBoundaries.get(Utility.FROMPLCMNT);
		for(VariationPoint fromReplacement : fromReplacements){
			ArrayList<VariationPoint> fromPlcmnts = boundaryCalculator.getCompliedBoundaries((FromReplacement) fromReplacement, fromPlacements);
			DataNamedElementItem fromReplacementDataItem = new DataNamedElementItem(new JLabel(fromReplacement.getName()), fromReplacement);
			ArrayList<DataItem> fromPlcmntsDataItem = wrapBoundaries(fromPlcmnts);
			map.put(fromReplacementDataItem, fromPlcmntsDataItem);
		}
		
		return map;
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
