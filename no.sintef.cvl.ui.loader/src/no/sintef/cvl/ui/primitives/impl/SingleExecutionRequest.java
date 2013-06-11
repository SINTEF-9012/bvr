package no.sintef.cvl.ui.primitives.impl;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;
import no.sintef.cvl.ui.primitives.AbstractExecutionRequest;

public class SingleExecutionRequest extends AbstractExecutionRequest {
	
	public SingleExecutionRequest(ConfigurableUnit cu, VSpecResolution vSpecRezolution){
		this.cu = cu;
		this.vSpecResolution = vSpecRezolution;
	}
}
