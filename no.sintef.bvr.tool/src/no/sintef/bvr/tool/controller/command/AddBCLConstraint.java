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
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.BCLConstraintDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import bvr.BCLConstraint;
import bvr.NamedElement;



public class AddBCLConstraint<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private BCLConstraint oc;
	private JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;
	private Map<JComponent, NamedElement> vmMap;
	
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.rootPanel = rootPanel;
		this.oc = (BCLConstraint) p;
		this.parent = parent;
		this.view = view;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		return this;
	}

	@SuppressWarnings("unchecked")
	public JComponent execute() {
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledPanel();
		nodes.add(constraint1);
		vmMap.put(constraint1, oc);
		Helper.bind(parent, constraint1, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		String s = view.getVSpecControllerInterface().getBCLConstraintString(constraint1);
		constraint1.setTitle(s);
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(constraint1);
		
		// Editor
		CommandMouseListener listener = new CommandMouseListener();
		constraint1.addMouseListener(listener);
		constraint1.title.addMouseListener(listener);
		
		constraint1.title.addMouseListener(new BCLConstraintDropDownListener(constraint1, vmMap, nodes, bindings, view));
		constraint1.addMouseListener(new BCLConstraintDropDownListener(constraint1, vmMap, nodes, bindings, view));
		
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, constraint1, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);

		
		return constraint1;
	}
}
