package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.ChoiceResolution;
import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
//TODO import no.sintef.bvr.tool.ui.command.AddVInstance;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.SelectInstanceCommand;
import no.sintef.bvr.tool.ui.dropdown.ChoiceResolutionDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;

import no.sintef.bvr.tool.ui.loader.Pair;

import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;



public class AddChoiceResolutionFromVClassifier implements Command {
	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	protected ChoiceResolution cr;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController controller;
	private boolean minContains;

	public AddChoiceResolutionFromVClassifier(boolean minContains) {
		this.minContains = minContains;
	}

	@Override
	public JComponent execute() {
		ChoiceResolutionPanel cp = new ChoiceResolutionPanel();
		nodes.add(cp);
		vmMap.put(cp, cr);

		CommandMouseListener listener = new CommandMouseListener();
		SelectInstanceCommand command = new SelectInstanceCommand();
		command.init(rootPanel, cp, parent, vmMap, nodes, bindings, controller);
		listener.setLeftClickCommand(command);

		cp.addMouseListener(new ChoiceResolutionDropDownListener(cp, cr, controller));
        cp.addMouseListener(listener);

		cp.setTitle((minContains ? "(+) " : "") + cr.getName() + " : " + cr.getResolvedVSpec().getName());
		rootPanel.getModelPanel().addNode(cp);
		Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);

		return cp;
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		this.rootPanel = rootPanel;
		this.cr = (ChoiceResolution) p;
		this.parent = parent;
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		return this;
	}


}
