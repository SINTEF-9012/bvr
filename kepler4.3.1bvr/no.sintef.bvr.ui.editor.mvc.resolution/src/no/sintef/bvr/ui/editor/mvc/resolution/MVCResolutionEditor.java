package no.sintef.bvr.ui.editor.mvc.resolution;

import java.io.File;
import java.util.List;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceSavedSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
import no.sintef.bvr.ui.editor.mvc.resolution.observer.ResolutionResourceSetSubject;


public class MVCResolutionEditor extends MVCEditor {
	

	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}
	
	public void setContents(JApplet a) {
		a.add(((ResolutionView)v).resPane);
	}

	public void createView() {
		v = new ResolutionView(m);
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResolutionResourceSetSubject subject = testResolutionResourceSetSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCResolutionEditor " + this + " " + subject);
		if(subject instanceof ResourceSetEditorSubject){
			m.markNotSaved();
			v.refresh();
		}
		if(subject instanceof ResourceSavedSubject){
			m.markSaved();
		}
		super.update(subject);
	}
	
	private ResolutionResourceSetSubject testResolutionResourceSetSubject(List<EditorSubject> subjects){
		if(subjects != null){
			for(EditorSubject s : subjects){
				if(s instanceof ResolutionResourceSetSubject){
					return (ResolutionResourceSetSubject) s;
				}
			}
		}
		return new ResolutionResourceSetSubject();
	}
	
	@Override
	public void dispose() {
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResolutionResourceSetSubject subject = testResolutionResourceSetSubject(subjects);
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
}
