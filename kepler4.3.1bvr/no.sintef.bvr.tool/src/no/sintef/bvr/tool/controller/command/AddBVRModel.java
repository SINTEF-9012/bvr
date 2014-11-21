package no.sintef.bvr.tool.controller.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.dropdown.BVRModelDropDownListener;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelSymbolPanel;
import bvr.BVRModel;
import bvr.NamedElement;


public class AddBVRModel<EDITOR_PANEL extends BVREditorPanel, MODEL_PANEL extends BVRModelPanel>
		implements Command<EDITOR_PANEL, MODEL_PANEL> {

	private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	private BVRModel model;
	private CommandMouseListener listener;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;

	@Override
	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object model, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.rootPanel = rootPanel;
		this.model = (BVRModel) model;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		return this;
	}

	@Override
	public JComponent execute() {
		BVRModelSymbolPanel cp = new BVRModelSymbolPanel((BVRModelPanel) rootPanel.getModelPanel());
		nodes.add(cp);
		vmMap.put(cp, model);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new BVRModelDropDownListener(cp, vmMap, nodes, bindings, view));
        cp.addMouseListener(listener);
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, null, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
		
        String name = model.getName();
        if(name == null) name = "(unnamed)";
        cp.setTitle(name);
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(cp);
        return cp;
	}
}
