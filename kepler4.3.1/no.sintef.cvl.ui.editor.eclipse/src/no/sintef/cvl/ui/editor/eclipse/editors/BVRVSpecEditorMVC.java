package no.sintef.cvl.ui.editor.eclipse.editors;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.cvl.tool.ui.loader.BVRNotifier;
import no.sintef.cvl.tool.ui.loader.VSpecView;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.ISaveablePart;

public class BVRVSpecEditorMVC extends BVREditorMVC implements ISaveablePart, IResourceChangeListener, BVRNotifier {
	
	public BVRVSpecEditorMVC(){
		super();
	}

	@Override
	void setTitle() {
		setPartName(new File(filename).getName() + " (VSpec)");
	}
	
	@Override
	void setContents(JApplet a) {
		a.add(((VSpecView)v).vspecEpanel);
	}

	@Override
	void createView(final BVRNotifier ep) {
		v = new VSpecView(m, ep);
	}

}
