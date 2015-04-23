package no.sintef.ict.splcatool.strategy;

import no.sintef.ict.splcatool.interfaces.IBVRModelHolderStrategy;
import bvr.BVRModel;

public class DefaultBVRModelHolderStrategy implements IBVRModelHolderStrategy {

	private BVRModel model;

	public DefaultBVRModelHolderStrategy(BVRModel _model) {
		model = _model;
	}

	@Override
	public BVRModel getBVRModel() {
		return model;
	}

}
