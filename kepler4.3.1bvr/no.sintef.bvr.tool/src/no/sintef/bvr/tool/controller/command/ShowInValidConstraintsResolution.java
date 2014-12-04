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
package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;






import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VNode;
import bvr.VSpecResolution;

public class ShowInValidConstraintsResolution<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private Object v;
	private JComponent parent;
	private BVRNotifiableController controller;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {

		this.rootPanel = rootPanel;
		this.v = p;
		this.parent = parent;
		this.vmMap = vmMap;
		this.controller = controller;
		this.nodes = nodes;
		this.bindings = bindings;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		if(v instanceof CompoundResolution) {
			VNode vNode = (VNode) CommonUtility.getResolvedVSpec((VSpecResolution) v);
			List<Constraint> constraints = vNode.getOwnedConstraint();
			List<Constraint> invalidConstraints = controller.getResolutionControllerInterface().getInvalidConstraints();
			for(Constraint constraint : constraints) {
				if(invalidConstraints.contains(constraint)){
					new ShowViolatedBCLConstraint<EDITOR_PANEL, MODEL_PANEL>().init(rootPanel, constraint, parent, vmMap, nodes, bindings, controller).execute();
				} else {
					new ShowBCLConstraintResolution<EDITOR_PANEL, MODEL_PANEL>().init(rootPanel, constraint, parent, vmMap, nodes, bindings, controller).execute();
				}
			}			
		}
		return parent;
	}

}
