package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;
import cvl.VSpec;

public class CutEvent implements ActionListener {

	private Map<JComponent, VSpec> vmMap;
	private ChoicePanel p;

	public CutEvent(ChoicePanel cp, Map<JComponent, VSpec> vmMap) {
		this.p = cp;
		this.vmMap = vmMap;
	}

	@Override
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
		
		// Save cut
		Main.vSpecCut = v;
		
		// Regenerate view
		Main.notifyViewUpdate();
	}

}
