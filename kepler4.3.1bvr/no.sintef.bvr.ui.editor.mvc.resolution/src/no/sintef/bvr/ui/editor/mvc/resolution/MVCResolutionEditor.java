package no.sintef.bvr.ui.editor.mvc.resolution;

import java.io.File;
import java.util.List;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorObserver;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSubjectMap;
import no.sintef.bvr.ui.editor.mvc.resolution.observer.ResolutionResourceSetSubject;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;


public class MVCResolutionEditor extends MVCEditor implements EditorObserver {
	

	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}
	
	public void setContents(JApplet a) {
		a.add(((ResolutionView)v).resPane);
	}

	public void createView(final BVRNotifier ep) {
		v = new ResolutionView(m, ep);
		List<EditorSubject> subjects = ResourceSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResolutionResourceSetSubject subject = testResolutionResourceSetSubject(subjects);
		subject.attach(this);
		ResourceSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCResolutionEditor " + this + " " + subject);	
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
	
}
