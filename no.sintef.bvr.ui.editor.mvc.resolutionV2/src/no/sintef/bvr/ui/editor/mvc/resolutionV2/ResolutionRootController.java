/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.mvc.resolutionV2;



import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.SwingResolutionController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.ResolutionControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;


public class ResolutionRootController extends BVRToolAbstractController {
	
	private BVRToolModel model;
	private SwingResolutionController<JComponent, EObject, Serializable> controller;
	
	public ResolutionRootController(BVRToolModel m) {
		model = m;
		controller = new SwingResolutionController<JComponent, EObject, Serializable>(model, this);
		controller.render();
	}

	public JTabbedPane getResolutionPane() {
		return controller.getResolutionPane();
	}

	@Override
	public void refresh() {
		controller.notifyResolutionViewUpdate();
	}
	
	@Override
	public ResolutionControllerInterface<?,?,?> getResolutionControllerInterface() {
		return controller;
	}

}
