package no.sintef.bvr.tool.controller;

public interface BVRCommonControllerInterface {
	
	@SuppressWarnings("rawtypes")
	public VSpecControllerInterface getVSpecControllerInterface();
	
	public ResolutionControllerInterface getResolutionControllerInterface();
	
	public RealizationControllerInterface getRealizationControllerInterface();
}
