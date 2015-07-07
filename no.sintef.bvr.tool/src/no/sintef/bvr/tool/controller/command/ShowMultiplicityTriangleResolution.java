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

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import bvr.CompoundResolution;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ShowMultiplicityTriangleResolution<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private Object v;
	private JComponent parent;
	private BVRNotifiableController controller;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {

		this.rootPanel = rootPanel;
		this.v = p;
		this.parent = parent;
		this.vmMap = vmMap;
		this.controller = controller;
		this.nodes = nodes;
		this.bindings = bindings;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		JComponent nextParent = parent;
		if(v instanceof CompoundResolution) {
			VSpec vspec = CommonUtility.getResolvedVSpec((VSpecResolution) v);
			MultiplicityInterval multiplicity = ((VNode) vspec).getGroupMultiplicity();
			if (multiplicity != null) {
				boolean error = controller.getResolutionControllerInterface().findGroupError((EObject) v);
				if (error) {
					nextParent = new ShowErrorGroup<EDITOR_PANEL, MODEL_PANEL>().init(rootPanel, CommonUtility.getResolvedVSpec((VSpecResolution) v), parent, vmMap, nodes, bindings, controller).execute();
				} else {
					nextParent = new AddGroupMultiplicity<EDITOR_PANEL, MODEL_PANEL>().init(rootPanel, CommonUtility.getResolvedVSpec((VSpecResolution) v), parent, vmMap, nodes, bindings, controller) .execute(); 
				}
			}
		}
		return nextParent;
	}
}
