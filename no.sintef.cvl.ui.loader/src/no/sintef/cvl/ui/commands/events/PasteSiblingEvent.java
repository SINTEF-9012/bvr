package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.VSpec;

public class PasteSiblingEvent implements ActionListener {

	private ChoicePanel p;
	private Map<JComponent, VSpec> vmMap;

	public PasteSiblingEvent(ChoicePanel cp, Map<JComponent, VSpec> vmMap) {
		this.p = cp;
		this.vmMap = vmMap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Find parent
		VSpec parent = null;
		for(VSpec c : vmMap.values()){
			if(c.getChild().contains(v))
				parent = c;
		}
		
		// Modify model
		if(Main.vSpecCut != null){
			EList<VSpec> x = parent.getChild();
			int i = x.indexOf(v);
			x.add(i+1, Main.vSpecCut);
			//parent.getChild().add(Main.vSpecCut);
			Main.vSpecCut = null;
		}
		
		// Regenerate view
		Main.notifyViewUpdate();
	}

}
