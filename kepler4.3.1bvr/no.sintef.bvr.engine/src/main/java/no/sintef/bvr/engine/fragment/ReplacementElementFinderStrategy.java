package no.sintef.bvr.engine.fragment;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.engine.common.HolderDataElement;
import bvr.ReplacementBoundaryElement;

public interface ReplacementElementFinderStrategy {

	public HolderDataElement locateReplacementElements(EList<ReplacementBoundaryElement> rbe);
	
	public void flush();
}
