package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.loader.Main;
import cvl.VSpec;

public class RemoveChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;

	public RemoveChoiceEvent(JComponent p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VSpec parent = null;
		for(VSpec c : vmMap.values()){
			if(c.getChild().contains(v))
				parent = c;
		}
		parent.getChild().remove(v);
		
		// Regenerate view
		Main.notifyViewUpdate();
	}
}
