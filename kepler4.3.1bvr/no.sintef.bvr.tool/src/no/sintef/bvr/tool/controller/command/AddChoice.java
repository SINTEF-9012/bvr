package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ChoiceDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.Variable;


public class AddChoice<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private Choice c;
	private JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;
	
	public AddChoice(boolean minimized) {
		this.minimized = minimized;
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		if(p instanceof Choice){
			this.rootPanel = rootPanel;
			this.c = (Choice) p;
			this.parent = parent;
		}	
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public JComponent execute() {
		ChoicePanel cp = new ChoicePanel();
		nodes.add(cp);
        vmMap.put(cp, c);
        Helper.bind(parent, cp, (BVRModelPanel) rootPanel.getModelPanel(), (!c.isIsImpliedByParent()) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
		
		CommandMouseListener listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceDropDownListener(cp, vmMap, nodes, bindings, controller));
        cp.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, controller);
        listener.setLeftClickCommand(command);
        
        cp.setTitle((minimized?"(+) ":"") + c.getName());
        
        String comment  = controller.getVSpecControllerInterface().getNodesCommentText(cp);
        if(!comment.equals("")){
        	cp.addAttribute("\""+comment+"\"", "");
        }
        
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
