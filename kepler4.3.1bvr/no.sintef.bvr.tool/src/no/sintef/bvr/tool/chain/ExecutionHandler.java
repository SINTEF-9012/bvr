package no.sintef.bvr.tool.chain;

import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.primitive.ExecutionRequest;

public interface ExecutionHandler {

	public void handleRequest(ExecutionRequest request) throws AbstractError;
}
