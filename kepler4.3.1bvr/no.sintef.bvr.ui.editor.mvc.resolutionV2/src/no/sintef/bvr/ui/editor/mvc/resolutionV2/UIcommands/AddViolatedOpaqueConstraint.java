package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import bvr.NamedElement;
import bvr.OpaqueConstraint;

public class AddViolatedOpaqueConstraint implements Command {

	BVRUIKernel rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.rootPanel = rootPanel;
		this.oc = (OpaqueConstraint) p;
		this.parent = parent;	
		
		this.nodes = nodes;
		this.bindings = bindings;
		
		return this;
	}

	public JComponent execute() {
		//ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledPanel();
		nodes.add(constraint1);
		constraint1.setTitle("OpaqueConstraint(\""+ oc.getConstraintLanguage() + "\", \"" + oc.getConstraint() + "\")");
		//constraint1.setConstraint(oc.getConstraint());
		rootPanel.getModelPanel().addNode(constraint1);

		Helper.bind(parent, constraint1, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		return constraint1;
	}

}
