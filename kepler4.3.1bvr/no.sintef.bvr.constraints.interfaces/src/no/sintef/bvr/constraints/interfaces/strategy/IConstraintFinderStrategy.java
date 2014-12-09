package no.sintef.bvr.constraints.interfaces.strategy;

import java.util.List;

import bvr.Constraint;
import bvr.VNode;

public interface IConstraintFinderStrategy {

	public List<Constraint> getConstraints(VNode node);
}
