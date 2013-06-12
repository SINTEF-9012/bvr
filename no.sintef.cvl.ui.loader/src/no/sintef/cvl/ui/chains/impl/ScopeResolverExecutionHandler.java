package no.sintef.cvl.ui.chains.impl;

import no.sintef.cvl.ui.chains.ExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.primitives.ExecutionRequest;
import no.sintef.cvl.ui.primitives.SymbolTable;
import no.sintef.cvl.ui.strategies.ScopeResolverStrategy;
import no.sintef.cvl.ui.strategies.impl.SimpleScopeResolverStrategy;

public class ScopeResolverExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private ScopeResolverStrategy defaultStrategy;

	public ScopeResolverExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultStrategy = new SimpleScopeResolverStrategy();
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
