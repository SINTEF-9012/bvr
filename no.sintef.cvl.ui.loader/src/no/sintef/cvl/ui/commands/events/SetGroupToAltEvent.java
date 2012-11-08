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

public class SetGroupToAltEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;

	public SetGroupToAltEvent(JComponent p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = vmMap.get(p);
		
		// Modify model
		MultiplicityInterval mi = cvlFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		v.setGroupMultiplicity(mi);
		
		// Regenerate view
		Main.notifyViewUpdate();
	}
}
