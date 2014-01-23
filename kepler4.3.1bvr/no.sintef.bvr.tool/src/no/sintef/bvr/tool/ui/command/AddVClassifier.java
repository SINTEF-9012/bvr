package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.ClassifierDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.Variable;

public class AddVClassifier implements Command {
	
	BVRUIKernel rootPanel;
	VClassifier vc;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRView view;
	private boolean minimized;
	
	public AddVClassifier(boolean minimized) {
		this.minimized = minimized;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		if(p instanceof VClassifier){
			this.rootPanel = rootPanel;
			this.vc = (VClassifier) p;
			this.parent = parent;
		}
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}
	
	public JComponent execute() {
		VClassifierPanel c = new VClassifierPanel();
		nodes.add(c);
		
		CommandMouseListener listener = new CommandMouseListener();
        c.addMouseListener(new ClassifierDropDownListener(c, vmMap, nodes, bindings, view));
        c.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
		
        MultiplicityInterval m = vc.getInstanceMultiplicity();
        int l = m.getLower();
        int u = m.getUpper();
        c.setNameAndCardinality((minimized?"(+) ":"") + vc.getName(), l, u);
        
        for(VSpec vs : vc.getChild()){
        	if(vs instanceof Variable){
        		Variable v = (Variable) vs;
        		if(v.getType() instanceof PrimitveType)
        			c.addAttribute(v.getName(), ((PrimitveType)v.getType()).getType().getName());
        		else
        			c.addAttribute(v.getName(), v.getType().getName());
        		/*String name = v.getName().split(":")[0];
        		String type = v.getName().split(":")[1];
        		c.addAttribute(name, type);*/
        	}
        }
        
        rootPanel.getModelPanel().addNode(c);
        Helper.bind(parent, c, rootPanel.getModelPanel(), (parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
        return c;
	}

}
