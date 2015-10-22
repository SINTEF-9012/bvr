package no.sintef.bvr.tool.strategy;

import java.util.List;

import no.sintef.bvr.tool.primitive.Keywords;

import org.eclipse.emf.common.util.URI;

public interface IComputeBaseModelStrategy {

	public void copyBaseModel(Keywords request, URI bvr_platform_uri, List<String> base_model_paths);

}
