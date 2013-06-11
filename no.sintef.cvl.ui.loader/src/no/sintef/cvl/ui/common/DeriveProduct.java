package no.sintef.cvl.ui.common;

import no.sintef.cvl.ui.chains.impl.ExecutionRealizationHandler;
import no.sintef.cvl.ui.chains.impl.ParserExecutionHandler;
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

	public DeriveProduct(ConfigurableUnit cu, VSpecResolution vSpecResolution) throws AbstractError{
		this.cu = cu;
		this.vSpecResolution = vSpecResolution;
		this.request = new SingleExecutionRequest(this.cu, this.vSpecResolution);
		
		ExecutionRealizationHandler realization = new ExecutionRealizationHandler(null);
		ScopeResolverExecutionHandler scopeResolving = new ScopeResolverExecutionHandler(realization);
		parsing = new ParserExecutionHandler(scopeResolving);
		
	}
	
	public void run() throws AbstractError{
		parsing.handleRequest(request);
	}
}
