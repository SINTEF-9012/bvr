package no.sintef.bvr.engine.interfaces.strategy;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;
import bvr.ReplacementBoundaryElement;


public interface IReplacementElementFinderStrategy {

	public IHolderDataElement locateReplacementElements(EList<ReplacementBoundaryElement> rbe);
	
	public void flush();
}
