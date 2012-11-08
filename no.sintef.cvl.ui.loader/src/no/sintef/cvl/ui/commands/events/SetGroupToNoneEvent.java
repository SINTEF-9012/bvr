package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;
import cvl.MultiplicityInterval;
import cvl.VSpec;
import cvl.cvlFactory;

public class SetGroupToNoneEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;

	public SetGroupToNoneEvent(JComponent p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = vmMap.get(p);
		
		// Modify model
		v.setGroupMultiplicity(null);
		
		// Regenerate view
		Main.notifyViewUpdate();
	}
}
