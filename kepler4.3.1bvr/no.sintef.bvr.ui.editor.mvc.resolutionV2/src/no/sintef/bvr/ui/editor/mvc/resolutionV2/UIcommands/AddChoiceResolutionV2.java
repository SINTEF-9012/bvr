package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;





import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.AddChoiceResolutuion;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ChoiceResolutionDropDownListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.CommandMouseListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.ToggleChoiceCommand;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.PosResolution;

public class AddChoiceResolutionV2 implements UICommand {

	private boolean stripContains;
	//AddChoiceResolutuion command extended by resolutioneditor V2, changed to protected
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRResolutionToolView view;
	protected JComponent parent;
	protected BVRUIKernel rootPanel;
	protected ChoiceResolution c;
	protected CommandMouseListener listener;
	protected boolean minContains;
	
	public AddChoiceResolutionV2(boolean minContains, boolean stripContains) {
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
