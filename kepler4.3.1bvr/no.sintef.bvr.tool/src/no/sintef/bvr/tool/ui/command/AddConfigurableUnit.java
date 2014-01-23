package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.ConfigurableUnitDropDownListener;
import no.sintef.bvr.tool.ui.editor.CVLUIKernel;
import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitSymbolPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VSpec;

public class AddConfigurableUnit {

	private CVLUIKernel rootPanel;
	private ConfigurableUnit cu;
	private CommandMouseListener listener;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;

	public AddConfigurableUnit init(ConfigurableUnit cu, CVLUIKernel rootPanel, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.rootPanel = rootPanel;
		this.cu = cu;
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
        cp.addMouseListener(new ConfigurableUnitDropDownListener(cp, vmMap, nodes, bindings, view));
        cp.addMouseListener(listener);
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, null, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
		
        String name = cu.getName();
        if(name == null) name = "(unnamed)";
        cp.setTitle(name);
        rootPanel.getModelPanel().addNode(cp);
        //Helper.bind(parent, cp, rootPanel.getModelPanel(), (c.isIsImpliedByParent() || parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
