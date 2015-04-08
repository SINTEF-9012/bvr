/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June
 * 2007; you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
			target = CommonUtility.getTargetByName(variabilityModel.getOwnedTargets(), new_name);
			if (target == null) {
				target = BvrFactory.eINSTANCE.createTarget();
				Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode(variabilityModel, target);
			}
		} else {
			Target existingTopTarget = CommonUtility.getTargetByName(variabilityModel.getOwnedTargets(), new_name);
			if (existingTopTarget == null) {
				// move the referenced target to the top node
				Context.eINSTANCE.getEditorCommands().removeTargetCompoundNode((CompoundNode) target.eContainer(), target);
				Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode(variabilityModel, target);
			} else {
				// if there is a proper target at the top, we simply remove the
				// referenced one
				Context.eINSTANCE.getEditorCommands().removeTargetCompoundNode((CompoundNode) target.eContainer(), target);
				target = existingTopTarget;
			}
		}
		Context.eINSTANCE.getEditorCommands().setVSpecTarget(vSpec, target);
		Context.eINSTANCE.getEditorCommands().setName(target, new_name);
		return target;
	}
}
