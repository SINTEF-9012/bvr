package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.CvlFactory;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;

public class AddChoiceResolvedEvent implements ActionListener {
	private VSpecResolution cr;
	private Choice target;
	private CVLView view;
	
	public AddChoiceResolvedEvent(VSpecResolution a, Choice b, CVLView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Choice c = target;
		
		ChoiceResolutuion ncr = CvlFactory.eINSTANCE.createChoiceResolutuion();
		ncr.setResolvedChoice(c);
		ncr.setResolvedVSpec(c);
		cr.getChild().add(ncr);
		
		view.notifyResolutionViewUpdate();
	}

}
