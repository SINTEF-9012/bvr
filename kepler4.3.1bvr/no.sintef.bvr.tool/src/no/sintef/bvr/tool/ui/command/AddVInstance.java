package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.VInstanceDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VClassifier;
//import bvr.VInstance;
import bvr.VSpec;

public class AddVInstance implements Command{

	//AddVInstance command extended by resolutioneditor V2, changed to protected
	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	//protected VInstance vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRToolView view;
	protected boolean contains;


	public AddVInstance(boolean contains) {
		this.contains = contains;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		this.rootPanel = rootPanel;
		//this.vc = (VInstance) p;
		this.parent = parent;
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}

	public JComponent execute() {
		
		VInstancePanel c = new VInstancePanel(rootPanel.getModelPanel());
		nodes.add(c);
		
		/*CommandMouseListener listener = new CommandMouseListener();
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        c.addMouseListener(new VInstanceDropDownListener(c, vc, view, vmMap));
        c.addMouseListener(listener);
          
		c.setName((contains?"(+) ":"") + vc.getName() + " : " + vc.getResolvedVSpec().getName());
        rootPanel.getModelPanel().addNode(c);
        
        Helper.bind(parent, c, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);*/
        
        return c;
	}

}
