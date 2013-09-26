package no.sintef.cvl.tool.chain;

import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.primitive.ExecutionRequest;

public interface ExecutionHandler {

	public void handleRequest(ExecutionRequest request) throws AbstractError;
}
