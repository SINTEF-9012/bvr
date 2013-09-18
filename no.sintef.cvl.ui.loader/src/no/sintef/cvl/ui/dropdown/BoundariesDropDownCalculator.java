package no.sintef.cvl.ui.dropdown;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import no.sintef.cvl.ui.common.LoaderUtility;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.PlacementReplacementNullException;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.strategy.impl.BoundaryCalculatorContext;
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
		
		HashMap<String, ArrayList<VariationPoint>> fileterdBoundaries = LoaderUtility.sortBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacements = fileterdBoundaries.get(LoaderUtility.TOPLCMNT);
		ArrayList<VariationPoint> toReplacements = fileterdBoundaries.get(LoaderUtility.TOREPLCMNT);
		for(VariationPoint toPlacement : toPlacements){
			ArrayList<VariationPoint> toReplcmnts = boundaryCalculator.getCompliedBoundaries((ToPlacement) toPlacement, toReplacements);		
			DataNamedElementItem toPlacementDataItem = new DataNamedElementItem(new JLabel(toPlacement.getName()), toPlacement);
			ArrayList<DataItem> toReplcmntsDataItem = wrapBoundaries(toReplcmnts);
			map.put(toPlacementDataItem, toReplcmntsDataItem);
		}
		
		ArrayList<VariationPoint> fromReplacements = fileterdBoundaries.get(LoaderUtility.FROMREPLCMNT);
		ArrayList<VariationPoint> fromPlacements = fileterdBoundaries.get(LoaderUtility.FROMPLCMNT);
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
