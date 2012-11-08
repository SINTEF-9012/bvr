package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;
import cvl.VSpec;

public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private Map<JComponent, VSpec> vmMap;

	public ToggleOptionalEvent(ChoicePanel p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Choice v = (Choice)vmMap.get(p);
		
		// Modify model
		v.setIsImpliedByParent(!v.isIsImpliedByParent());
		
		// Regenerate view
		Main.notifyViewUpdate();
	}
}
