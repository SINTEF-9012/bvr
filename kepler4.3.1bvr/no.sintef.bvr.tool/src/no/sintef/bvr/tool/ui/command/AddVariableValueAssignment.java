package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.SelectInstanceCommand;
import no.sintef.bvr.tool.model.PrimitiveTypeFacade;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;

import bvr.NamedElement;
import bvr.ValueResolution;


public class AddVariableValueAssignment implements Command {

	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController view;
	protected JComponent parent;
	protected BVRUIKernel rootPanel;
	protected ValueResolution c;
	protected CommandMouseListener listener;
	protected boolean contains;


	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
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
		
        listener = new CommandMouseListener();
       // cp.addMouseListener(new VariableValueAssignmentDropDownListener(cp, c, view, vmMap));
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        cp.addMouseListener(listener);
        
		String name = c.getName();
		String value = PrimitiveTypeFacade.getInstance().getValueAsString(c);

        cp.setTitle(name + " = " + value);
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
