package no.sintef.bvr.tool.controller;



abstract public class BVRToolAbstractController implements BVRNotifiableController {
	
	@SuppressWarnings("rawtypes")
	protected EditorsCommonControllerInterface commonInterface;
	
	abstract public void refresh();
	
	@Override
	public VSpecControllerInterface<?,?,?> getVSpecControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public ResolutionControllerInterface<?, ?, ?> getResolutionControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public RealizationControllerInterface getRealizationControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public EditorsCommonControllerInterface<?> getCommonControllerInterface() {
		return commonInterface;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void setCommonControllerInterface(EditorsCommonControllerInterface commonController) {
		commonInterface = commonController;
	}
	
}
