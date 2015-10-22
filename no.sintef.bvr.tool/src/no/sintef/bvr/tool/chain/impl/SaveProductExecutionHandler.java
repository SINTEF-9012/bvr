/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.chain.impl;

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;
import no.sintef.bvr.tool.strategy.impl.SimpleSaveProductStrategy;

public class SaveProductExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private SaveProductStrategy defaultStrategy;

	public SaveProductExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
		defaultStrategy = new SimpleSaveProductStrategy();
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		File destFile = (File) request.getDataField("destFile");

		if (destFile == null) {
			throw new UnexpectedException("require destinition file to handle this request");
		}

		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("destFile", destFile);

		defaultStrategy.saveProduct(keywords);

		if (successor != null)
			successor.handleRequest(request);
	}
}
