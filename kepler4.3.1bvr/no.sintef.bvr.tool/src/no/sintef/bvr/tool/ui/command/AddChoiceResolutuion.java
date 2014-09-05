package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.ChoiceResolutionDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;
import bvr.VSpec;

public class AddChoiceResolutuion implements Command {
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRToolView view;
	private JComponent parent;
	private BVRUIKernel rootPanel;
	private ChoiceResolution c;
	private CommandMouseListener listener;
	private boolean contains;

	public AddChoiceResolutuion(boolean contains) {
		this.contains = contains;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		if(p instanceof ChoiceResolution){
			this.rootPanel = rootPanel;
			this.c = (ChoiceResolution) p;
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
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceResolutionDropDownListener(cp, c, vmMap, view));
        cp.addMouseListener(listener);
		
		String choicename = "null";
		if(c.getResolvedVSpec() != null){
			choicename = c.getResolvedVSpec().getName();
		}
		
        cp.setTitle((contains?"(+) ":"") + choicename + " = " + ((c instanceof PosResolution) ? "true" : "false"));
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
