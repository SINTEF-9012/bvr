package no.sintef.bvr.tool.model;

import bvr.BvrFactory;
import bvr.PlacementFragment;

public class SubstitutionFragmentFacade {

	public static SubstitutionFragmentFacade eINSTANCE = getInstance();
	private static final String defaultName = "Placement";
	private static int count = 0;
	
	private static SubstitutionFragmentFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new SubstitutionFragmentFacade();
		return eINSTANCE;
	}
	
	public PlacementFragment createPlacementFragment() {
		PlacementFragment placement = BvrFactory.eINSTANCE.createPlacementFragment();
		placement.setName(defaultName + count);
		count++;
		return placement;
	}
}
