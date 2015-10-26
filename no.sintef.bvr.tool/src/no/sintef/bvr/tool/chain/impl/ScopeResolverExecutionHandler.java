/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.ScopeResolverStrategy;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeless;

public class ScopeResolverExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private ScopeResolverStrategy defaultStrategy;

	public ScopeResolverExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
		defaultStrategy = new ScopeResolverStrategyScopeless();
		//this.defaultStrategy = new ScopeResolverStrategyScopeable();
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolVSpecResolutionTable table = (SymbolVSpecResolutionTable) request.getDataField("productSymbolTable");
		if (table == null) {
			throw new UnexpectedException("symbol table is not set");
		}

		defaultStrategy.resolveScopes(table);

		if (successor != null)
			successor.handleRequest(request);
	}

}
