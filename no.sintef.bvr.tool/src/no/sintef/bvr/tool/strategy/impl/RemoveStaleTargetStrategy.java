/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VClassifier;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

public class RemoveStaleTargetStrategy implements ModifyNodeStrategy {

	private Pattern pattern = Pattern.compile("@\\d+$");
	
	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		Iterator<Target> iterator = node.getOwnedTargets().iterator();
		while(iterator.hasNext()) {
			Target target = iterator.next();
			if(invalidTarget(target))
				iterator.remove();
		}
	}

	@Override
	public boolean accept(EObject eObject) {
		if(eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}
	
	private boolean invalidTarget(Target target) {
		String name = target.getName();
		name = name.trim();
		Matcher matches = pattern.matcher(name);
		return !matches.find();
	}

}
