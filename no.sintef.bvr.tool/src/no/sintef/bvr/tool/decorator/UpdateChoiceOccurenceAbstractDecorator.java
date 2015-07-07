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

import no.sintef.bvr.tool.controller.command.UpdateChoice;
import no.sintef.bvr.tool.controller.command.UpdateChoiceOccurence;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.NamedElement;
import bvr.Variable;

public abstract class UpdateChoiceOccurenceAbstractDecorator<EDITOR_PANEL, MODEL_PANEL> extends UpdateChoiceOccurence<EDITOR_PANEL, MODEL_PANEL>  {

	protected UpdateChoiceOccurence<EDITOR_PANEL, MODEL_PANEL> command;
	
	public UpdateChoiceOccurenceAbstractDecorator(UpdateChoiceOccurence<EDITOR_PANEL, MODEL_PANEL> _command) {
		super();
		command = _command;
	}

	@Override
	public Command init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
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
	public void setComment(String text) {
		command.setComment(text);
	}
	
	@Override
	public void setVariable(Variable v, String name, String type) {
		command.setVariable(v, name, type);
	}
	
	@Override
	public void setName(String name) {
		command.setName(name);
	}
	
	@Override
	public void setChoiceType(String type) {
		command.setChoiceType(type);
	}
}
