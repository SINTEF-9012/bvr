package no.sintef.bvr.engine.interfaces.strategy;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;
import bvr.FromPlacement;
import bvr.PlacementBoundaryElement;
import bvr.ToPlacement;

public interface IPlacementElementFinderStrategy {
	
	public IHolderDataElement locatePlacementElements(EList<PlacementBoundaryElement> pbes,
			HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap,
			HashMap<ToPlacement, HashSet<EObject>> toPlacementOutBoundaryMap);
	
	public void flush();
}
