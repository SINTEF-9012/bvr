/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.constraints.strategy;

import no.sintef.bvr.constraints.interfaces.strategy.IBCLBuilderStrategy;
import bvr.BvrFactory;
import bvr.Target;
import bvr.VSpec;

public class DefaultTestBCLBuilderStartegy implements IBCLBuilderStrategy {

	@Override
	public Target getVSpecTarget(VSpec node) {
		Target vspecTarget = BvrFactory.eINSTANCE.createTarget();
		vspecTarget.setName(node.getName());
		node.setTarget(vspecTarget);
		return vspecTarget;
	}

	@Override
	public VSpec testVSpecName(VSpec node, String name) {
		if (node.getName() != null && node.getName().equals(name))
			return node;
		return null;
	}

}
