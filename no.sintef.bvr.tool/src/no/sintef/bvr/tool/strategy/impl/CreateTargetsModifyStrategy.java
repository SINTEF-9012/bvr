/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import org.eclipse.emf.ecore.EObject;

import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.Target;
import bvr.VClassifier;
import bvr.VSpec;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

public class CreateTargetsModifyStrategy implements ModifyNodeStrategy {

	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		String name = ((NamedElement) node).getName();
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(name);
		node.getOwnedTargets().add(target);
		((VSpec) node).setTarget(target);
	}

	@Override
	public boolean accept(EObject eObject) {
		if(eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}

}
