package no.sintef.bvr.tool.decorator;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.UpdateVClassOccurence;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.NamedElement;
import bvr.Variable;

public abstract class UpdateVClassOccurenceAbstractDecorator<EDITOR_PANEL, MODEL_PANEL> extends UpdateVClassOccurence<EDITOR_PANEL, MODEL_PANEL>  {

	protected UpdateVClassOccurence<EDITOR_PANEL, MODEL_PANEL> command;
	
	public UpdateVClassOccurenceAbstractDecorator(UpdateVClassOccurence<EDITOR_PANEL, MODEL_PANEL> _command) {
		super();
		command = _command;
	}

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {
		super.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
		return command.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
	}
	
	@Override
	public JComponent execute() {
		return command.execute();
	}
	
	@Override
	public void setComment(String text) {
		command.setComment(text);
	}
	
	@Override
	public void setVariable(Variable v, String name, String type) {
		command.setVariable(v, name, type);
	}
	
	@Override
	public void setName(String name) {
		command.setName(name);
	}
	
	@Override
	public void setLower(int lower) {
		command.setLower(lower);
	}
	
	@Override
	public void setUpper(int upper) {
		command.setUpper(upper);
	}
	
	@Override
	public void setType(String typeName) {
		command.setType(typeName);
	}
}
