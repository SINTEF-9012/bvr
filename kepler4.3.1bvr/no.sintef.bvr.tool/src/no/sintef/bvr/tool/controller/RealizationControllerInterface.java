package no.sintef.bvr.tool.controller;

import no.sintef.bvr.tool.controller.command.SimpleExeCommand;
import no.sintef.bvr.tool.ui.loader.BVRRealizationUIKernelInterface;

public interface RealizationControllerInterface {

	BVRRealizationUIKernelInterface getUIKernel();
	
	SimpleExeCommand createPlacementFragmentCommand(boolean conatinment);
}
