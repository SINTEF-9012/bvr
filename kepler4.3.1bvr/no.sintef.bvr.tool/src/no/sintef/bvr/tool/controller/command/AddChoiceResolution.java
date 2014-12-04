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
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ChoiceResolutionDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;
import bvr.VSpec;


public class AddChoiceResolution<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private JComponent parent;
	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private ChoiceResolution c;
	private boolean minContains;
	
	public AddChoiceResolution(boolean minContains) {
		this.minContains = minContains;
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		if(p instanceof ChoiceResolution){
			this.rootPanel = rootPanel;
			this.c = (ChoiceResolution) p;
			this.parent = parent;
		}	
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = view;
		this.parent = parent;
		
		return this;  
	}

	@Override
	public JComponent execute() {
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		vmMap.put(cp, c);

		CommandMouseListener listener = new CommandMouseListener();
		ToggleChoiceCommand command = new ToggleChoiceCommand();
		command.init(rootPanel, c, cp, vmMap, nodes, bindings, controller);
		listener.setLeftClickCommand(command);
		
		cp.addMouseListener(new ChoiceResolutionDropDownListener(cp, c, controller));
        cp.addMouseListener(listener);
		
        VSpec resolvedVSpec = CommonUtility.getResolvedVSpec(c);
        
		String choicename = (resolvedVSpec != null) ? resolvedVSpec.getName() : "NULL !!!";
		
        cp.setTitle((minContains?"(+) ":"") + choicename + " = " + (c instanceof PosResolution));
       
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
        Helper.bind(parent, cp, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}
}
