package no.sintef.cvl.engine.fragment;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import no.sintef.cvl.engine.common.HolderDataElement;
import cvl.FromPlacement;
import cvl.PlacementBoundaryElement;
import cvl.ToPlacement;

public interface PlacementElementFinderStrategy {
	
	public HolderDataElement locatePlacementElements(EList<PlacementBoundaryElement> pbes,
			HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap,
			HashMap<ToPlacement, HashSet<EObject>> toPlacementOutBoundaryMap);
	
	public void flush();
}
