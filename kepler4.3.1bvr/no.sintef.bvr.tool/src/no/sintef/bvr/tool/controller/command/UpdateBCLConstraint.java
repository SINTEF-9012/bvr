package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;

public class UpdateBCLConstraint extends UpdateConstraint {

	private String text;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getVSpecControllerInterface().setNodeName(parent, name);
		controller.getVSpecControllerInterface().updateBCLConstraint(parent, text);
		return parent;
	}

	@Override
	public void setConstraint(String text) {
		this.text = text;  
	}

}
