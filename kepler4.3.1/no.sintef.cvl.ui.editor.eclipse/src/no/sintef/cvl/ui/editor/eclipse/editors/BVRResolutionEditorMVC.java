package no.sintef.cvl.ui.editor.eclipse.editors;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.cvl.tool.ui.loader.BVRNotifier;
import no.sintef.cvl.tool.ui.loader.ResolutionView;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.ISaveablePart;

public class BVRResolutionEditorMVC extends BVRVSpecEditorMVC implements ISaveablePart, IResourceChangeListener, BVRNotifier {

	void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}
	
	void setContents(JApplet a) {
		a.add(((ResolutionView)v).resPane);
	}

	void createView(final BVRNotifier ep) {
		v = new ResolutionView(m, ep);
	}

}
