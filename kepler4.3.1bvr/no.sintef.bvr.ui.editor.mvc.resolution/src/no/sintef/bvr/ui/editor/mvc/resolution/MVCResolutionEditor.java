package no.sintef.bvr.ui.editor.mvc.resolution;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditorSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;



public class MVCResolutionEditor extends MVCEditor {
	

	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}
	
	public void setContents() {
		jApplet.add(((ResolutionView)v).resPane);
	}

	public void createView() {
		v = new ResolutionView(m);
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditorSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(ResourceSubject subject) {
		if(subject instanceof ResourceSetEditorSubject){
			m.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet,v));
		}
		if(subject instanceof ResourceSavedSubject){
			m.markSaved();
		}
		super.update(subject);
	}
	
	@Override
	public void dispose() {
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditorSubject subject = testResourceSetEditedSubject(subjects);
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
}
