package no.sintef.ict.splcatool;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.constraints.interfaces.strategy.IConstraintFinderStrategy;

import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.VNode;

public class DefaultConstraintFinderStrategy implements IConstraintFinderStrategy {

	protected List<Constraint> constraints;
	protected BVRModel model;
	
	public DefaultConstraintFinderStrategy(BVRModel _model) {
		model = _model;
	}
	
	@Override
	public List<Constraint> getConstraints() {
		constraints = new ArrayList<Constraint>();
		traverse(model.getVariabilityModel());
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
