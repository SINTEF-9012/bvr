/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

import org.eclipse.emf.ecore.EObject;

import bvr.Choice;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VClassifier;

public class ChoiceVClassifierNameModifyStrategy implements ModifyNodeStrategy {

	private final PostfixGeneratorFacade postfix = PostfixGeneratorFacade.eINSTANCE;

	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		String name = ((NamedElement) node).getName();
		String new_name = name + postfix.getUnique();
		((NamedElement) node).setName(new_name);
	}

	@Override
	public boolean accept(EObject eObject) {
		if (eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}

}
