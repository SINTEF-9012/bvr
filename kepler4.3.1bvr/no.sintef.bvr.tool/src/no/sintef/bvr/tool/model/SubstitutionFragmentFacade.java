package no.sintef.bvr.tool.model;

import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public class SubstitutionFragmentFacade {

	public static SubstitutionFragmentFacade eINSTANCE = getInstance();
	private static final String defaultPlacementName = "Placement";
	private static final String defaultReplacementName = "Replacement";
	private static final String defualtFragmentSubstitutionName = "FragmentSubstititution";
	private static int countReplacement = 0;
	private static int countPlacement = 0;
	private static int countFragment = 0;
	
	private static SubstitutionFragmentFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new SubstitutionFragmentFacade();
		return eINSTANCE;
	}
	
	public PlacementFragment createPlacementFragment() {
		PlacementFragment placement = BvrFactory.eINSTANCE.createPlacementFragment();
		placement.setName(defaultPlacementName + countPlacement);
		countPlacement++;
		return placement;
	}

	public ReplacementFragmentType createReplacementFragment() {
		ReplacementFragmentType replacement = BvrFactory.eINSTANCE.createReplacementFragmentType();
		replacement.setName(defaultReplacementName + countReplacement);
		countReplacement++;
		return replacement;
	}

	public FragmentSubstitution createFragmentSubstitution() {
		FragmentSubstitution fs = BvrFactory.eINSTANCE.createFragmentSubstitution();
		fs.setName(defualtFragmentSubstitutionName + countFragment);
		countFragment++;
		return fs;
	}
}
