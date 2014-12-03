package no.sintef.bvr.ui.editor.mvc.realization;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import no.sintef.bvr.engine.common.SubstitutionEngine;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;


public class MVCRealizationEditor extends MVCEditor {
	
	public MVCRealizationEditor() {
		super();
		Context.eINSTANCE.testSubEngine(SubstitutionEngine.eINSTANCE);
	}
	
	public void setTitle() {
		setPartName(new File(filename).getName() + " (Realization)");
	}
	
	public void setContents() {
		jApplet.add(((RealizationRootController)controllerNotifiable).getEditorRootPanel());
	}

	public synchronized void createView() {
		controllerNotifiable = new RealizationRootController(toolModel);
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
	}

	@Override
	public void update(ResourceSubject subject) {	
		if(subject instanceof ResourceSetEditedSubject){
			toolModel.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet,controllerNotifiable));
		}
		if(subject instanceof ResourceSavedSubject){
			toolModel.markSaved();
		}
		super.update(subject);
	}
	
	@Override
	public void dispose() {
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.markObseleteObsever(this);
		
		ResourceSavedSubject subjectSaved = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		subjectSaved.markObseleteObsever(this);
		
		super.dispose();
	}
}
