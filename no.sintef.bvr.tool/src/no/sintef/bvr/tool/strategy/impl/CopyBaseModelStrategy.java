package no.sintef.bvr.tool.strategy.impl;

import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.Keywords;
import no.sintef.bvr.tool.strategy.IComputeBaseModelStrategy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import bvr.PosResolution;

public class CopyBaseModelStrategy implements IComputeBaseModelStrategy {

	@Override
	public void copyBaseModel(Keywords request, URI bvr_platform_uri, List<String> base_model_paths) {

		IResourceContentCopier copier = Context.eINSTANCE.getSubEngine().getResourceContentCopier();

		ResourceSet resSet = new ResourceSetImpl();
		Resource bvr_resource = resSet.getResource(bvr_platform_uri, true);
		copier.copyResourceContents(bvr_resource);

		HashMap<Resource, IResourceContentCopier> map = new HashMap<Resource, IResourceContentCopier>();

		for (String model : base_model_paths) {
			URI uri = URI.createPlatformResourceURI(model, true);
			Resource resource = resSet.getResource(uri, true);
			copier.copyResourceContents(resource);
			map.put(resource, copier);
		}
		copier.copyCrossContentsReferences();

		Context.eINSTANCE.getSubEngine().setCopyBaseModelMap(map);

		PosResolution originalResolution = (PosResolution) request.getDataField("PosResolution");
		PosResolution copiedResolution = (PosResolution) ((Copier) copier).get(originalResolution);

		if (copiedResolution == null)
			throw new UnexpectedException("Cannot find resolution to execute for in the copied models!");

		request.setDataField("model", bvr_resource.getContents().get(0));
		request.setDataField("PosResolution", copiedResolution);
	}

}
