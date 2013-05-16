package no.sintef.cvl.ui.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.VSpec;
import cvl.VSpecResolution;

public class ChangeVSpecResolvedEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private Choice target;
	private CVLView view;
	
	public ChangeVSpecResolvedEvent(ChoiceResolutuion a, Choice b, CVLView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		cr.setResolvedVSpec(target);
		
		view.notifyResolutionViewUpdate();
	}

}
