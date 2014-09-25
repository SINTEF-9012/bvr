package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import java.util.List;


import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import bvr.Constraint;
import bvr.VSpecResolution;

public interface Validate {
	void validate(BVRViewV2 view, VSpecResolution vsr);
	String getMessage();
	List<Constraint> getInvalidConstraints();

}
