package no.sintef.cvl.tool.chain.impl;

import no.sintef.cvl.tool.chain.ExecutionHandler;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.primitive.ExecutionRequest;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.PlacementIntersectionResolverStrategy;
import no.sintef.cvl.tool.strategy.impl.PlacementIntersectionLessStrategy;
import no.sintef.cvl.tool.strategy.impl.PlacementIntersectionLessTwinAbleStrategy;

public class IntersactionResolverExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private PlacementIntersectionResolverStrategy defaultStrategy;

	public IntersactionResolverExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		//defaultStrategy = new PlacementIntersectionLessStrategy();
		defaultStrategy = new PlacementIntersectionLessTwinAbleStrategy();
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
