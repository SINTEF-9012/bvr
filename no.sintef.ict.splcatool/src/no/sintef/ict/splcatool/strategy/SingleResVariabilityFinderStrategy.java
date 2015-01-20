package no.sintef.ict.splcatool.strategy;

import bvr.CompoundNode;
import bvr.VNode;
import no.sintef.ict.splcatool.interfaces.IVariabilityModelFinderStartegy;


public class SingleResVariabilityFinderStrategy implements
		IVariabilityModelFinderStartegy {

	protected VNode node;

	public SingleResVariabilityFinderStrategy(VNode _node) {
		node = _node;
	}

	@Override
	public CompoundNode getVariabilityModel() {
		return (CompoundNode) node;
	}

}
