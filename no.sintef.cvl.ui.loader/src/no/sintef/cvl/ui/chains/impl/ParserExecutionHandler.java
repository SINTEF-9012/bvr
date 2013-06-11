package no.sintef.cvl.ui.chains.impl;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;
import no.sintef.cvl.ui.chains.ExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.primitives.ExecutionRequest;
import no.sintef.cvl.ui.primitives.SymbolTable;
import no.sintef.cvl.ui.strategies.TableBuilderStrategy;
import no.sintef.cvl.ui.strategies.impl.ResRealizationComposerStrategy;

public class ParserExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private TableBuilderStrategy defaultTableBuilder;

	public ParserExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultTableBuilder = new ResRealizationComposerStrategy();
	}
	
	public ParserExecutionHandler(ExecutionHandler successor, TableBuilderStrategy tableBuilder){
		this.successor = successor;
		this.defaultTableBuilder = tableBuilder;
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		
		ConfigurableUnit cu = request.getConfigurableUnit();
		VSpecResolution vSpecResoulution = request.getProductRoot();
		
		if(cu == null || vSpecResoulution == null){
			throw new UnexpectedException("configuration unit or root  vspec rezolution is not set");
		}
		
		SymbolTable table = this.defaultTableBuilder.buildSymbolTable(cu, vSpecResoulution);
		request.setProductTable(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
