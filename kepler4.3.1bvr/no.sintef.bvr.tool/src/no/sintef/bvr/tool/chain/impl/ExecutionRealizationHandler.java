package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyBottomUp;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyDefault;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyScopeless;

public class ExecutionRealizationHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private RealizationStrategy defaultStrategy;

	public ExecutionRealizationHandler(ExecutionHandler successor){
		this.successor = successor;
		//this.defaultStrategy = new RealizationStrategyScopeless();
		//this.defaultStrategy = new RealizationStrategyDefault();
		this.defaultStrategy = new RealizationStrategyBottomUp();
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
