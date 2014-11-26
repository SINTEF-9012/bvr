package no.sintef.bvr.ui.editor.common.observer;

import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;

public interface ResourceSubjectMap {
	
	public List<ResourceSubject> getSubjects(URI resourceURI);	
	public void testResourceSubject(URI resourceURI, ResourceSubject subject);
	public void pokeResourceSubjects(URI resourceURI);
}
