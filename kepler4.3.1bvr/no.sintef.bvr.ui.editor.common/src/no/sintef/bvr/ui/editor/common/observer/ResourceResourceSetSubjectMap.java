package no.sintef.bvr.ui.editor.common.observer;

import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;


public final class ResourceResourceSetSubjectMap extends AbstractResourceSubjectMap {
	
	public static final ResourceResourceSetSubjectMap eINSTANCE = getInstance();
	
	private static ResourceResourceSetSubjectMap getInstance(){
		return new ResourceResourceSetSubjectMap();
	}

	private ResourceResourceSetSubjectMap(){
		subjects = new HashMap<URI, List<ResourceSubject>>();
	}
}
