package no.sintef.cvl.tool.chain.impl;

import no.sintef.cvl.tool.chain.ExecutionHandler;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.primitive.ExecutionRequest;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.impl.PlacementTwinResolverStrategy;

public class TwinResolverExecutionHandler implements ExecutionHandler {
	
	private PlacementTwinResolverStrategy defaultStrategy;
	private ExecutionHandler successor;

	public TwinResolverExecutionHandler(ExecutionHandler _successor){
		defaultStrategy = new PlacementTwinResolverStrategy();
		successor = _successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolTable table = (SymbolTable) request.getDataField("productSymbolTable");
		if(table == null)
			throw new UnexpectedException("symbol table is not set, can not proceed");
		
		defaultStrategy.resolveTwins(table);
		
		if(successor != null)
			successor.handleRequest(request);
	}
}
