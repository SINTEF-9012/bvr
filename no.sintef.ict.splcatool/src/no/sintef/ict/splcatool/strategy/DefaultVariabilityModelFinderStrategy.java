package no.sintef.ict.splcatool.strategy;

import bvr.BVRModel;
import bvr.CompoundNode;
import no.sintef.ict.splcatool.interfaces.IVariabilityModelFinderStartegy;

public class DefaultVariabilityModelFinderStrategy implements
		IVariabilityModelFinderStartegy {

	private BVRModel model;
	
	public DefaultVariabilityModelFinderStrategy(BVRModel _model) {
		model = _model;
	}
	
	@Override
	public CompoundNode getVariabilityModel() {
		return model.getVariabilityModel();
	}

}
