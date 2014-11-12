package no.sintef.bvr.tool.controller.command;


import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.common.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;


public class ToggleChoiceCommand implements Command {
	BVRNotifiableController controller;
	JComponent toToggle;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent toToggle, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController _controller) {
		this.controller = _controller;
		this.toToggle = toToggle;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createToggleChoiceCommand(toToggle);
		command.execute();
		return toToggle;
	}
}
