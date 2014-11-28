package no.sintef.bvr.tool.controller;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.VType;
import bvr.VNode;
import no.sintef.bvr.tool.controller.command.AddVTypeRoot;
import no.sintef.bvr.tool.controller.command.UpdateBVRModel;
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
		JComponent rootComponent = new AddVTypeRoot<BVREditorPanel, BVRModelPanel>().init(uikernel, vType, null, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
		
		for(VNode vNode : vType.getMember())
			if(vNode instanceof CompoundNode)
				loadBVRView((CompoundNode) vNode, uikernel, rootComponent, model);
		
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

}
