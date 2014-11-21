package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.SwingVSpecController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;


public class VSpecRootController extends BVRToolAbstractController {
	
	private SwingVSpecController<JComponent, EObject, Serializable> controller;

	public VSpecRootController(BVRToolModel m) {
        controller = new SwingVSpecController<JComponent, EObject, Serializable>(m, this);
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
	public VSpecControllerInterface<?,?, ?> getVSpecControllerInterface() {
		return controller;
	}
}
