package no.sintef.cvl.ui.chain.impl;

import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.primitive.ExecutionRequest;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.PlacementIntersectionResolverStrategy;
import no.sintef.cvl.ui.strategy.impl.PlacementIntersectionLessStrategy;

public class IntersactionResolverExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private PlacementIntersectionResolverStrategy defaultStrategy;

	public IntersactionResolverExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		defaultStrategy = new PlacementIntersectionLessStrategy();
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolTable table = (SymbolTable) request.getDataField("productSymbolTable");
		if(table == null)
			throw new UnexpectedException("symbol table is not set, can not proceed");
		
		defaultStrategy.resolveIntersection(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
