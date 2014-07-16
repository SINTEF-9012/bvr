package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Inheritance;
import bvr.ChoiceResolutuion;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ToggleChoiceCommand implements ResCommand {
	VSpecResolution vsr;

	@Override
	public ResCommand init(BVRView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.vsr = vsr;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		if (vsr instanceof ChoiceResolutuion) {
			Context.eINSTANCE.getEditorCommands().setResolutionDecision((ChoiceResolutuion) vsr, !((ChoiceResolutuion) vsr).isDecision());
			Inheritance.getInstance().passInheritance( (ChoiceResolutuion) vsr, ((ChoiceResolutuion) vsr).isDecision());
		}
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		a.add(vsr);
		return a;
	}

}
