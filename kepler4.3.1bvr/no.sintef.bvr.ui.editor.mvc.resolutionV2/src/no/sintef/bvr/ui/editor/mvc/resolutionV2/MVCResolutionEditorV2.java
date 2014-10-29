package no.sintef.bvr.ui.editor.mvc.resolutionV2;

//import java.awt.Toolkit;
import java.awt.Toolkit;
import java.io.File;
//import java.util.List;

import java.util.List;

import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
//import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
//import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
//import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
//import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;
//import no.sintef.bvr.ui.editor.common.observer.ResourceSavedSubject;
//import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.observer.ResolutionV2ResourceSetSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

public class MVCResolutionEditorV2 extends MVCEditor{

	@Override
	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
		//TODO
	}

	@Override
	public void setContents() {
		jApplet.add(((ResolutionRootController)v).getResolutionPane());
		// TODO Auto-generated method stub
	}
/*
 *create view object and add to subject list
 */
	@Override
	public void createView() {
		v = new ResolutionRootController(toolModel);
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);

	}
	//if a change occurs, check if is is a save, if not mark as not saved and post RefreshViewEvent to eventQueue . if it is a save, mark as saved. then run update.

	@Override
	public void update(ResourceSubject subject) {
		if(subject instanceof ResourceSetEditedSubject){
			toolModel.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet,v));
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