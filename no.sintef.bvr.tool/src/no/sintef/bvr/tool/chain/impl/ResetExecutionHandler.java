/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.ExecutionRequest;

public class ResetExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;

	public ResetExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		BVRNotifiableController bvrView = (BVRNotifiableController) request.getDataField("bvrView");
		BVRToolModel bvrModel = (BVRToolModel) request.getDataField("bvrModel");
		if(bvrView == null){
			throw new UnexpectedException("bvrView is required to reset model");
		}
		Context.eINSTANCE.reloadModel(bvrModel);
		//bvrView.notifyAllViews();
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
