/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.mvc.realization;


import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.controller.SwingRealizationController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.RealizationControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;


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
