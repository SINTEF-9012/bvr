/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.model.ConstraintFacade;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.Target;
import bvr.TargetRef;

public class BCLConstraintModifiyTargetsStrategy implements ModifyNodeStrategy {

	private List<CompoundNode> nodes;
	private Set<String> currentTargetNames;
	private Pattern vspecRegEx = Pattern.compile("[a-zA-Z0-9_@]+");
	private BVRModel model;

	public void init(List<CompoundNode> _nodes, BVRModel _model) {
		nodes = _nodes;
		model = _model;
		currentTargetNames = new HashSet<String>();
		for (CompoundNode node : nodes) {
			EList<Target> targets = node.getOwnedTargets();
			for (Target target : targets)
				currentTargetNames.add(target.getName().trim());
		}
	}

	@Override
	public void modify(EObject eObject) {
		if (nodes == null || nodes.size() == 0)
			return;

		BCLConstraint constraint = (BCLConstraint) eObject;
		String str = ConstraintFacade.eINSTANCE.getBCLConstraintString(constraint);
		Context.eINSTANCE.logger.debug("Trying to modify constraint :" + str);

		String[] parts = str.split("\\s+");
		Set<String> targetNames = getTargetsNames(constraint);
		Map<String, HashSet<String>> oldNewTargetMap = findNewTargetsNames(targetNames);
		for (String oldName : oldNewTargetMap.keySet()) {
			String newName = compileNewString(oldNewTargetMap.get(oldName));
			for (int i = 0; i < parts.length; i++) {
				Matcher matcher = vspecRegEx.matcher(parts[i]);
				boolean isVspecName = matcher.find();
				if (isVspecName) {
					String substr = matcher.group();
					if (substr.equals(oldName))
						parts[i] = parts[i].replace(substr, newName);
				}
			}
		}

		String newConstraintStr = "";
		for (String part : parts)
			newConstraintStr += part + " ";
		newConstraintStr = newConstraintStr.trim();

		Context.eINSTANCE.logger.debug("Replacing with :" + newConstraintStr);
		BCLExpression expression = ConstraintFacade.eINSTANCE.testBCLConstraintString(model, newConstraintStr);
		constraint.getExpression().clear();
		constraint.getExpression().add(expression);
	}

	private String compileNewString(HashSet<String> names) {
		String str = "(";
		ArrayList<String> array = new ArrayList<String>(names);
		for (int i = 0; i < array.size(); i++) {
			str += array.get(i);
			if (i != array.size() - 1)
				str += " or ";
		}
		str += ")";
		return str;
	}

	@Override
	public boolean accept(EObject eObject) {
		if (eObject instanceof BCLConstraint)
			return true;
		return false;
	}

	private Set<String> getTargetsNames(BCLConstraint constraint) {
		Set<String> names = new HashSet<String>();
		TreeIterator<EObject> iterator = constraint.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof TargetRef) {
				String name = ((TargetRef) eObject).getTarget().getName();
				names.add(name);
			}
		}
		return names;
	}

	private Map<String, HashSet<String>> findNewTargetsNames(Set<String> targetNames) {
		Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		for (String name : targetNames) {
			HashSet<String> names = new HashSet<String>();
			for (String currentName : currentTargetNames) {
				if (currentName.startsWith(name.trim() + '@'))
					names.add(currentName);
			}
			if (names.size() == 0)
				throw new UnexpectedException("Cannot rewrite constraint, cannot find new target for the target with name '" + name + "'");

			map.put(name, names);
		}
		return map;
	}

}
