package no.sintef.bvr.tool.controller.command;

import java.util.List;

import no.sintef.bvr.tool.controller.BVRResolutionToolView;
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
