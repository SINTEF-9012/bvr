package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;
import cvl.VSpec;
import cvl.cvlFactory;


public class AddChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;

	public AddChoiceEvent(JComponent p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	static int x = 1;

	public void actionPerformed(ActionEvent arg0) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		Choice c = cvlFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
		x++;
		v.getChild().add(c);
		
		// Regenerate view
		Main.notifyViewUpdate();
	}

}
