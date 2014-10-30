package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.ChoiceResolution;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.ToggleChoiceCommand;
//import no.sintef.bvr.tool.ui.command.AddVInstance;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ChoiceResolutionDropDownListenerV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.CommandMouseListenerV2;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;

//import no.sintef.bvr.ui.framework.elements.VInstancePanel;

public class AddChoiceResolutionFromVClassifier implements UICommand {
	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	protected ChoiceResolution cr;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRResolutionToolView view;
	private boolean stripContains;
	private boolean minContains;

	public AddChoiceResolutionFromVClassifier(boolean minContains, boolean stripContains) {
		this.minContains = minContains;
		this.stripContains = stripContains;
	}

	@Override
	public JComponent execute() {
		// System.out.println("adding vinstance");
		// System.out.println("rootPanel is " + rootPanel);
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);

		CommandMouseListenerV2 listener = new CommandMouseListenerV2();
		// SelectInstanceCommandV2 command = new SelectInstanceCommandV2();
		// command.init(rootPanel, c, parent, vmMap, nodes, bindings, view);
		// listener.setLeftClickCommand(command);
		ToggleChoiceCommand command = new ToggleChoiceCommand();
		command.init(view, null, cr, true);
		listener.setLeftClickCommand(command);

		cp.addMouseListener(new ChoiceResolutionDropDownListenerV2(cp, cr, vmMap, view));
		cp.addMouseListener(listener);

		// MultiplicityInterval m = cr.getResolvedVClassifier().getInstanceMultiplicity();

		// I would prefer not to mix concerns (here validation. We should assume a valid BVR model as input).
		/*
		 * if(m == null){ throw new BVRModelException("VClassifier instance must have InstanceMultiplicity"); }
		 */

		// int l = m.getLower();
		// int u = m.getUpper();
		cp.setTitle((minContains ? "(+) " : "") + (stripContains ? "(*) " : "") + cr.getName() + " : " + cr.getResolvedVSpec().getName());
		rootPanel.getModelPanel().addNode(cp);
		Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);

		return cp;
	}

	public UICommand init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRResolutionToolView view) {
		this.rootPanel = rootPanel;
		this.cr = (ChoiceResolution) p;
		this.parent = parent;
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}


}
