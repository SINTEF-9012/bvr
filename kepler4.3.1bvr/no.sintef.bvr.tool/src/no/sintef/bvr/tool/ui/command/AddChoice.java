package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.bvr.tool.ui.dropdown.ChoiceDropDownListener;
import no.sintef.bvr.tool.ui.editor.CVLUIKernel;
import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.Variable;

public class AddChoice implements Command {

	CVLUIKernel rootPanel;
	Choice c;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	private boolean minimized;
	
	public AddChoice(boolean minimized) {
		this.minimized = minimized;
	}

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		if(p instanceof Choice){
			this.rootPanel = rootPanel;
			this.c = (Choice) p;
			this.parent = parent;
		}	
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}
	
	public JComponent execute() {
		ChoicePanel cp = new ChoicePanel();
		nodes.add(cp);
		
		CommandMouseListener listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceDropDownListener(cp, vmMap, nodes, bindings, view));
        cp.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        

        
        
        cp.setTitle((minimized?"(+) ":"") + c.getName());
        
        for(VSpec vs : c.getChild()){
        	if(vs instanceof Variable){
        		Variable v = (Variable) vs;
        		if(v.getType() instanceof PrimitveType)
        			cp.addAttribute(v.getName(), ((PrimitveType)v.getType()).getType().getName());
        		else
        			cp.addAttribute(v.getName(), v.getType().getName());
        		/*String name = v.getName().split(":")[0];
        		String type = v.getName().split(":")[1];
        		c.addAttribute(name, type);*/
        	}
        }

        rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (!c.isIsImpliedByParent()) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
