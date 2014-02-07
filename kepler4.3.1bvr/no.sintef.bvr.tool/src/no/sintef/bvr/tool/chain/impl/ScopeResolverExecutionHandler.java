package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.ScopeResolverStrategy;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeable;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeless;

public class ScopeResolverExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private ScopeResolverStrategy defaultStrategy;

	public ScopeResolverExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		//this.defaultStrategy = new ScopeResolverStrategyScopeless();
		this.defaultStrategy = new ScopeResolverStrategyScopeable();
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolTable table = (SymbolTable) request.getDataField("productSymbolTable");
		if(table == null){
			throw new UnexpectedException("symbol table is not set");
		}
		
		this.defaultStrategy.resolveScopes(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
