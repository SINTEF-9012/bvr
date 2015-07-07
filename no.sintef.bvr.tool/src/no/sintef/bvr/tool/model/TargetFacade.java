/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import bvr.BvrFactory;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VSpec;

public class TargetFacade {

	public static TargetFacade eINSTANCE = getInstance();

	private static TargetFacade getInstance() {
		if (eINSTANCE == null)
			eINSTANCE = new TargetFacade();
		return eINSTANCE;
	}

	public Target getVSpecTarget(VSpec vSpec) {
		return vSpec.getTarget();
	}

	public Target testVSpecNewTargetName(Map<Target, Set<VSpec>> map, VSpec vSpec, String new_name) {
		Target target = vSpec.getTarget();
		if (target == null) {
			target = CommonUtility.getTargetByName(new ArrayList<Target>(map.keySet()), new_name);
			if (target == null) {
				target = BvrFactory.eINSTANCE.createTarget();
				Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode((CompoundNode) vSpec, target);
			}
		} else {
			Target existingTarget = CommonUtility.getTargetByName(new ArrayList<Target>(map.keySet()), new_name);
			if (existingTarget != null) {
				Set<VSpec> vSpecs = map.get(target);
				if (vSpecs == null)
					throw new UnexpectedException("can not find any vspecs which use the target, map is proabble not build properly -> Target: " + target
							+ " map: " + map);

				if (vSpecs.size() == 1 && vSpecs.contains(vSpec)) {
					CompoundNode parent = (CompoundNode) target.eContainer();
					Context.eINSTANCE.getEditorCommands().removeTargetCompoundNode(parent, target);
				}
				target = existingTarget;
			}
		}
		Context.eINSTANCE.getEditorCommands().setVSpecTarget(vSpec, target);
		Context.eINSTANCE.getEditorCommands().setName(target, new_name);
		return target;
	}

	public Target testVSpecNewTargetName(CompoundNode variabilityModel, VSpec vSpec, String new_name) {
		Target target = vSpec.getTarget();
		if (target == null) {
			// if target is not set just create one and add to the the top
			target = CommonUtility.getTargetByName(variabilityModel.getOwnedTargets(), new_name);
			if (target == null) {
				target = BvrFactory.eINSTANCE.createTarget();
				Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode(variabilityModel, target);
			}
		} else {
			// if a target was set from before, but it is not on the top, move
			// this target on the top
			// Otherwise if there is already one on the top with such name,
			// simply use top target
			Target top_target = CommonUtility.getTargetByName(variabilityModel.getOwnedTargets(), target.getName());
			if (top_target == null) {
				Context.eINSTANCE.getEditorCommands().removeTargetCompoundNode((CompoundNode) target.eContainer(), target);
				Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode(variabilityModel, target);
			} else {
				target = top_target;
			}
			// if there is already target with the new name on the top, use this
			// one
			Target new_target = CommonUtility.getTargetByName(variabilityModel.getOwnedTargets(), new_name);
			if (new_target != null)
				target = new_target;
		}
		Context.eINSTANCE.getEditorCommands().setVSpecTarget(vSpec, target);
		Context.eINSTANCE.getEditorCommands().setName(target, new_name);
		return target;
	}
}
