package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.Constraint;
import bvr.VSpecResolution;

public interface Validate {
	void validate(BVRView view, VSpecResolution vsr);
	String getMessage();
	List<Constraint> getInvalidConstraints();

}
