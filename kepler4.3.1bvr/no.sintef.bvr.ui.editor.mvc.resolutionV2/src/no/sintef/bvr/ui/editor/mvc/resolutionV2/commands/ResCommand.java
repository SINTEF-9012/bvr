package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.List;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.VSpec;
import bvr.VSpecResolution;


/**
 * @author Martin Holøs
 * ResCOmmands made to work with tools.Iterator
 * 
 */
public interface ResCommand {
	public ResCommand init(BVRResolutionToolView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance);
	public List <VSpecResolution> execute();
}
