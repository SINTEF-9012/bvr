package no.sintef.bvr.engine.interfaces.common;

import org.eclipse.emf.ecore.resource.Resource;

public interface IResourceContentCopier {

	public void copyResource(Resource resource);
	
	public Resource getOriginalResource();
}
