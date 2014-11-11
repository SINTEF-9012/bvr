package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;


import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VNode;
import bvr.VSpecResolution;

public class ShowInValidConstraintsResolution implements Command {

	private BVRUIKernel rootPanel;
	private Object v;
	private JComponent parent;
	private BVRNotifiableController controller;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
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
		if(v instanceof CompoundResolution) {
			VNode vNode = (VNode) CommonUtility.getResolvedVSpec((VSpecResolution) v);
			List<Constraint> constraints = vNode.getOwnedConstraint();
			List<Constraint> invalidConstraints = controller.getResolutionControllerInterface().getInvalidConstraints();
			for(Constraint constraint : constraints) {
				if(invalidConstraints.contains(constraint)){
					new ShowViolatedBCLConstraint().init(rootPanel, constraint, parent, vmMap, nodes, bindings, controller).execute();
				} else {
					new ShowBCLConstraintResolution().init(rootPanel, constraint, parent, vmMap, nodes, bindings, controller).execute();
				}
			}			
		}
		return parent;
	}

}
