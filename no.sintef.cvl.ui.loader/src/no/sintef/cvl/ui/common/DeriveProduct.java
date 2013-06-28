package no.sintef.cvl.ui.common;

import java.util.HashMap;

import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.chain.impl.ExecutionRealizationHandler;
import no.sintef.cvl.ui.chain.impl.ParserExecutionHandler;
import no.sintef.cvl.ui.chain.impl.ResetExecutionHandler;
import no.sintef.cvl.ui.chain.impl.SaveProductExecutionHandler;
import no.sintef.cvl.ui.chain.impl.ScopeResolverExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.primitive.impl.SingleExecutionRequest;


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
