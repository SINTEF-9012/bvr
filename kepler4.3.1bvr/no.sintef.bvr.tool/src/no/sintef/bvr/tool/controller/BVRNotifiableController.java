package no.sintef.bvr.tool.controller;

import bvr.BVRModel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;


public interface BVRNotifiableController {
	public BVRUIKernel getKernel() ;
	public BVRModel getBVRModel();
	public BVRToolModel getBVRToolModel();
	
	
	public void refresh();
	
	@SuppressWarnings("rawtypes")
	public VSpecControllerInterface getVSpecControllerInterface();
	
	public ResolutionControllerInterface getResolutionControllerInterface();
	
	public RealizationControllerInterface getRealizationControllerInterface();
}
