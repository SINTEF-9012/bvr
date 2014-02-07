package no.sintef.cvl.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import cvl.Choice;
import cvl.NamedElement;
import cvl.VSpec;
import cvl.CvlFactory;

import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;


public class SelectChoiceCommand implements Command {

	private CVLUIKernel rootPanel;
	private ChoicePanel p;
	private JComponent parent;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
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
		Choice c = CvlFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
		x++;
		v.getChild().add(c);
		
		// Regenerate view
		view.notifyVspecViewUpdate();
		
		return null;
	}

}
