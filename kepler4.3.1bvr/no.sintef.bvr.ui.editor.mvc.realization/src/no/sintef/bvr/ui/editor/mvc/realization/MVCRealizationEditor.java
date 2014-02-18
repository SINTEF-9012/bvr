package no.sintef.bvr.ui.editor.mvc.realization;

import java.io.File;
import java.util.List;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceSavedSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
import no.sintef.bvr.ui.editor.mvc.realization.observer.RealizationResourceSetSubject;


public class MVCRealizationEditor extends MVCEditor{
	
	public void setTitle() {
		setPartName(new File(filename).getName() + " (Realization)");
	}
	
	public void setContents(JApplet a) {
		a.add(((RealizationView)v).realizationPanel);
	}

	public void createView() {
		v = new RealizationView(m);
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		RealizationResourceSetSubject subject = testRealizationResourceSetSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(EditorSubject subject) {
		if(subject instanceof ResourceSetEditorSubject){
			m.markNotSaved();
			v.refresh();
		}
		if(subject instanceof ResourceSavedSubject){
			m.markSaved();
		}
		super.update(subject);
		System.out.println("update for MVCRealizationEditor " + this + " " + subject);	
	}
	
	private RealizationResourceSetSubject testRealizationResourceSetSubject(List<EditorSubject> subjects){
		if(subjects != null){
			for(EditorSubject s : subjects){
				if(s instanceof RealizationResourceSetSubject){
					return (RealizationResourceSetSubject) s;
				}
			}
		}
		return new RealizationResourceSetSubject();
	}
	
	@Override
	public void dispose() {
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		RealizationResourceSetSubject subject = testRealizationResourceSetSubject(subjects);
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
}
