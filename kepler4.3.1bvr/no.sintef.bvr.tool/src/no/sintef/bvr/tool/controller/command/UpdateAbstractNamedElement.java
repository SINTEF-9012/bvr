package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.NamedElement;


abstract public class UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> implements UpdateNamedElement<EDITOR_PANEL, MODEL_PANEL>  {


	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected NamedElement namedElement;
	protected JComponent parent;
	protected String name;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	protected String value;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent,
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
		controller.getCommonControllerInterface().setNodeName(parent, name);
		return parent;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
