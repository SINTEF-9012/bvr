package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.ResCommand;
import bvr.VSpec;
import bvr.VSpecResolution;

public class UnstripCommand implements ResCommand {
	private BVRNotifiableController  view;
	private VSpecResolution vsr;
	
	@Override
	public ResCommand init(BVRNotifiableController  view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.vsr = vsr;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		
		//view.setUnstripped(vsr);
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		
		a.add(vsr);
		
		return a;
		
	}

}
