package no.sintef.bvr.tool.controller;

import bvr.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;


public interface BVRNotifiableController extends BVRCommonControllerInterface {
	
	//We need to get rid of these three methods!
	//public BVRUIKernel getKernel() ;
	public BVRModel getBVRModel();
	public BVRToolModel getBVRToolModel();
	
	
	public void refresh();
	
}
