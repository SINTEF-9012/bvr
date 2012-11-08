package no.sintef.cvl.ui.commands;

import java.util.Map;

import javax.swing.JComponent;

import cvl.Choice;
import cvl.VSpec;
import cvl.cvlFactory;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;


public class SelectChoiceCommand implements Command {

	private CVLUIKernel rootPanel;
	private ChoicePanel p;
	private JComponent parent;
	private Map<JComponent, VSpec> vmMap;

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, VSpec> vmMap) {
		this.rootPanel = rootPanel;
		this.p = (ChoicePanel)p;
		this.parent = parent;
		this.vmMap = vmMap;
		
		return null;
	}
	
	static int x = 1;

	public JComponent execute() {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		Choice c = cvlFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
		x++;
		v.getChild().add(c);
		
		// Regenerate view
		Main.notifyViewUpdate();
		
		return null;
	}

}
