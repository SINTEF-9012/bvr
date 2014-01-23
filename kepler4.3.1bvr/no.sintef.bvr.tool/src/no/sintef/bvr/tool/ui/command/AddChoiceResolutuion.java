package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.ChoiceResolutionDropDownListener;
import no.sintef.bvr.tool.ui.editor.CVLUIKernel;
import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.NamedElement;
import bvr.VSpec;

public class AddChoiceResolutuion implements Command {
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	private JComponent parent;
	private CVLUIKernel rootPanel;
	private ChoiceResolutuion c;
	private CommandMouseListener listener;

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		if(p instanceof ChoiceResolutuion){
			this.rootPanel = rootPanel;
			this.c = (ChoiceResolutuion) p;
			this.parent = parent;
		}	
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		this.parent = parent;
		
		return this;  
	}

	public JComponent execute() {
		//System.out.println("adding choice");
		
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceResolutionDropDownListener(cp, c, vmMap, view));
        cp.addMouseListener(listener);
		
		String choicename = "null";
		if(c.getResolvedVSpec() != null){
			choicename = c.getResolvedVSpec().getName();
		}
		
        cp.setTitle(choicename + " = " + c.isDecision());
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
