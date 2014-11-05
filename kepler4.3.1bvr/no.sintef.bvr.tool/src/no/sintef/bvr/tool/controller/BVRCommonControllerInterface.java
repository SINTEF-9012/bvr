package no.sintef.bvr.tool.controller;

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
}
