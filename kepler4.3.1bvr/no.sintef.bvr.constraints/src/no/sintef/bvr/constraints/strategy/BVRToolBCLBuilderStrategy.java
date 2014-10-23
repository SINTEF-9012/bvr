package no.sintef.bvr.constraints.strategy;

import bvr.Target;
import bvr.VSpec;

public class BVRToolBCLBuilderStrategy extends AbstractBCLBuilderStrategy {

	@Override
	public Target getVSpecTarget(VSpec node) {
		return node.getTarget();
	}

}
