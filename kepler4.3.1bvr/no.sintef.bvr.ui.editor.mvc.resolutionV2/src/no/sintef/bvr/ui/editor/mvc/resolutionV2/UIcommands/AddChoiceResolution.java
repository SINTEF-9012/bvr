package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;









import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.ToggleChoiceCommand;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ChoiceResolutionDropDownListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.CommandMouseListenerV2;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;

public class AddChoiceResolution implements UICommand {

	private boolean stripContains;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRResolutionToolView view;
	private JComponent parent;
	private BVRUIKernel rootPanel;
	private ChoiceResolution c;
	private CommandMouseListener listener;
	private boolean minContains;
	
	public AddChoiceResolution(boolean minContains, boolean stripContains) {
		this.minContains = minContains;
		this.stripContains = stripContains;
	}
	public UICommand init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRResolutionToolView view) {
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
	@Override
	public JComponent execute() {
		
	//	System.out.println("adding choice");
		
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		////////////////////////////////////
		CommandMouseListenerV2 listener = new CommandMouseListenerV2();
		ToggleChoiceCommand command = new ToggleChoiceCommand();
		command.init(view, null, c, true);
		listener.setLeftClickCommand(command);
		
		cp.addMouseListener(new ChoiceResolutionDropDownListenerV2(cp, c, vmMap,  (BVRResolutionToolView) view));
        cp.addMouseListener(listener);
		
		String choicename = "null";
		if(c.getResolvedVSpec() != null){
			choicename = c.getResolvedVSpec().getName();
		}
		
        cp.setTitle((minContains?"(+) ":"") + (stripContains?"(*) ":"") + choicename + " = " + (c instanceof PosResolution));
       
        
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (!( ((Choice)c.getResolvedVSpec()).isIsImpliedByParent())) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
        return cp;
        
	}

}
