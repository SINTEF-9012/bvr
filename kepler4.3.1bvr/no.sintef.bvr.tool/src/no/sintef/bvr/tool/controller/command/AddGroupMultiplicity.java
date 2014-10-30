package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VNode;

public class AddGroupMultiplicity implements Command {

	protected BVRUIKernel rootPanel;
	protected VSpec v;
	protected JComponent parent;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		if(p instanceof VSpec){
			this.rootPanel = rootPanel;
			this.v = (VSpec) p;
			this.parent = parent;
		}
		
		this.nodes = nodes;
		this.bindings = bindings;
		
		return this;
	}

	public JComponent execute() {
		if(((VNode) v).getGroupMultiplicity() != null){
			MultiplicityInterval m = ((VNode) v).getGroupMultiplicity();
			GroupPanel group = new GroupPanel();
			nodes.add(group);
			int l = m.getLower();
			int u = m.getUpper();
			group.setCardinality(l, u);
			rootPanel.getModelPanel().addNode(group);

			Helper.bind(parent, group, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
			
			return group;
		}
		return null;
	}

}
