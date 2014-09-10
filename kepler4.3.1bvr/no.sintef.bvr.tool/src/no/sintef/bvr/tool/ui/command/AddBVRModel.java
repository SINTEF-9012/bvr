package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.BVRModelDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitSymbolPanel;
import bvr.BVRModel;
import bvr.NamedElement;

public class AddBVRModel {

	private BVRUIKernel rootPanel;
	private BVRModel model;
	private CommandMouseListener listener;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRToolView view;

	public AddBVRModel init(BVRModel model, BVRUIKernel rootPanel, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		this.rootPanel = rootPanel;
		this.model = model;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
	}

	public JComponent execute() {
		ConfigurableUnitSymbolPanel cp = new ConfigurableUnitSymbolPanel(rootPanel.getModelPanel());
		nodes.add(cp);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new BVRModelDropDownListener(cp, vmMap, nodes, bindings, view));
        cp.addMouseListener(listener);
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, null, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
		
        String name = model.getName();
        if(name == null) name = "(unnamed)";
        cp.setTitle(name);
        rootPanel.getModelPanel().addNode(cp);
        return cp;
	}

}
