package no.sintef.bvr.ui.editor.mvc.vspec;



import javax.swing.JComponent;






import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.controller.SwingVSpecController;
import no.sintef.bvr.tool.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;


public class VSpecRootController extends BVRToolAbstractController {
	
	private BVRToolModel m;
	private SwingVSpecController<JComponent, EObject> controller;


	public BVRUIKernel getKernel() {
		return null;
	}
	
	public VSpecRootController(BVRToolModel m) {
		this.m = m;
        controller = new SwingVSpecController<JComponent, EObject>(m, this);
        controller.render();
	}
	
	
	public EditableModelPanel getEditorRootPanel(){
		return controller.getEditorRoolPanel();
	}
	
	@Override
	public void refresh() {
		controller.notifyVspecViewUpdate();
	}
	
	@Override
	public VSpecControllerInterface<?,?> getVSpecControllerInterface() {
		return controller;
	}
}
