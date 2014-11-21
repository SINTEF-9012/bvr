package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.model.PrimitiveTypeFacade;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.VariableValueAssignmentDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.NamedElement;
import bvr.ValueResolution;


public class AddVariableResolution<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {

	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController view;
	protected JComponent parent;
	protected BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	protected ValueResolution c;
	protected boolean contains;


	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.rootPanel = rootPanel;
		this.c = (ValueResolution) p;
		this.parent = parent;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		this.parent = parent;
		return this;  
	}

	public JComponent execute() {
		VariableAssignmentPanel cp = new VariableAssignmentPanel();
		nodes.add(cp);
		vmMap.put(cp, c);
		
		CommandMouseListener listener = new CommandMouseListener();
		cp.addMouseListener(new VariableValueAssignmentDropDownListener(cp, view));
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        cp.addMouseListener(listener);
        
		String name = c.getName();
		String value = PrimitiveTypeFacade.getInstance().getValueAsString(c);

        cp.setTitle(name + " = " + value);
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
        Helper.bind(parent, cp, (BVRModelPanel) rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
