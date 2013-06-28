package no.sintef.cvl.ui.chain;

import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.primitive.ExecutionRequest;

public interface ExecutionHandler {

	public void handleRequest(ExecutionRequest request) throws AbstractError;
}
