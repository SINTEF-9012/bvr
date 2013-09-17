package no.sintef.cvl.engine.fragment;

import no.sintef.cvl.engine.common.HolderDataElement;
import cvl.PlacementBoundaryElement;

public interface PlacementElementFinderStrategyInterface {
	
	public void locatePlacementElements(PlacementBoundaryElement pbe);
	
	public HolderDataElement getLocatedElements();
}
