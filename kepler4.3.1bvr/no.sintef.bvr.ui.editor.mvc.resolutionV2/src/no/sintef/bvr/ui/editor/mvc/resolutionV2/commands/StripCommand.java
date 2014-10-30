package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.ResCommand;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.VSpec;
import bvr.VSpecResolution;

public class StripCommand implements ResCommand {
	private BVRToolModel  view;

	private VSpecResolution vsr;
	
	@Override
	public ResCommand init(BVRToolModel view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.vsr = vsr;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		//view.setStripped(vsr);
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		a.add(vsr);
		
		return a;
		
	}

}
