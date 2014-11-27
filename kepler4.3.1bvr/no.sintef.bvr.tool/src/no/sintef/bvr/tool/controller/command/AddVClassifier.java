package no.sintef.bvr.tool.controller.command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.tool.ui.dropdown.ClassifierDropDownListener;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VType;
import bvr.Variable;

public class AddVClassifier<EDITOR_PANEL, MODEL_PANEL> implements Command<EDITOR_PANEL, MODEL_PANEL> {
	
	BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel;
	VClassifier vc;
	JComponent parent;
	
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;
	private boolean minimized;
	
	public AddVClassifier(boolean minimized) {
		this.minimized = minimized;
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		if(p instanceof VClassifier){
			this.rootPanel = rootPanel;
			this.vc = (VClassifier) p;
			this.parent = parent;
		}
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
		
		return this;
	}
	
	public JComponent execute() {
		VClassifierPanel c = new VClassifierPanel();
		nodes.add(c);
		vmMap.put(c, vc);
		Helper.bind(parent, c, (BVRModelPanel) rootPanel.getModelPanel(), (parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY, bindings);
		
		CommandMouseListener listener = new CommandMouseListener();
        c.addMouseListener(new ClassifierDropDownListener(c, vmMap, nodes, bindings, controller));
        c.addMouseListener(listener);
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c, parent, vmMap, nodes, bindings, controller);
        listener.setLeftClickCommand(command);
		
        MultiplicityInterval m = vc.getInstanceMultiplicity();
        int l = m.getLower();
        int u = m.getUpper();
        c.setNameAndCardinality((minimized?"(+) ":"") + vc.getName(), l, u);
        
        for(Variable v : ((VNode) vc).getVariable()){
        	if(v.getType() instanceof PrimitveType)
        		c.addAttribute(v.getName(), ((PrimitveType)v.getType()).getType().getName());
        	else
        		c.addAttribute(v.getName(), v.getType().getName());
        }

        for(VNode vNode : vc.getMember()) {
        	if(vNode instanceof VType) {
        		VType vType = (VType) vNode;
        		JLabel label = c.addAttribute(vType.getName() + " : VType");
        		label.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent e) {
        				controller.getVSpecControllerInterface().editVType(vNode, vType);
        			}
				});
        	}
        }
        
        ((BVRModelPanel) rootPanel.getModelPanel()).addNode(c);
        return c;
	}

}
