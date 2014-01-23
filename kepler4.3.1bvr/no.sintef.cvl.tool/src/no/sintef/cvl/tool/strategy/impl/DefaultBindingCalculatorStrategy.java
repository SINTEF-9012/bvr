package no.sintef.cvl.tool.strategy.impl;

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
import cvl.NamedElement;
import no.sintef.cvl.tool.common.LoaderUtility;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.strategy.BindingCalculatorStrategy;

public class DefaultBindingCalculatorStrategy implements BindingCalculatorStrategy {

	@Override
	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError {		
		PlacementFragment placement = fragmentSubstitution.getPlacement();
		ReplacementFragmentType replacement = fragmentSubstitution.getReplacement();
		
		if(placement == null || replacement == null)
			throw new UnexpectedException("fragment substitution does not rererence placement or replacement" + fragmentSubstitution);
		
		ToReplacement nullToReplacement = LoaderUtility.testNullToReplacement(replacement);
		FromPlacement nullFromPlacement = LoaderUtility.testNullFromPlacement(placement);
		
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		
		if(placementBoundaries.size() == 0 || replacementBoundaries.size() == 0)
			throw new UnexpectedException("boundaries for placement or replacement are not generated" + placement + " " + replacement);
		
		HashMap<String, ArrayList<NamedElement>> sortedBoundaries = LoaderUtility.sortBoundariesByType(placement, replacement);
		ArrayList<NamedElement> toPlacements = sortedBoundaries.get(LoaderUtility.TOPLCMNT);
		ArrayList<NamedElement> fromReplacements = sortedBoundaries.get(LoaderUtility.FROMREPLCMNT);

		if(fragmentSubstitution.getBoundaryElementBinding().size() == 0){
			for(NamedElement toPlacemenet : toPlacements){
				ToBinding toBinding = CvlFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
			}
			for(NamedElement fromReplacement : fromReplacements){
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
			SetView<NamedElement> toPlacementsToProcess = Sets.symmetricDifference(new HashSet<NamedElement>(toPlacements), new HashSet<NamedElement>(boundedToPlacements));
			for(NamedElement toPlacemenet : toPlacementsToProcess){
				ToBinding toBinding = CvlFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
			}
			
			SetView<NamedElement> fromReplacementsToProcess = Sets.symmetricDifference(new HashSet<NamedElement>(fromReplacements), new HashSet<NamedElement>(boundedFromReplacements));
			for(NamedElement fromReplacement : fromReplacementsToProcess){
				FromBinding fromBinding = CvlFactory.eINSTANCE.createFromBinding();
				fromBinding.setFromReplacement((FromReplacement) fromReplacement);
				fromBinding.setFromPlacement(nullFromPlacement);
				fragmentSubstitution.getBoundaryElementBinding().add(fromBinding);
			}
		}
	}

}
