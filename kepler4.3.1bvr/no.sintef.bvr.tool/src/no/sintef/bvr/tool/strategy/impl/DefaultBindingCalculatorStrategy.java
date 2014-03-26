package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.BoundaryElementBinding;
import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VariationPoint;
import bvr.NamedElement;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.strategy.BindingCalculatorStrategy;

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

		EList<BoundaryElementBinding> listbindings = new BasicEList<BoundaryElementBinding>();
		if(fragmentSubstitution.getBoundaryElementBinding().size() == 0){
			for(NamedElement toPlacemenet : toPlacements){
				ToBinding toBinding = BvrFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				//fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
				listbindings.add(toBinding);
			}
			for(NamedElement fromReplacement : fromReplacements){
				FromBinding fromBinding = BvrFactory.eINSTANCE.createFromBinding();
				fromBinding.setFromReplacement((FromReplacement) fromReplacement);
				fromBinding.setFromPlacement(nullFromPlacement);
				//fragmentSubstitution.getBoundaryElementBinding().add(fromBinding);
				listbindings.add(fromBinding);
			}
			if(listbindings.size() > 0)
				Context.eINSTANCE.getEditorCommands().addBoudaryElementBindings(fragmentSubstitution, listbindings);
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
				ToBinding toBinding = BvrFactory.eINSTANCE.createToBinding();
				toBinding.setToPlacement((ToPlacement) toPlacemenet);
				toBinding.setToReplacement(nullToReplacement);
				//fragmentSubstitution.getBoundaryElementBinding().add(toBinding);
				listbindings.add(toBinding);
			}
			
			SetView<NamedElement> fromReplacementsToProcess = Sets.symmetricDifference(new HashSet<NamedElement>(fromReplacements), new HashSet<NamedElement>(boundedFromReplacements));
			for(NamedElement fromReplacement : fromReplacementsToProcess){
				FromBinding fromBinding = BvrFactory.eINSTANCE.createFromBinding();
				fromBinding.setFromReplacement((FromReplacement) fromReplacement);
				fromBinding.setFromPlacement(nullFromPlacement);
				//fragmentSubstitution.getBoundaryElementBinding().add(fromBinding);
				listbindings.add(fromBinding);
			}
			if(listbindings.size() > 0)
				Context.eINSTANCE.getEditorCommands().addBoudaryElementBindings(fragmentSubstitution, listbindings);
		}
	}

}
