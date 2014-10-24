package no.sintef.bvr.ui.editor.mvc.realization;


import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.controller.RealizationControllerInterface;
import no.sintef.bvr.tool.controller.SwingRealizationController;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;


public class RealizationRootController extends BVRToolAbstractController {
	
	private BVRToolModel model;
	private SwingRealizationController controller;
		
	public RealizationRootController(BVRToolModel _model) {
		model = _model;
		controller = new SwingRealizationController(model, this);
	}

	@Override
	public void refresh() {
		controller.render();
	}
	
	public JTabbedPane getEditorRootPanel() {
		return controller.getRealizationPanel();
	}
	
	@Override
	public RealizationControllerInterface getRealizationControllerInterface() {
		return controller;
	}
}