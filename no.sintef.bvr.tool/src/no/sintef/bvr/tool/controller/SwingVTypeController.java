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
package no.sintef.bvr.tool.controller;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.VSpec;
import bvr.VType;
import bvr.VNode;
import no.sintef.bvr.tool.controller.command.AddVTypeRoot;
import no.sintef.bvr.tool.controller.command.UpdateVType;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.VTypeControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;


public class SwingVTypeController<GUI_NODE extends JComponent, MODEL_OBJECT extends EObject, SERIALIZABLE extends Serializable>
		extends
			SwingVSpecController<GUI_NODE, MODEL_OBJECT, SERIALIZABLE>
		implements
			VTypeControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> {

	private VType vType;

	public SwingVTypeController(BVRToolModel _model, VType _vType,
			BVRNotifiableController _controller) {
		super(_model, _controller);
		vType = _vType;
	}
	
	@Override
	protected void loadBVRView(BVRModel model, BVRUIKernel<BVREditorPanel, BVRModelPanel> uikernel) throws BVRModelException {
		if(vType == null)
			return;

		JComponent rootComponent = new AddVTypeRoot<BVREditorPanel, BVRModelPanel>().init(uikernel, vType, null, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
		
		for(VNode vNode : vType.getMember())
			if(vNode instanceof VSpec)
				loadBVRView((VSpec) vNode, uikernel, rootComponent, model);
		
		vSpecbvruikernel.getModelPanel().layoutTreeNodes(strategy);
	}

	@Override
	public void render() {
		loadBVRView(toolModel.getBVRModel(), vSpecbvruikernel);
	}

	@Override
	public Command<?, ?> createUpdateVTypeCommand(GUI_NODE elem) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateVType<BVREditorPanel, BVRModelPanel>();
    	command.init(vSpecbvruikernel, vspecvmMap.get(elem), elem, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void removeVType(GUI_NODE parent) {
		VType type = (VType) vspecvmMap.get(parent);
		toolModel.removeVType(type);
	}

}
