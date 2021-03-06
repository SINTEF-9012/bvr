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
import no.sintef.bvr.ui.framework.ParallelogramTitledErrorPanel;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import bvr.BCLConstraint;
import bvr.NamedElement;

public class ShowViolatedBCLConstraint<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	BCLConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private Map<JComponent, NamedElement> vmMap;
	
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		this.rootPanel = rootPanel;
		this.oc = (BCLConstraint) p;
		this.parent = parent;
		this.controller = controller;
		this.vmMap = vmMap;
		
		this.nodes = nodes;
		this.bindings = bindings;
		
		return this;
	}

	@SuppressWarnings("unchecked")
	public JComponent execute() {
		ParallelogramTitledPanel constraint = new ParallelogramTitledErrorPanel();
		nodes.add(constraint);
		vmMap.put(constraint, oc);
		Helper.bind(parent, constraint, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);

		String s = controller.getResolutionControllerInterface().getBCLConstraintString(constraint);
		constraint.setTitle(s);
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(constraint);
		return constraint;
	}

}

