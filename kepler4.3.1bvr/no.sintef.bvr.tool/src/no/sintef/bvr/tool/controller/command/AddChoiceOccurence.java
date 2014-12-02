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
import no.sintef.bvr.tool.ui.dropdown.ChoiceOccurenceDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.ChoiceOccurencePanel;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.ChoiceOccurrence;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VType;
import bvr.Variable;


public class AddChoiceOccurence<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private ChoiceOccurrence c;
	private JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;
	
	public AddChoiceOccurence(boolean minimized) {
		this.minimized = minimized;
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {

		this.rootPanel = rootPanel;
		this.c = (ChoiceOccurrence) p;
		this.parent = parent;
	
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;	
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public JComponent execute() {
		ChoiceOccurencePanel cp = new ChoiceOccurencePanel();
		nodes.add(cp);
        vmMap.put(cp, c);
        Helper.bind(parent, cp, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		CommandMouseListener listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceOccurenceDropDownListener(cp, vmMap, nodes, bindings, controller));
        cp.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, controller);
        listener.setLeftClickCommand(command);
        
        VType vType = c.getVType();
        String typeName = (vType != null) ? vType.getName() : Constants.DEFAULT_VTYPE_TITLE;
        
        cp.setTitle((minimized ? "(+) " : "") + c.getName() + " : " + typeName);
        
        String comment  = controller.getVSpecControllerInterface().getNodesCommentText(cp);
        if(!comment.equals(""))
        	cp.addAttribute("\""+comment+"\"", "");
        
        for(Variable v : c.getVariable()){
        	if(v.getType() instanceof PrimitveType)
        		cp.addAttribute(v.getName(), ((PrimitveType)v.getType()).getType().getName());
        	else
        		cp.addAttribute(v.getName(), v.getType().getName());
        }
        
		((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
        return cp;
	}

}
