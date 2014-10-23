package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;

public class UpdateBVRModel implements UpdateNamedElement {
	
	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	protected NamedElement vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	
	protected String name;
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {
		
		if(p instanceof NamedElement){
			this.rootPanel = rootPanel;
			this.vc = (NamedElement) p;
			this.parent = parent;
			
			this.name = vc.getName();
		}
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		return this;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getVSpecControllerInterface().setNodeName(parent, name);
		return parent;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
