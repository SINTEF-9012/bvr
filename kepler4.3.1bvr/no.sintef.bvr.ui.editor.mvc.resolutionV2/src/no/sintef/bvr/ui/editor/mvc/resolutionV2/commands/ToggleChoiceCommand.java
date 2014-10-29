package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.ChangeChoice;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Inheritance;
import bvr.ChoiceResolution;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ToggleChoiceCommand implements ResCommand {
	VSpecResolution vsr;
	BVRResolutionToolView view;

	@Override
	public ResCommand init(BVRResolutionToolView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.vsr = vsr;
		this.view = view;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {

		if (vsr instanceof ChoiceResolution) {
			ChangeChoice.setChoiceResolution((ChoiceResolution)vsr,!(vsr instanceof PosResolution), view);
			Inheritance.getInstance().passInheritance((ChoiceResolution) vsr, true, view);
		}
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		a.add(vsr);
		return a;
	}

}
