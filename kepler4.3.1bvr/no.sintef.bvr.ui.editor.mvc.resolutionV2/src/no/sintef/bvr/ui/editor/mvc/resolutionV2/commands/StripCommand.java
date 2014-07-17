package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import bvr.VSpec;
import bvr.VSpecResolution;

public class StripCommand implements ResCommand {
	private BVRViewV2  view;

	private VSpecResolution vsr;
	
	@Override
	public ResCommand init(BVRViewV2  view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.vsr = vsr;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		view.setStripped(vsr);
		ArrayList<VSpecResolution> a = new ArrayList<VSpecResolution>();
		a.add(vsr);
		
		return a;
		
	}

}
