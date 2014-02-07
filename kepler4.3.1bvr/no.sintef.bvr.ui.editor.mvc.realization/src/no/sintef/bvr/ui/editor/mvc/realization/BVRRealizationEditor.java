package no.sintef.bvr.ui.editor.mvc.realization;

import java.io.File;

import javax.swing.JApplet;

import no.sintef.bvr.ui.editor.BVREditorMVC;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRNotifier;

import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.ui.PlatformUI;

public class BVRRealizationEditor extends BVREditorMVC implements IResourceChangeListener {

	public BVRRealizationEditor(){
		super();
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
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


}
