package no.sintef.bvr.ui.editor.mvc.resolutionV2;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
//import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;
//import no.sintef.bvr.ui.editor.common.observer.ResourceSavedSubject;
//import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.observer.ResolutionV2ResourceSetSubject;

public class MVCResolutionEditorV2 extends MVCEditor{

	@Override
	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
		//TODO
	}

	@Override
	public void setContents() {
		jApplet.add(((ResolutionViewV2)v).resPane);
		// TODO Auto-generated method stub
	}
/*
 *create view object and add to subject list
 */
	@Override
	public void createView() {
		v = new ResolutionViewV2(m);
/*		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI); // get list of subjects
		ResolutionV2ResourceSetSubject subject = testResolutionV2ResourceSetSubject(subjects); //if this editor is not in the subjects list add
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);

		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);
*/
	}
	//if a change occurs, check if is is a save, if not mark as not saved and post RefreshViewEvent to eventQueue . if it si a save, mark as saved. then run update.
//	@Override
	/*public void update(EditorSubject subject) {
	//	System.out.println("update for MVCResolutionEditor " + this + " " + subject);
		if(subject instanceof ResourceSetEditorSubject){
			m.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet,v));
		}
		if(subject instanceof ResourceSavedSubject){
			m.markSaved();
		}
		super.update(subject);
	}

	private ResolutionV2ResourceSetSubject testResolutionV2ResourceSetSubject(List<EditorSubject> subjects){
		if(subjects != null){
			for(EditorSubject s : subjects){
				if(s instanceof ResolutionV2ResourceSetSubject){
					return (ResolutionV2ResourceSetSubject) s;
				}
			}
		}
		return new ResolutionV2ResourceSetSubject();
	}

	@Override
	public void dispose() {
		List<EditorSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResolutionV2ResourceSetSubject subject = testResolutionV2ResourceSetSubject(subjects);
		subject.detach(this);

		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.detach(this);
		super.dispose();
	}
*/
}