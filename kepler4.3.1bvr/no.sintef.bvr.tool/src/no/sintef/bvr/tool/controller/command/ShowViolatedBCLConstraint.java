
package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.ParallelogramTitledErrorPanel;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;

import bvr.BCLConstraint;
import bvr.NamedElement;

public class ShowViolatedBCLConstraint implements Command {

	BVRUIKernel rootPanel;
	BCLConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private Map<JComponent, NamedElement> vmMap;
	
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
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
		Helper.bind(parent, constraint, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);

		String s = controller.getResolutionControllerInterface().getBCLConstraintString(constraint);
		constraint.setTitle(s);
		rootPanel.getModelPanel().addNode(constraint);
		return constraint;
	}

}

