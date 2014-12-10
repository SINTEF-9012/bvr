package no.sintef.bvr.constraints.strategy;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.constraints.interfaces.strategy.IConstraintFinderStrategy;

import org.eclipse.emf.common.util.EList;

import bvr.CompoundNode;
import bvr.Constraint;
import bvr.VNode;

public class DefaultConstraintFinderStrategy implements IConstraintFinderStrategy {

	protected List<Constraint> constraints;
	
	@Override
	public List<Constraint> getConstraints(VNode node) {
		constraints = new ArrayList<Constraint>();
		traverse(node);
		return constraints;
	}
	
	private void traverse(VNode node) {
		EList<Constraint> owned = node.getOwnedConstraint();
		constraints.addAll(owned);
		if(node instanceof CompoundNode) {
			for(VNode vNode : ((CompoundNode) node).getMember()) {
				traverse(vNode);
			}
		}
	}
}
