package no.sintef.bvr.ui.editor.mvc.vspec;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;


public class MVCVSpecEditor extends MVCEditor {
	
	@Override
	public
	void setTitle() {
		setPartName(new File(filename).getName() + " (VSpec)");
	}
	
	@Override
	public
	void setContents() {
		jApplet.add(((VSpecRootController)controllerNotifiable).getEditorRootPanel());
	}
	

	@Override
	public
	void createView() {
		controllerNotifiable = new VSpecRootController(toolModel);
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
		subject.detach(this);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
}
