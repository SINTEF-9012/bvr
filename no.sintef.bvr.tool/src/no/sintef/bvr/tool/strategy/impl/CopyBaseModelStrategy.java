package no.sintef.bvr.tool.strategy.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.model.IBVREditingDomain;
import no.sintef.bvr.tool.model.BVREditingDomainFacade;
import no.sintef.bvr.tool.primitive.Keywords;
import no.sintef.bvr.tool.strategy.IComputeBaseModelStrategy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BVRModel;
import bvr.PosResolution;

public class CopyBaseModelStrategy implements IComputeBaseModelStrategy {

	@Override
	public void copyBaseModel(Keywords request, URI bvr_platform_uri, List<String> base_model_paths) {

		ResourceSet resSet = new ResourceSetImpl();

		IBVREditingDomain bvrExecutionDomain = BVREditingDomainFacade.eINSTANCE.testExecutionEditingDomain(resSet);
		Context.eINSTANCE.setCurrentExecutionEditingDomain(bvrExecutionDomain);
		TransactionalEditingDomain editingDomain = bvrExecutionDomain.getEditingDomain();

		IResourceContentCopier copier = Context.eINSTANCE.getSubEngine().getResourceContentCopier();
		copier.reset();
		copier.set(editingDomain);

		Resource bvr_resource = resSet.getResource(bvr_platform_uri, true);
		copier.copyResourceContents(bvr_resource);

		BVRModel original_model = (BVRModel) request.getDataField("model");
		PosResolution originalResolution = (PosResolution) request.getDataField("PosResolution");
		int resolution_index = original_model.getResolutionModels().indexOf(originalResolution);

		BVRModel buf_bvr_model = (BVRModel) bvr_resource.getContents().get(0);
		PosResolution buf_resolution = (PosResolution) buf_bvr_model.getResolutionModels().get(resolution_index);

		PosResolution copiedResolution = (PosResolution) ((Map) copier).get(buf_resolution);
		if (copiedResolution == null)
			throw new UnexpectedException("Cannot find resolution to execute for in the copied models!");

		HashMap<Resource, IResourceContentCopier> map = new HashMap<Resource, IResourceContentCopier>();

		for (String base_model_path : base_model_paths) {
			URI uri = URI.createPlatformResourceURI(base_model_path, true);
			Resource resource = resSet.getResource(uri, true);
			copier.copyResourceContents(resource);
			map.put(resource, copier);
		}

		copier.copyCrossContentsReferences();

		Context.eINSTANCE.getSubEngine().setCopyBaseModelMap(map);

		request.setDataField("model", bvr_resource.getContents().get(0));
		request.setDataField("PosResolution", copiedResolution);
	}
}
