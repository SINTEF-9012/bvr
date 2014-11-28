package no.sintef.bvr.ui.editor.mvc.type;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import bvr.VType;
import no.sintef.bvr.tool.controller.SwingVTypeController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;

public class VTypeRootController extends BVRToolAbstractController {

	private SwingVTypeController<JComponent, EObject, Serializable> controller;

	public VTypeRootController(BVRToolModel toolModel, VType vType) {
		controller = new SwingVTypeController<JComponent, EObject, Serializable>(
				toolModel, vType, this);
		controller.render();
	}

	@Override
	public void refresh() {
		controller.render();
	}

	public EditableModelPanel getEditorRootPanel() {
		return controller.getEditorRoolPanel();
	}

}