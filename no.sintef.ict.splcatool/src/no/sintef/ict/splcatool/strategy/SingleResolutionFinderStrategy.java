package no.sintef.ict.splcatool.strategy;


import no.sintef.ict.splcatool.interfaces.IResolutionFinderStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.ChoiceResolution;


public class SingleResolutionFinderStrategy implements
		IResolutionFinderStrategy {
	
	protected ChoiceResolution resolution;

	public SingleResolutionFinderStrategy(ChoiceResolution _resolution) {
		resolution = _resolution;
	}

	@Override
	public EList<ChoiceResolution> getResolutions() {
		EList<ChoiceResolution> result = new BasicEList<ChoiceResolution>();
		result.add(resolution);
		return result;
	}

}
