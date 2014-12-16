/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import java.util.List;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.command.ResCommand;
import bvr.BVRModel;
import bvr.ChoiceOccurrence;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.VClassOccurrence;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ResolutionModelIterator {
	private static ResolutionModelIterator instance = null;

	private ResolutionModelIterator() {

	}

	public static synchronized ResolutionModelIterator getInstance() {
		if (instance == null) {
			instance = new ResolutionModelIterator();
		}
		return instance;
	}

	public void iterateEmpty(BVRToolModel view, ResCommand command, VSpec vsParent, VSpecResolution vsrParent, boolean onlyOneInstance) {
		List<VSpecResolution> newResolutions = command.init(view, vsParent, vsrParent, onlyOneInstance).execute();
		if (newResolutions != null) {
			for (VSpecResolution newResolution : newResolutions) {
				iterateEmptyOnChildren(view, command, vsParent, newResolution, onlyOneInstance);
			}
		}
	}

	public void iterateEmptyOnChildren(BVRToolModel view, ResCommand command, VSpec vsParent, VSpecResolution vsrParent, boolean onlyOneInstance) {

		if (vsParent != null) {
			if (vsParent instanceof CompoundNode) {
				for (VNode y : ((CompoundNode) vsParent).getMember()) {
					if (y instanceof VSpec) {
						VSpec x = (VSpec) y;
						command.init(view, x, vsrParent, onlyOneInstance);
						List<VSpecResolution> newResolutions = command.execute();

						for (VSpecResolution newResolution : newResolutions) {
							if (CommonUtility.isOccurrence(y) && CommonUtility.isTypeNotNull(y)) {
								for (VNode t : CommonUtility.getTypeMembers(y)) {
									VSpec type = (VSpec) t;
									iterateEmpty(view, command, type, newResolution, onlyOneInstance);
								}
							}
							iterateEmptyOnChildren(view, command, x, newResolution, onlyOneInstance);
						}
					}
				}
			}
		}
	}

	public void iterateExisting(BVRToolModel view, ResCommand command, VSpec vsParent, VSpecResolution vsrParent, boolean onlyOneInstance) {
		command.init(view, vsParent, vsrParent, onlyOneInstance).execute();
		vsParent = vsrParent.getResolvedVSpec();
		if (vsrParent instanceof CompoundResolution) {
			for (VSpecResolution vsr : ((CompoundResolution) vsrParent).getMembers()) {// TODO
				iterateExisting(view, command, vsParent, vsr, onlyOneInstance);
			}
		}
	}

	public VSpecResolution getParent(BVRModel model, VSpecResolution child) {
		for (VSpecResolution c : model.getResolutionModels())
			if (c == child) {
				return null;
			}
		for (VSpecResolution r : model.getResolutionModels()) {
			VSpecResolution found = getParent(r, child);
			if (found != null)
				return found;
		}
		return null;

	}

	private VSpecResolution getParent(VSpecResolution root, VSpecResolution child) {
		if (root instanceof CompoundResolution) {

			for (VSpecResolution r : ((CompoundResolution) root).getMembers())
				if (r == child)
					return root;
			for (VSpecResolution r : ((CompoundResolution) root).getMembers()) {
				VSpecResolution found = getParent(r, child);
				if (found != null)
					return found;
			}
		}
		return null;
	}
}
