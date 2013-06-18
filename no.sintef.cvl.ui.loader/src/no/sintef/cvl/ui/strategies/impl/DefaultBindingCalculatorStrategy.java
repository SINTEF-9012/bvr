package no.sintef.cvl.ui.strategies.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
		fragmentSubstitution.getBoundaryElementBinding().clear();
		
		PlacementFragment placement = fragmentSubstitution.getPlacement();
		ReplacementFragmentType replacement = fragmentSubstitution.getReplacement();
		
		if(placement == null || replacement == null)
			throw new UnexpectedException("fragment substitution does not rererence placement or replacement" + fragmentSubstitution);
		
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		
		if(placementBoundaries.size() == 0 || replacementBoundaries.size() == 0)
			throw new UnexpectedException("boundaries for placement or replacement are not generated" + placement + " " + replacement);
		
		HashMap<String, ArrayList<VariationPoint>> sortedBoundaries = Utility.sortBoundariesByType(placement, replacement);
		ArrayList<VariationPoint> toPlacemenets = sortedBoundaries.get(Utility.TOPLCMNT);
		ArrayList<VariationPoint> fromReplacements = sortedBoundaries.get(Utility.FROMREPLCMNT);
		
		ToReplacement nullToReplacement = Utility.getNullToReplacement(new BasicEList<VariationPoint>(sortedBoundaries.get(Utility.TOREPLCMNT)));
		if(nullToReplacement == null)
			throw new UnexpectedException("can not find NULL ToReplacement boundary");
		
		FromPlacement nullFromPlacement = Utility.getNullFromPlacement(new BasicEList<VariationPoint>(sortedBoundaries.get(Utility.FROMPLCMNT)));
		if(nullFromPlacement == null)
			throw new UnexpectedException("can not find NULL FromPlacement boundary");
		
		for(VariationPoint toPlacemenet : toPlacemenets){
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
	}

}
