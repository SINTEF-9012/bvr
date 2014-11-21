package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.ConstraintPanel;
import bvr.NamedElement;
import bvr.OpaqueConstraint;
import bvr.VSpec;

public class AddOpaqueConstraint<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
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
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(constraint1);

		Helper.bind(parent, constraint1, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		return constraint1;
	}

}
