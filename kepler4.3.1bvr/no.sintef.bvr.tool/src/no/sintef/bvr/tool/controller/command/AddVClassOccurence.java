package no.sintef.bvr.tool.controller.command;


import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ClassOccurenceDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.elements.VClassOccurencePanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VClassOccurrence;
import bvr.VNode;
import bvr.Variable;


public class AddVClassOccurence<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {
	
	BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	VClassOccurrence vc;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;
	
	public AddVClassOccurence(boolean minimized) {
		this.minimized = minimized;
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		
		this.rootPanel = rootPanel;
		this.vc = (VClassOccurrence) p;
		this.parent = parent;

		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		
		return this;
	}
	
	public JComponent execute() {
		VClassOccurencePanel c = new VClassOccurencePanel();
		nodes.add(c);
		vmMap.put(c, vc);
		Helper.bind(parent, c, (BVRModelPanel) rootPanel.getModelPanel(), (parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
		
		CommandMouseListener listener = new CommandMouseListener();
        c.addMouseListener(new ClassOccurenceDropDownListener(c, vmMap, nodes, bindings, controller));
        c.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c, parent, vmMap, nodes, bindings, controller);
        listener.setLeftClickCommand(command);
		
        MultiplicityInterval m = vc.getInstanceMultiplicity();
        int l = m.getLower();
        int u = m.getUpper();
        
        String typeName = (vc.getVType() != null) ? vc.getVType().getName() : Constants.DEFAULT_VTYPE_TITLE;

        c.setNameTypeCardinality((minimized?"(+) ":"") + vc.getName(), typeName, l, u);
        
        for(Variable v : ((VNode) vc).getVariable()){
        	if(v.getType() instanceof PrimitveType)
        		c.addAttribute(v.getName(), ((PrimitveType)v.getType()).getType().getName());
        	else
        		c.addAttribute(v.getName(), v.getType().getName());
        }
        
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(c);
        return c;
	}

}
