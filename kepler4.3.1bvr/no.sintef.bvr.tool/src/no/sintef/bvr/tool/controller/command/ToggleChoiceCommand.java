package no.sintef.bvr.tool.controller.command;


import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.NamedElement;


public class ToggleChoiceCommand<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {
	BVRNotifiableController controller;
	JComponent toToggle;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent toToggle, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
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
