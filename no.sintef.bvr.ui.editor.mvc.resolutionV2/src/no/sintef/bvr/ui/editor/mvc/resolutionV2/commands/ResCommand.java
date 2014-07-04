package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.VSpec;
import bvr.VSpecResolution;

public interface ResCommand {
	public ResCommand init(BVRView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance);
	public List <VSpecResolution> execute();
}
