package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.VSpec;
import bvr.VSpecResolution;

public class UnstripCommand implements ResCommand {
	private BVRResolutionToolView  view;
	private VSpecResolution vsr;
	
	@Override
	public ResCommand init(BVRResolutionToolView  view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.vsr = vsr;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		
		view.setUnstripped(vsr);
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		
		a.add(vsr);
		
		return a;
		
	}

}
