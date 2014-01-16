package no.sintef.cvl.ui.editor.eclipse.editors;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.cvl.tool.ui.loader.BVRNotifier;
import no.sintef.cvl.tool.ui.loader.RealizationView;

import org.eclipse.core.resources.IResourceChangeListener;

public class BVRRealizationEditor extends BVRVSpecEditorMVC implements IResourceChangeListener {

	void setTitle() {
		setPartName(new File(filename).getName() + " (Realization)");
	}
	
	void setContents(JApplet a) {
		a.add(((RealizationView)v).realizationPanel);
	}

	void createView(final BVRNotifier ep) {
		v = new RealizationView(m, ep);
	}


}
