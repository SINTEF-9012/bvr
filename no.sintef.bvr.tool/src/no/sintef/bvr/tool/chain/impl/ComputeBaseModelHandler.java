package no.sintef.bvr.tool.chain.impl;

import java.util.List;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.model.BVRTransactionalModel;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.strategy.IComputeBaseModelStrategy;
import no.sintef.bvr.tool.strategy.impl.CopyBaseModelStrategy;

import org.eclipse.emf.common.util.URI;

public class ComputeBaseModelHandler implements ExecutionHandler {

	IComputeBaseModelStrategy default_strategy = new CopyBaseModelStrategy();
	private ExecutionHandler successor;

	public ComputeBaseModelHandler(ExecutionHandler _successor) {
		default_strategy = new CopyBaseModelStrategy();
		successor = _successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {

		BVRTransactionalModel bvr_tool_model = (BVRTransactionalModel) request.getDataField("model");
		URI bvr_platform_uri = bvr_tool_model.getResource().getURI();
		List<String> base_model_files = bvr_tool_model.getBaseModelPaths();
		default_strategy.copyBaseModel(request, bvr_platform_uri, base_model_files);

		if (successor != null)
			successor.handleRequest(request);
	}

}
