package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.File;
import java.util.List;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorObserver;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSubjectMap;
import no.sintef.bvr.ui.editor.mvc.vspec.observer.VSpecResourseSetSubject;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;


public class MVCVSpecEditor extends MVCEditor  implements EditorObserver {
		
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
	void createView(final BVRNotifier ep) {
		v = new VSpecView(m, ep);
		List<EditorSubject> subjects = ResourceSubjectMap.eINSTANCE.getSubjects(resourceURI);
		VSpecResourseSetSubject subject = testVSpecResourseSetSubject(subjects);
		subject.attach(this);
		ResourceSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCVSpecEditor " + this + " " + subject);
		v.refresh();
		
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
}
