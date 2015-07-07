/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.mvc.type;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import bvr.VType;
import no.sintef.bvr.tool.controller.SwingVTypeController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.VTypeControllerInterface;
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
		controller.notifyViewUpdate();
	}

	public EditableModelPanel getEditorRootPanel() {
		return controller.getEditorRoolPanel();
	}

	@Override
	public VSpecControllerInterface<?,?, ?> getVSpecControllerInterface() {
		return controller;
	}
	
	@Override
	public VTypeControllerInterface<?, ?, ?> getVTypeControllerInterface() {
		return controller;
	}
}
