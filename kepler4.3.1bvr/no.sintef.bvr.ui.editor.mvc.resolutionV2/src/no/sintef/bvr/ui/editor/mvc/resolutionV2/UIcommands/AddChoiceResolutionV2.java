package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import javax.swing.JComponent;


import no.sintef.bvr.tool.ui.command.AddChoiceResolutuion;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ChoiceResolutionDropDownListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.CommandMouseListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.ToggleChoiceCommand;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.PosResolution;

public class AddChoiceResolutionV2 extends AddChoiceResolutuion implements Command {

	private boolean stripContains;

	public AddChoiceResolutionV2(boolean minContains, boolean stripContains) {
		super(minContains);
		this.stripContains = stripContains;
	}

	@Override
	public JComponent execute() {
		
		System.out.println("adding choice");
		
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		////////////////////////////////////
		CommandMouseListenerV2 listener = new CommandMouseListenerV2();
		ToggleChoiceCommand command = new ToggleChoiceCommand();
		command.init(null, null, c, true);
		listener.setLeftClickCommand(command);
		
		cp.addMouseListener(new ChoiceResolutionDropDownListenerV2(cp, c, vmMap,  (BVRResolutionToolView) view));
        cp.addMouseListener(listener);
		
		String choicename = "null";
		if(c.getResolvedVSpec() != null){
			choicename = c.getResolvedVSpec().getName();
		}
		
        cp.setTitle((contains?"(+) ":"") + (stripContains?"(*) ":"") + choicename + " = " + (c instanceof PosResolution));
       
        
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (!( ((Choice)c.getResolvedVSpec()).isIsImpliedByParent())) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
        return cp;
        
	}

}
