package no.sintef.bvr.tool.controller;


abstract public class BVRToolViewAbstract implements BVRNotifiableController{
	
	public int choiceCount = 1;
	
	public void setMaximized(Object v) {
		throw new UnsupportedOperationException("not supported for this view"); 
	}
	public void setMinimized(Object v) {
		throw new UnsupportedOperationException("not supported for this view");
	};
	
	public void refresh() {
		throw new UnsupportedOperationException("not supported for this view");
	};
	
	@Override
	public VSpecControllerInterface<?> getVSpecControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public ResolutionControllerInterface getResolutionControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public RealizationControllerInterface getRealizationControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
}
