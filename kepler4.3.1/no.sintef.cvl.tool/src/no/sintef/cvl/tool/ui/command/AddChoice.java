package no.sintef.cvl.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.command.event.AddChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.cvl.tool.ui.dropdown.ChoiceDropDownListener;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import cvl.Choice;
import cvl.NamedElement;
import cvl.PrimitveType;
import cvl.VSpec;
import cvl.Variable;

public class AddChoice implements Command {

	CVLUIKernel rootPanel;
	Choice c;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	
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
        

        
        
        cp.setTitle(c.getName());
        
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
