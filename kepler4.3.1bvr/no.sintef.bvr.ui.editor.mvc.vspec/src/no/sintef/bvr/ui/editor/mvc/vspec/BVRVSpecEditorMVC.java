package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.BVREditorMVC;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.ISaveablePart;

public class BVRVSpecEditorMVC extends BVREditorMVC implements ISaveablePart, IResourceChangeListener, BVRNotifier {
	
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

}
