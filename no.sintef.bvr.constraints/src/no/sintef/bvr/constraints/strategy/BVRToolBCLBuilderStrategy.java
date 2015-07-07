/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.constraints.strategy;

import no.sintef.bvr.constraints.interfaces.strategy.IBCLBuilderStrategy;
import bvr.Target;
import bvr.VSpec;

public class BVRToolBCLBuilderStrategy implements IBCLBuilderStrategy {

	@Override
	public Target getVSpecTarget(VSpec node) {
		return node.getTarget();
	}

	@Override
	public VSpec testVSpecName(VSpec node, String name) {
		// TODO Auto-generated method stub
		Target target = node.getTarget();
		if (target != null && name.equals(target.getName())) {
			return node;
		}
		return null;
	}

}
