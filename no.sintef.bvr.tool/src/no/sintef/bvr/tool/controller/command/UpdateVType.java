/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.NamedElement;

public class UpdateVType<EDITOR_PANEL, MODEL_PANEL> implements
		UpdateNamedElement<EDITOR_PANEL, MODEL_PANEL> {

	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected JComponent parent;
	protected NamedElement vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	protected String name;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(
			BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel,
			Object p, JComponent parent, Map<JComponent, NamedElement> vmMap,
			List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {

		this.rootPanel = rootPanel;
		this.vc = (NamedElement) p;
		this.parent = parent;
		this.name = vc.getName();

		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getVTypeControllerInterface().setNodeName(parent, name);
		return parent;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
