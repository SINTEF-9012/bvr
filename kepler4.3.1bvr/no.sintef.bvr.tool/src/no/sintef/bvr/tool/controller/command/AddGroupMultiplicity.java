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

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VNode;

public class AddGroupMultiplicity<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected VSpec v;
	protected JComponent parent;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		if(p instanceof VSpec){
			this.rootPanel = rootPanel;
			this.v = (VSpec) p;
			this.parent = parent;
		}
		
		this.nodes = nodes;
		this.bindings = bindings;
		return this;
	}

	public JComponent execute() {
		if(((VNode) v).getGroupMultiplicity() != null){
			MultiplicityInterval m = ((VNode) v).getGroupMultiplicity();
			GroupPanel group = new GroupPanel();
			nodes.add(group);
			int l = m.getLower();
			int u = m.getUpper();
			group.setCardinality(l, u);
			((BVRModelPanel) rootPanel.getModelPanel()).addNode(group);

			Helper.bind(parent, group, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
			
			return group;
		}
		return null;
	}

}
