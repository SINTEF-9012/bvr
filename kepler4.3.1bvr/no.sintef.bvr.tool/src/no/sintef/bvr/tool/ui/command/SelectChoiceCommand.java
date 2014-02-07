package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.Choice;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.BvrFactory;

import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;


public class SelectChoiceCommand implements Command {

	private BVRUIKernel rootPanel;
	private ChoicePanel p;
	private JComponent parent;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.rootPanel = rootPanel;
		this.p = (ChoicePanel)p;
		this.parent = parent;
		this.vmMap = vmMap;
		
		this.view = view;
		
		return null;
	}
	
	static int x = 1;

	public JComponent execute() {
		VSpec v = (VSpec)vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
		x++;
		v.getChild().add(c);
		
		// Regenerate view
		view.notifyVspecViewUpdate();
		
		return null;
	}

}
