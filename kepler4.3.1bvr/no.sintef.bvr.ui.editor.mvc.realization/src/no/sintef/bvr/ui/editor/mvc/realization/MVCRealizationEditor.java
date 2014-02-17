package no.sintef.bvr.ui.editor.mvc.realization;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.observer.EditorObserver;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.mvc.realization.observer.RealizationResourceSetSubject;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;

public class MVCRealizationEditor extends MVCEditor implements EditorObserver {
	
	public MVCRealizationEditor(){
		super();
		RealizationResourceSetSubject.eINSTANCE.attach(this);
	}

	public void setTitle() {
		setPartName(new File(filename).getName() + " (Realization)");
	}
	
	public void setContents(JApplet a) {
		a.add(((RealizationView)v).realizationPanel);
	}

	public void createView(final BVRNotifier ep) {
		v = new RealizationView(m, ep);
	}

	@Override
	public void update(EditorSubject subject) {
		System.out.println("update for MVCRealizationEditor " + this + " " + subject);	
	}
}
