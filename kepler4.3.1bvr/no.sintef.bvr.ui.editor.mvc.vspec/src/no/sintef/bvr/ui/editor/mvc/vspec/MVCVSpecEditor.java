package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.File;
import java.util.List;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceSavedSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
import no.sintef.bvr.ui.editor.mvc.vspec.observer.VSpecResourseSetSubject;


public class MVCVSpecEditor extends MVCEditor {
		
	@Override
	public
	void setTitle() {
		setPartName(new File(filename).getName() + " (VSpec)");
	}
	
	@Override
	public
	void setContents(JApplet a) {
		a.add(((VSpecView)v).vspecEpanel);
	}

	@Override
	public
	void createView() {
		v = new VSpecView(m);
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		VSpecResourseSetSubject subject = testVSpecResourseSetSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCVSpecEditor " + this + " " + subject);
		if(subject instanceof ResourceSetEditorSubject){
			m.markNotSaved();
			v.refresh();
		}
		if(subject instanceof ResourceSavedSubject){
			m.markSaved();
		}
		super.update(subject);
	}
	
	private VSpecResourseSetSubject testVSpecResourseSetSubject(List<EditorSubject> subjects){
		if(subjects != null){
			for(EditorSubject s : subjects){
				if(s instanceof VSpecResourseSetSubject){
					return (VSpecResourseSetSubject) s;
				}
			}
		}
		return new VSpecResourseSetSubject();
	}
	
	@Override
	public void dispose() {
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		VSpecResourseSetSubject subject = testVSpecResourseSetSubject(subjects);
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
}
