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
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import bvr.BCLConstraint;
import bvr.NamedElement;



public class ShowBCLConstraintResolution<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

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
		ParallelogramTitledPanel constraint = new ParallelogramTitledPanel();
		nodes.add(constraint);
		vmMap.put(constraint, oc);
		Helper.bind(parent, constraint, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		String s = controller.getResolutionControllerInterface().getBCLConstraintString(constraint);
		constraint.setTitle(s);
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(constraint);
		return constraint;
	}
}
