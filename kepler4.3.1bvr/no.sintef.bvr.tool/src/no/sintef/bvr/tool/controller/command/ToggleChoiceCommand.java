package no.sintef.bvr.tool.controller.command;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.ChangeChoiceFacade;
import no.sintef.bvr.tool.model.InheritanceFacade;
import bvr.ChoiceResolution;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ToggleChoiceCommand implements ResCommand {
	VSpecResolution vsr;
	BVRNotifiableController view;

	@Override
	public ResCommand init(BVRNotifiableController view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.vsr = vsr;
		this.view = view;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {

		if (vsr instanceof ChoiceResolution) {
			//ChangeChoiceFacade.setChoiceResolution((ChoiceResolution)vsr,!(vsr instanceof PosResolution), view);
			//InheritanceFacade.getInstance().passInheritance((ChoiceResolution) vsr, true, view);
		}
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		a.add(vsr);
		return a;
	}

}
