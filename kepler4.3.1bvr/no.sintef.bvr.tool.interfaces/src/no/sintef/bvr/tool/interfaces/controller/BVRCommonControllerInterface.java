package no.sintef.bvr.tool.interfaces.controller;

import no.sintef.bvr.tool.interfaces.controller.RealizationControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.ResolutionControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;

public interface BVRCommonControllerInterface {
	
	@SuppressWarnings("rawtypes")
	public VSpecControllerInterface getVSpecControllerInterface();
	
	@SuppressWarnings("rawtypes")
	public ResolutionControllerInterface getResolutionControllerInterface();
	
	public RealizationControllerInterface getRealizationControllerInterface();
	
	@SuppressWarnings("rawtypes")
	public EditorsCommonControllerInterface getCommonControllerInterface();
	
	@SuppressWarnings("rawtypes")
	public void setCommonControllerInterface(EditorsCommonControllerInterface commonController);

	@SuppressWarnings("rawtypes")
	public VTypeControllerInterface getVTypeControllerInterface();
}
