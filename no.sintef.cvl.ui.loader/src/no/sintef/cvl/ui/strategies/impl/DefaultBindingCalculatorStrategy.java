package no.sintef.cvl.ui.strategies.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.BoundaryElementBinding;
import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.strategies.BindingCalculatorStrategy;

public class DefaultBindingCalculatorStrategy implements BindingCalculatorStrategy {

	@Override
	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError {		
		PlacementFragment placement = fragmentSubstitution.getPlacement();
		ReplacementFragmentType replacement = fragmentSubstitution.getReplacement();
		
		if(placement == null || replacement == null)
			throw new UnexpectedException("fragment substitution does not rererence placement or replacement" + fragmentSubstitution);
		
		ToReplacement nullToReplacement = Utility.testNullToReplacement(replacement);
		FromPlacement nullFromPlacement = Utility.testNullFromPlacement(placement);
		
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		
		if(placementBoundaries.size() == 0 || replacementBoundaries.size() == 0)
			throw new UnexpectedException("boundaries for placement or replacement are not generated" + placement + " " + replacement);
		
		HashMap<String, ArrayList<VariationPoint>> sortedBoundaries = Utility.sortBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacements = sortedBoundaries.get(Utility.TOPLCMNT);
		ArrayList<VariationPoint> fromReplacements = sortedBoundaries.get(Utility.FROMREPLCMNT);

		if(fragmentSubstitution.getBoundaryElementBinding().size() == 0){
			for(VariationPoint toPlacemenet : toPlacements){
				ToBinding toBinding = CvlFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
			}
			for(VariationPoint fromReplacement : fromReplacements){
				FromBinding fromBinding = CvlFactory.eINSTANCE.createFromBinding();
				fromBinding.setFromReplacement((FromReplacement) fromReplacement);
				fromBinding.setFromPlacement(nullFromPlacement);
				fragmentSubstitution.getBoundaryElementBinding().add(fromBinding);
			}	
		}else{
			EList<BoundaryElementBinding> bindings = fragmentSubstitution.getBoundaryElementBinding();
			EList<ToPlacement> boundedToPlacements = new BasicEList<ToPlacement>();
			EList<FromReplacement> boundedFromReplacements = new BasicEList<FromReplacement>();
			for(BoundaryElementBinding binding : bindings){
				if(binding instanceof ToBinding)
					boundedToPlacements.add(((ToBinding) binding).getToPlacement());
				if(binding instanceof FromBinding)
					boundedFromReplacements.add(((FromBinding) binding).getFromReplacement());
			}
			SetView<VariationPoint> toPlacementsToProcess = Sets.symmetricDifference(new HashSet<VariationPoint>(toPlacements), new HashSet<VariationPoint>(boundedToPlacements));
			for(VariationPoint toPlacemenet : toPlacementsToProcess){
				ToBinding toBinding = CvlFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
			}
			
			SetView<VariationPoint> fromReplacementsToProcess = Sets.symmetricDifference(new HashSet<VariationPoint>(fromReplacements), new HashSet<VariationPoint>(boundedFromReplacements));
			for(VariationPoint fromReplacement : fromReplacementsToProcess){
				FromBinding fromBinding = CvlFactory.eINSTANCE.createFromBinding();
				fromBinding.setFromReplacement((FromReplacement) fromReplacement);
				fromBinding.setFromPlacement(nullFromPlacement);
				fragmentSubstitution.getBoundaryElementBinding().add(fromBinding);
			}
		}
	}

}
