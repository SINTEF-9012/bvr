package no.sintef.bvr.ui.editor.common.observer;

import java.util.List;

import org.eclipse.emf.common.util.URI;

public interface ResourceSubjectMap {
	
	public List<EditorSubject> getSubjects(URI resourceURI);	
	public void testResourceSubject(URI resourceURI, EditorSubject subject);
	public void pokeResourceSubjects(URI resourceURI);
}
