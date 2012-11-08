package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.VSpec;

public class PasteChildEvent implements ActionListener {

	private ChoicePanel p;
	private Map<JComponent, VSpec> vmMap;

	public PasteChildEvent(ChoicePanel cp, Map<JComponent, VSpec> vmMap) {
		this.p = cp;
		this.vmMap = vmMap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		if(Main.vSpecCut != null){
			v.getChild().add(Main.vSpecCut);
			Main.vSpecCut = null;
		}
		
		// Regenerate view
		Main.notifyViewUpdate();
	}

}
