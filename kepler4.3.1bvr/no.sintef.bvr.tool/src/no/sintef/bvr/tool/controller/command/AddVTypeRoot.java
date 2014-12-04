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
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.dropdown.VTypeDropDownListener;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.VTypeRootSymbolPanel;
import bvr.NamedElement;
import bvr.VType;


public class AddVTypeRoot<EDITOR_PANEL extends BVREditorPanel, MODEL_PANEL extends BVRModelPanel>
		implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private VType vType;
	private CommandMouseListener listener;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object _vType, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.rootPanel = rootPanel;
		this.vType = (VType) _vType;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		return this;
	}

	@Override
	public JComponent execute() {
		VTypeRootSymbolPanel cp = new VTypeRootSymbolPanel((BVRModelPanel) rootPanel.getModelPanel());
		nodes.add(cp);
		vmMap.put(cp, vType);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new VTypeDropDownListener(cp, vmMap, nodes, bindings, view));
        cp.addMouseListener(listener);
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, null, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
		
        String name = vType.getName();
        if(name == null) name = "(unnamed)";
        cp.setTitle(name);
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
        return cp;
	}
}
