package no.sintef.cvl.ui.common;

import java.util.HashMap;

import no.sintef.cvl.ui.chains.ExecutionHandler;
import no.sintef.cvl.ui.chains.impl.ExecutionRealizationHandler;
import no.sintef.cvl.ui.chains.impl.ParserExecutionHandler;
import no.sintef.cvl.ui.chains.impl.ResetExecutionHandler;
import no.sintef.cvl.ui.chains.impl.SaveProductExecutionHandler;
import no.sintef.cvl.ui.chains.impl.ScopeResolverExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.primitives.impl.SingleExecutionRequest;


public class DeriveProduct {

	private SingleExecutionRequest request;
	private ExecutionHandler starter;

	public DeriveProduct(HashMap<String, Object> keywords) throws AbstractError{
		request = new SingleExecutionRequest(keywords);
		
		ResetExecutionHandler resetModel = new ResetExecutionHandler(null);
		SaveProductExecutionHandler saveProduct = new SaveProductExecutionHandler(resetModel);
		ExecutionRealizationHandler realization = new ExecutionRealizationHandler(saveProduct);
		ScopeResolverExecutionHandler scopeResolving = new ScopeResolverExecutionHandler(realization);
		starter = new ParserExecutionHandler(scopeResolving);
	}
	
	public void run() throws AbstractError{
		starter.handleRequest(request);
	}
}
