package no.sintef.cvl.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.dropdown.VInstanceDropDownListener;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.elements.VInstancePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.MultiplicityInterval;
import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;

public class AddVInstance implements Command{

	private CVLUIKernel rootPanel;
	private JComponent parent;
	private VInstance vc;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.rootPanel = rootPanel;
		this.vc = (VInstance) p;
		this.parent = parent;
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}

	public JComponent execute() {
		//System.out.println("adding vinstance");
		
		//System.out.println("rootPanel is " + rootPanel);
		VInstancePanel c = new VInstancePanel(rootPanel.getModelPanel());
		nodes.add(c);
		
		CommandMouseListener listener = new CommandMouseListener();
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        c.addMouseListener(new VInstanceDropDownListener(c, vc, view, vmMap));
        c.addMouseListener(listener);
        
        //MultiplicityInterval m = vc.getInstanceMultiplicity();

        //I would prefer not to mix concerns (here validation. We should assume a valid CVL model as input).
        /*if(m == null){
        	throw new CVLModelException("VClassifier instance must have InstanceMultiplicity");
        }*/
/*        int l = m.getLower();
        int u = m.getUpper();
        c.setNameAndCardinality(vc.getName(), l, u);
 */  
		c.setName(vc.getName() + " : " + vc.getResolvedVSpec().getName());
        rootPanel.getModelPanel().addNode(c);
        
        Helper.bind(parent, c, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        
        return c;
	}

}
