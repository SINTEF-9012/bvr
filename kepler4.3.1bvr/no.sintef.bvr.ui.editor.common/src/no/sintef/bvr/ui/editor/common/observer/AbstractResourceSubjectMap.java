package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;

public abstract class AbstractResourceSubjectMap implements ResourceSubjectMap {

	protected HashMap<URI, List<ResourceSubject>> subjects;

	public List<ResourceSubject> getSubjects(URI resourceURI){
		return subjects.get(resourceURI);
	}
	
	public void testResourceSubject(URI resourceURI, ResourceSubject subject){
		List<ResourceSubject> list = subjects.get(resourceURI);
		if(list != null){
			if(!list.contains(subject)){
				list.add(subject);
			}
		}else{
			list = new ArrayList<ResourceSubject>();
			list.add(subject);
			subjects.put(resourceURI, list);
		}
	}
	
	public void pokeResourceSubjects(URI resourceURI){
		List<ResourceSubject> list = subjects.get(resourceURI);
		if(list != null){
			for(ResourceSubject s : list)
				s.notifyObservers();
		}
	}
}
