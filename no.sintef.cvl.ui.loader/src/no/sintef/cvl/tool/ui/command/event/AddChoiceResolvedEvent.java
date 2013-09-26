package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

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
		ncr.setResolvedVSpec(c);
		cr.getChild().add(ncr);
		
		view.notifyResolutionViewUpdate();
	}

}
