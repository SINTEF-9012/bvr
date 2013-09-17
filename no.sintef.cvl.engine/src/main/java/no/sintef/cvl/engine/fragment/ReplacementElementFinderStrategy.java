package no.sintef.cvl.engine.fragment;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.engine.common.HolderDataElement;
import cvl.ReplacementBoundaryElement;

public interface ReplacementElementFinderStrategy {

	public HolderDataElement locateReplacementElements(EList<ReplacementBoundaryElement> rbe);
	
	public void flush();
}
