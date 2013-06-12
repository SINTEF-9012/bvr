package no.sintef.cvl.ui.chains.impl;

import no.sintef.cvl.ui.chains.ExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.primitives.ExecutionRequest;

public class ResetExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;

	public ResetExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		CVLView cvlView = (CVLView) request.getDataField("cvlView");
		CVLModel cvlModel = (CVLModel) request.getDataField("cvlModel");
		if(cvlView == null){
			throw new UnexpectedException("cvlView is required to reset model");
		}
		cvlModel.reload();
		cvlView.notifyAllViews();
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
