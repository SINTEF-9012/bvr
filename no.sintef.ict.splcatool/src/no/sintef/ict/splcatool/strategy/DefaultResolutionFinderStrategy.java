package no.sintef.ict.splcatool.strategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.ChoiceResolution;
import no.sintef.ict.splcatool.interfaces.IResolutionFinderStrategy;

public class DefaultResolutionFinderStrategy implements
		IResolutionFinderStrategy {
	
	protected BVRModel model;

	public DefaultResolutionFinderStrategy(BVRModel _model) {
		model = _model;
	}

	@Override
	public EList<ChoiceResolution> getResolutions() {
		return new BasicEList<ChoiceResolution>(model.getResolutionModels());
	}

}
