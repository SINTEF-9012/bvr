package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;

public final class ResourceResourceSavedSubjectMap extends AbstractResourceSubjectMap {
		
	public static final ResourceResourceSavedSubjectMap eINSTANCE = getInstance();
	
	private static ResourceResourceSavedSubjectMap getInstance(){
		return new ResourceResourceSavedSubjectMap();
	}

	private ResourceResourceSavedSubjectMap(){
		subjects = new HashMap<URI, List<EditorSubject>>();
	}
	
	public ResourceSavedSubject testResourceSavedSubject(URI resourceURI){
		List<EditorSubject> subjs = subjects.get(resourceURI);
		if(subjs != null)
			return (ResourceSavedSubject) subjs.get(0);
		subjs = new ArrayList<EditorSubject>();
		subjs.add(new ResourceSavedSubject());
		subjects.put(resourceURI, subjs);
		return (ResourceSavedSubject) subjs.get(0);
	}
}
