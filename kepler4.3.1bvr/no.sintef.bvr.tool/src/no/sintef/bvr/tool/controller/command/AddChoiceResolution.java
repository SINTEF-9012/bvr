package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ChoiceResolutionDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;


public class AddChoiceResolution implements Command {

	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private JComponent parent;
	private BVRUIKernel rootPanel;
	private ChoiceResolution c;
	private boolean minContains;
	
	public AddChoiceResolution(boolean minContains) {
		this.minContains = minContains;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		if(p instanceof ChoiceResolution){
			this.rootPanel = rootPanel;
			this.c = (ChoiceResolution) p;
			this.parent = parent;
		}	
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = view;
		this.parent = parent;
		
		return this;  
	}

	@Override
	public JComponent execute() {
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		vmMap.put(cp, c);

		CommandMouseListener listener = new CommandMouseListener();
		ToggleChoiceCommand command = new ToggleChoiceCommand();
		command.init(rootPanel, c, cp, vmMap, nodes, bindings, controller);
		listener.setLeftClickCommand(command);
		
		cp.addMouseListener(new ChoiceResolutionDropDownListener(cp, c, controller));
        cp.addMouseListener(listener);
		
        Choice resolvedChoice = (Choice) CommonUtility.getResolvedVSpec(c);
        
		String choicename = resolvedChoice.getName();
		
        cp.setTitle((minContains?"(+) ":"") + choicename + " = " + (c instanceof PosResolution));
       
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}
}
