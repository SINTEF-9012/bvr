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
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanelWithError;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VNode;
import bvr.VSpec;

public class ShowErrorGroup<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected VSpec v;
	protected JComponent parent;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		if (p instanceof VSpec) {
			this.rootPanel = rootPanel;
			this.v = (VSpec) p;
			this.parent = parent;
		}

		this.nodes = nodes;
		this.bindings = bindings;

		return this;
	}

	public JComponent execute() {
		if (!(v instanceof VNode))
			return null;
		MultiplicityInterval m = ((VNode) v).getGroupMultiplicity();
		GroupPanelWithError group = new GroupPanelWithError();
		nodes.add(group);
		int l = m.getLower();
		int u = m.getUpper();
		group.setCardinality(l, u);
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(group);

		Helper.bind(parent, group, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		return group;
	}



}
