package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ChoiceDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.Note;
import bvr.PrimitveType;
import bvr.VNode;
import bvr.VSpec;
import bvr.Variable;


public class AddChoice implements Command {

	BVRUIKernel rootPanel;
	Choice c;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;
	
	public AddChoice(boolean minimized) {
		this.minimized = minimized;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
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
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (!c.isIsImpliedByParent()) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
		
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
        
		rootPanel.getModelPanel().addNode(cp);
        return cp;
	}

}
