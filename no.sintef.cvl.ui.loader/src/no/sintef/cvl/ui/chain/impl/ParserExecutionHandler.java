package no.sintef.cvl.ui.chain.impl;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;
import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.primitive.ExecutionRequest;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.TableBuilderStrategy;
import no.sintef.cvl.ui.strategy.impl.RRComposerStrategy;

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
