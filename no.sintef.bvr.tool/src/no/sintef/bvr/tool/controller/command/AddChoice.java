/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ChoiceDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VNode;
import bvr.VType;
import bvr.Variable;

public class AddChoice<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private Choice c;
	private JComponent parent;

	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;

	public AddChoice(boolean minimized) {
		this.minimized = minimized;
	}

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		if (p instanceof Choice) {
			this.rootPanel = rootPanel;
			this.c = (Choice) p;
			this.parent = parent;
		}

		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;

		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public JComponent execute() {
		ChoicePanel cp = new ChoicePanel();
		nodes.add(cp);
		vmMap.put(cp, c);
		Helper.bind(parent, cp, (BVRModelPanel) rootPanel.getModelPanel(), (!c.isIsImpliedByParent()) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY,
				bindings);

		CommandMouseListener listener = new CommandMouseListener();
		cp.addMouseListener(new ChoiceDropDownListener(cp, vmMap, nodes, bindings, controller));
		cp.addMouseListener(listener);
		SelectInstanceCommand command = new SelectInstanceCommand();
		command.init(rootPanel, cp, parent, vmMap, nodes, bindings, controller);
		listener.setLeftClickCommand(command);

		String name = (c.getTarget() != null) ? c.getTarget().getName() : Constants.NULL_TARGET;

		cp.setTitle((minimized ? "(+) " : "") + name);

		String comment = controller.getVSpecControllerInterface().getNodesCommentText(cp);
		if (!comment.equals(""))
			cp.addAttribute("\"" + comment + "\"", "");

		for (Variable v : c.getVariable()) {
			if (v.getType() != null) {
				if (v.getType() instanceof PrimitveType)
					cp.addAttribute(v.getName(), ((PrimitveType) v.getType()).getType().getName());
				else
					cp.addAttribute(v.getName(), v.getType().getName());
			} else {
				cp.addAttribute(v.getName(), Constants.DEFAULT_TYPE_TITLE);
			}
		}

		for (VNode vNode : c.getMember()) {
			if (vNode instanceof VType) {
				VType vType = (VType) vNode;
				JLabel label = cp.addAttribute(vType.getName() + " : " + Constants.VSPEC_VTYPE_TITLE);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						controller.getVSpecControllerInterface().editVType(vNode, vType);
					}
				});
			}
		}

		((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
		return cp;
	}

}
