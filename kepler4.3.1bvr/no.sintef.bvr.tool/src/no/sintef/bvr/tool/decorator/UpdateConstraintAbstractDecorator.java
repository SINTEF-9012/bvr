package no.sintef.bvr.tool.decorator;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.UpdateConstraint;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;

public abstract class UpdateConstraintAbstractDecorator extends
		UpdateConstraint {

	protected UpdateConstraint command;
	
	public UpdateConstraintAbstractDecorator(UpdateConstraint command){
		this.command = command;
	}
	
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
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
	public void setConstraint(String text) {
		command.setConstraint(text);
	}
	
	@Override
	public void setName(String name) {
		command.setName(name);
	}

}
