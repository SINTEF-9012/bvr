package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.eclipse.emf.common.util.URI;

public final class ResourceSubjectMap {
	
	private HashMap<URI, List<EditorSubject>> subjects;
	
	public static final ResourceSubjectMap eINSTANCE = getInstance();
	
	private static ResourceSubjectMap getInstance(){
		return new ResourceSubjectMap();
	}

	private ResourceSubjectMap(){
		subjects = new HashMap<URI, List<EditorSubject>>();
	}
	
	public List<EditorSubject> getSubjects(URI resourceURI){
		return subjects.get(resourceURI);
	}
	
	public void testResourceSubject(URI resourceURI, EditorSubject subject){
		List<EditorSubject> list = subjects.get(resourceURI);
		if(list != null){
			if(!list.contains(subject)){
				list.add(subject);
			}
		}else{
			list = new ArrayList<EditorSubject>();
			list.add(subject);
			subjects.put(resourceURI, list);
		}
	}
	
	public void pokeResourceSubjects(URI resourceURI){
		List<EditorSubject> list = subjects.get(resourceURI);
		if(list != null){
			for(EditorSubject s : list)
				s.notifyObservers();
		}
	}

}
