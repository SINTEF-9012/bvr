/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.decorator;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.controller.command.UpdateConstraint;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;

public abstract class UpdateConstraintAbstractDecorator<EDITOR_PANEL, MODEL_PANEL> extends
		UpdateConstraint<EDITOR_PANEL, MODEL_PANEL> {

	protected UpdateConstraint<EDITOR_PANEL, MODEL_PANEL> command;
	
	public UpdateConstraintAbstractDecorator(UpdateConstraint<EDITOR_PANEL, MODEL_PANEL> command){
		this.command = command;
	}
	
	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {
		super.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
		return command.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
	}
	
	@Override
	public JComponent execute() {
		return command.execute();
	}

	@Override
	public void setConstraint(String text) {
		command.setConstraint(text);
	}
	
	@Override
	public void setName(String name) {
		command.setName(name);
	}

}
