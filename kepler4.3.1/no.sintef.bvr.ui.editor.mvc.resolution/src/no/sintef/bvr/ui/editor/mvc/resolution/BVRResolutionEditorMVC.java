package no.sintef.bvr.ui.editor.mvc.resolution;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.BVREditorMVC;
import no.sintef.cvl.tool.ui.loader.BVRNotifier;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.ISaveablePart;

public class BVRResolutionEditorMVC extends BVREditorMVC implements ISaveablePart, IResourceChangeListener, BVRNotifier {

	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}
	
	public void setContents(JApplet a) {
		a.add(((ResolutionView)v).resPane);
	}

	public void createView(final BVRNotifier ep) {
		v = new ResolutionView(m, ep);
	}

}
