package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;


public class UpdateVariableValueAssignment implements UpdateNamedElement  {


	protected BVRUIKernel rootPanel;
	protected NamedElement namedElement;
	protected JComponent parent;
	protected String name;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	protected String value;

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {
		this.rootPanel = rootPanel;
		this.namedElement = (NamedElement) p;
		this.parent = parent;	
		this.name = namedElement.getName();
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getResolutionControllerInterface().setValueResolutionValue(parent, value);
		controller.getResolutionControllerInterface().setValueResolutionName(parent, name);
		return parent;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
