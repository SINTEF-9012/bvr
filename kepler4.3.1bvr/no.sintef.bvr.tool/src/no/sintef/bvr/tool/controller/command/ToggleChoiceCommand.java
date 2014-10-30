package no.sintef.bvr.tool.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.ChangeChoiceFacade;
import no.sintef.bvr.tool.model.InheritanceFacade;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ToggleChoiceCommand implements Command {
	VSpecResolution vsr;
	BVRNotifiableController view;
	JComponent toToggle;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent toToggle, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.view = view;
		this.toToggle = toToggle;
		return this;
	}

	@Override
	public JComponent execute() {
		view.getResolutionControllerInterface().toggleChoice(toToggle);

		return null;
	}
}
