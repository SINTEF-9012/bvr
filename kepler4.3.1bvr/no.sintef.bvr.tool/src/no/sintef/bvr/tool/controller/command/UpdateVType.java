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
import bvr.NamedElement;

public class UpdateVType<EDITOR_PANEL, MODEL_PANEL> implements
		UpdateNamedElement<EDITOR_PANEL, MODEL_PANEL> {

	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected JComponent parent;
	protected NamedElement vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	protected String name;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(
			BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel,
			Object p, JComponent parent, Map<JComponent, NamedElement> vmMap,
			List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {

		this.rootPanel = rootPanel;
		this.vc = (NamedElement) p;
		this.parent = parent;
		this.name = vc.getName();

		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getVTypeControllerInterface().setNodeName(parent, name);
		return parent;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
