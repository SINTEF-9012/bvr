package no.sintef.bvr.constraints.strategy;

import java.util.List;

import bvr.Constraint;
import bvr.VNode;

public class ContextConstraintFinderStrategy extends
		DefaultConstraintFinderStrategy {

	private VNode context;

	public ContextConstraintFinderStrategy(VNode vNode) {
		super();
		context = vNode;
	}
	
	@Override
	public List<Constraint> getConstraints(VNode node) {
		return super.getConstraints(context);
	}
}
