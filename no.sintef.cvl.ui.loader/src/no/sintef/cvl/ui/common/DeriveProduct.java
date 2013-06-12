package no.sintef.cvl.ui.common;

import java.util.HashMap;

import javax.swing.JComponent;

import no.sintef.cvl.ui.chains.impl.ExecutionRealizationHandler;
import no.sintef.cvl.ui.chains.impl.ParserExecutionHandler;
import no.sintef.cvl.ui.chains.impl.SaveProductExecutionHandler;
import no.sintef.cvl.ui.chains.impl.ScopeResolverExecutionHandler;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.primitives.impl.SingleExecutionRequest;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class DeriveProduct {

	private VSpecResolution vSpecResolution;
	private ConfigurableUnit cu;
	private SingleExecutionRequest request;
	private ParserExecutionHandler parsing;

	public DeriveProduct(HashMap<String, Object> keywords) throws AbstractError{
		request = new SingleExecutionRequest(keywords);
		
		SaveProductExecutionHandler saveProduct = new SaveProductExecutionHandler(null);
		ExecutionRealizationHandler realization = new ExecutionRealizationHandler(saveProduct);
		ScopeResolverExecutionHandler scopeResolving = new ScopeResolverExecutionHandler(realization);
		parsing = new ParserExecutionHandler(scopeResolving);	
	}
	
	public void run() throws AbstractError{
		parsing.handleRequest(request);
	}
}
