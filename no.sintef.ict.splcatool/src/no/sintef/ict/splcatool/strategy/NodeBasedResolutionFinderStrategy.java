package no.sintef.ict.splcatool.strategy;


import no.sintef.ict.splcatool.interfaces.IResolutionFinderStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.ChoiceResolution;


public class NodeBasedResolutionFinderStrategy implements
		IResolutionFinderStrategy {
	
	protected ChoiceResolution resolution;

	public NodeBasedResolutionFinderStrategy(ChoiceResolution _resolution) {
		resolution = _resolution;
	}

	@Override
	public EList<ChoiceResolution> getResolutions() {
		EList<ChoiceResolution> result = new BasicEList<ChoiceResolution>();
		result.add(resolution);
		return result;
	}

}
