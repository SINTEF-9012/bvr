/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.constraints.strategy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.constraints.interfaces.strategy.IConstraintFinderStrategy;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.VNode;

public class ContextConstraintFinderStrategy implements
		IConstraintFinderStrategy {

	private VNode node;
	private List<Constraint> constraints;

	public ContextConstraintFinderStrategy(VNode _node) {
		node = _node;
	}

	@Override
	public List<Constraint> getConstraints() {
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
