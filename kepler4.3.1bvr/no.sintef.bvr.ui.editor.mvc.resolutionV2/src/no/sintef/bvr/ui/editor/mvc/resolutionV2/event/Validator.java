package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.util.List;



import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Validate;
import bvr.Constraint;
import bvr.VSpecResolution;

public class Validator implements Validate {
	 BVRResolutionToolView view;
	@Override
	public void validate(BVRResolutionToolView view, VSpecResolution vsr) {
		// TODO Auto-generated method stub
		this.view = view;
	}

	@Override
	public String getMessage() {
		
		return "validator is a test validate";
	}

	@Override
	public List<Constraint> getInvalidConstraints() {
		//System.out.println(view.getCU().getOwnedConstraint());
		return null; //view.getCU().getOwnedConstraint();
	}

}
