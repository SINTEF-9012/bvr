package no.sintef.cvl.tool.chain.impl;

import no.sintef.cvl.tool.chain.ExecutionHandler;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.primitive.ExecutionRequest;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

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
		Context.eINSTANCE.reloadModel(cvlModel);
		cvlView.notifyAllViews();
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
