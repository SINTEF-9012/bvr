package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;

public class ResetExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;

	public ResetExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		CVLView bvrView = (CVLView) request.getDataField("bvrView");
		CVLModel bvrModel = (CVLModel) request.getDataField("bvrModel");
		if(bvrView == null){
			throw new UnexpectedException("bvrView is required to reset model");
		}
		Context.eINSTANCE.reloadModel(bvrModel);
		bvrView.notifyAllViews();
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
