package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import cvl.Choice;
import cvl.MultiplicityInterval;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.cvlFactory;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;


public class AddClassifierEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;

	public AddClassifierEvent(JComponent p, Map<JComponent, VSpec> vmMap) {
		this.p = p;
		this.vmMap = vmMap;
	}
	
	static int x = 1;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VClassifier c = cvlFactory.eINSTANCE.createVClassifier();
		c.setName("Classifier"+x);
		MultiplicityInterval mi = cvlFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);
		x++;
		v.getChild().add(c);
		
		// Regenerate view
		Main.notifyViewUpdate();
	}

}
