package no.sintef.cvl.ui.chains.impl;

import no.sintef.cvl.ui.chains.ExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.primitives.ExecutionRequest;
import no.sintef.cvl.ui.primitives.SymbolTable;
import no.sintef.cvl.ui.strategies.RealizationStrategy;
import no.sintef.cvl.ui.strategies.impl.SimpleRealizationStrategy;

public class ExecutionRealizationHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private RealizationStrategy defaultStrategy;

	public ExecutionRealizationHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultStrategy = new SimpleRealizationStrategy();
	}
	
	public ExecutionRealizationHandler(ExecutionHandler successor, RealizationStrategy strategy){
		this.successor = successor;
		this.defaultStrategy = strategy;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolTable table = request.getProductTable();
		
		if(table == null){
			throw new UnexpectedException("symbol table is not set");
		}
		
		this.defaultStrategy.deriveProduct(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
