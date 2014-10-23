package no.sintef.bvr.constraints.strategy;

import bvr.BvrFactory;
import bvr.Target;
import bvr.VSpec;

public class DefaultTestBCLBuilderStartegy extends AbstractBCLBuilderStrategy {

	@Override
	public Target getVSpecTarget(VSpec node) {
		Target vspecTarget = BvrFactory.eINSTANCE.createTarget();
		vspecTarget.setName(node.getName());
		node.setTarget(vspecTarget);
		return vspecTarget;
	}

}
