package no.sintef.bvr.tool.chain.impl;

import bvr.ConfigurableUnit;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.TableBuilderStrategy;
import no.sintef.bvr.tool.strategy.impl.RRComposerStrategy;

public class ParserExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private TableBuilderStrategy defaultTableBuilder;

	public ParserExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultTableBuilder = new RRComposerStrategy();
	}
	
	public ParserExecutionHandler(ExecutionHandler successor, TableBuilderStrategy tableBuilder){
		this.successor = successor;
		this.defaultTableBuilder = tableBuilder;
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		
		ConfigurableUnit cu = (ConfigurableUnit) request.getDataField("cu");
		VSpecResolution vSpecResoulution = (VSpecResolution) request.getDataField("vSpecResolution");
		
		if(cu == null || vSpecResoulution == null){
			throw new UnexpectedException("configuration unit or root  vspec rezolution is not set");
		}
		
		SymbolTable table = this.defaultTableBuilder.buildSymbolTable(cu, vSpecResoulution);
		request.setDataField("productSymbolTable", table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
