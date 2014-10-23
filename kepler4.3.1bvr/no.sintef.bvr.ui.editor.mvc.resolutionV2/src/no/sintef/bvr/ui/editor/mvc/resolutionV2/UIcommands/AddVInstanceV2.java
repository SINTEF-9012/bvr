package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import javax.swing.JComponent;

import bvr.MultiplicityInterval;
import no.sintef.bvr.tool.ui.command.AddVInstance;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.VInstanceDropDownListenerV2;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
//import no.sintef.bvr.ui.framework.elements.VInstancePanel;

public class AddVInstanceV2 extends AddVInstance implements Command {

	private boolean stripContains;

	public AddVInstanceV2(boolean minContains, boolean stripContains) {
		super(minContains);
		this.stripContains = stripContains;
	}

	@Override
	public JComponent execute() {
	
		// System.out.println("adding vinstance");

		// System.out.println("rootPanel is " + rootPanel);
		ChoiceResolutionPanel c = new ChoiceResolutionPanel();
		nodes.add(c);

		CommandMouseListener listener = new CommandMouseListener();
		SelectInstanceCommandV2 command = new SelectInstanceCommandV2();
		command.init(rootPanel, c, parent, vmMap, nodes, bindings, view);
		listener.setLeftClickCommand(command);
		c.addMouseListener(new VInstanceDropDownListenerV2(c, cr, view, vmMap));
		c.addMouseListener(listener);

		 MultiplicityInterval m = cr.getResolvedVClassifier().getInstanceMultiplicity();

		// I would prefer not to mix concerns (here validation. We should assume a valid BVR model as input).
		/*
		 * if(m == null){ throw new BVRModelException("VClassifier instance must have InstanceMultiplicity"); }
		 */
		
		  int l = m.getLower(); 
		  int u = m.getUpper(); 
		  c.setName(cr.getName());
		 
		
		
		c.setName((contains ? "(+) " : "") + (stripContains ? "(*) " : "") + cr.getName() + " : " + cr.getResolvedVSpec().getName());
		rootPanel.getModelPanel().addNode(c);

		Helper.bind(parent, c, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);

		return c;
	}

}
