package no.sintef.bvr.tool.controller.command;

import java.util.List;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.VSpec;
import bvr.VSpecResolution;


/**
 * @author Martin Holøs
 * ResCOmmands made to work with tools.Iterator
 * 
 */
public interface ResCommand {
	public ResCommand init(BVRToolModel toolModel, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance);
	public List <VSpecResolution> execute();
}
