package no.sintef.bvr.engine.common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ResourceContentCopier extends Copier{

	private static final long serialVersionUID = -6292277081092094075L;
	
	private Resource originalResource;
	
	public void copyResource(Resource resource){
		clear();
		setOriginalResource(resource);
		EList<EObject> contents = resource.getContents();
		copyAll(contents);
		copyReferences();
	}

	public Resource getOriginalResource() {
		return originalResource;
	}

	private void setOriginalResource(Resource originalResource) {
		this.originalResource = originalResource;
	}

}
