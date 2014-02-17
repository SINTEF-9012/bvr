package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorObserver;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.mvc.vspec.observer.VSpecResourseSetSubject;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;


public class MVCVSpecEditor extends MVCEditor  implements EditorObserver {
	
	public MVCVSpecEditor(){
		super();
		VSpecResourseSetSubject.eINSTANCE.attach(this);
	}
	
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
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCVSpecEditor " + this + " " + subject);
	}
}
