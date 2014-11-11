package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.CompoundResolution;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ShowMultiplicityTriangleResolution implements Command {

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
		JComponent nextParent = parent;
		if(v instanceof CompoundResolution) {
			VSpec vspec = CommonUtility.getResolvedVSpec((VSpecResolution) v);
			MultiplicityInterval multiplicity = ((VNode) vspec).getGroupMultiplicity();
			if (multiplicity != null) {
				boolean error = controller.getResolutionControllerInterface().findGroupError((EObject) v);
				if (error) {
					nextParent = new ShowErrorGroup().init(rootPanel, CommonUtility.getResolvedVSpec((VSpecResolution) v), parent, vmMap, nodes, bindings, controller).execute();
				} else {
					nextParent = new AddGroupMultiplicity().init(rootPanel, CommonUtility.getResolvedVSpec((VSpecResolution) v), parent, vmMap, nodes, bindings, controller) .execute(); 
				}
			}
		}
		return nextParent;
	}
}
