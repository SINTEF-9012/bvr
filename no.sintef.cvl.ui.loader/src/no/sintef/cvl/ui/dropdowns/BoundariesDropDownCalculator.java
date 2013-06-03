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
import no.sintef.cvl.ui.algorithms.BoundaryCalculatorContext;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.Utility;
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
		BoundaryCalculatorContext boundaryCalculator = new BoundaryCalculatorContext();
		HashMap<DataItem, ArrayList<DataItem>> map = new HashMap<DataItem, ArrayList<DataItem>>();
		PlacementFragment placement = fs.getPlacement();
		ReplacementFragmentType replacement = fs.getReplacement();
		if(placement == null || replacement == null){
			throw new PlacementReplacementNullException("placement or replacement is null however it should not be here this way, or we should handle it somehow"); 
		}
		
		HashMap<String, ArrayList<VariationPoint>> fileterdBoundaries = filterOutBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacements = fileterdBoundaries.get(TOPLCMNT);
		ArrayList<VariationPoint> toReplacements = fileterdBoundaries.get(TOREPLCMNT);
		for(VariationPoint toPlacement : toPlacements){
			ArrayList<VariationPoint> toReplcmnts = boundaryCalculator.getCompliedBoundaries((ToPlacement) toPlacement, toReplacements);
			
			DataNamedElementItem toPlacementDataItem = new DataNamedElementItem(new JLabel(toPlacement.getName()), toPlacement);
			ArrayList<DataItem> toReplcmntsDataItem = wrapBoundaries(toReplcmnts);
			
			map.put(toPlacementDataItem, toReplcmntsDataItem);
		}
		
		ArrayList<VariationPoint> fromReplacements = fileterdBoundaries.get(FROMREPLCMNT);
		ArrayList<VariationPoint> fromPlacements = fileterdBoundaries.get(FROMPLCMNT);
		for(VariationPoint fromReplacement : fromReplacements){
			ArrayList<VariationPoint> fromPlcmnts = boundaryCalculator.getCompliedBoundaries((FromReplacement) fromReplacement, fromPlacements);
			
			DataNamedElementItem fromReplacementDataItem = new DataNamedElementItem(new JLabel(fromReplacement.getName()), fromReplacement);
			ArrayList<DataItem> fromPlcmntsDataItem = wrapBoundaries(fromPlcmnts);
			
			map.put(fromReplacementDataItem, fromPlcmntsDataItem);
		}
		
		return map;
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
