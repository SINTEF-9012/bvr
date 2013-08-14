package no.sintef.cvl.ui.chain.impl;

import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.primitive.ExecutionRequest;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.RealizationStrategy;
import no.sintef.cvl.ui.strategy.impl.DefaultRealizationStrategy;
import no.sintef.cvl.ui.strategy.impl.SimpleRealizationStrategy;

public class ExecutionRealizationHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private RealizationStrategy defaultStrategy;

	public ExecutionRealizationHandler(ExecutionHandler successor){
		this.successor = successor;
		//this.defaultStrategy = new SimpleRealizationStrategy();
		this.defaultStrategy = new DefaultRealizationStrategy();
	}
	
	public ExecutionRealizationHandler(ExecutionHandler successor, RealizationStrategy strategy){
		this.successor = successor;
		this.defaultStrategy = strategy;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolTable table = (SymbolTable) request.getDataField("productSymbolTable");
		
		if(table == null){
			throw new UnexpectedException("symbol table is not set");
		}
		
		this.defaultStrategy.deriveProduct(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
