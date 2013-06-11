package no.sintef.cvl.ui.chains;

import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.primitives.ExecutionRequest;

public interface ExecutionHandler {

	public void handleRequest(ExecutionRequest request) throws AbstractError;
}
