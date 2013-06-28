package no.sintef.cvl.ui.chain.impl;

import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.primitive.ExecutionRequest;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.ScopeResolverStrategy;
import no.sintef.cvl.ui.strategy.impl.SimpleScopeResolverStrategy;

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
