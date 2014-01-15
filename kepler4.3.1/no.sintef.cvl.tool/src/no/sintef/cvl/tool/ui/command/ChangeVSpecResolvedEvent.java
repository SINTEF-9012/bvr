package no.sintef.cvl.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.VSpecView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.VSpec;
import cvl.VSpecResolution;

public class ChangeVSpecResolvedEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private Choice target;
	private VSpecView view;
	
	public ChangeVSpecResolvedEvent(ChoiceResolutuion a, Choice b, VSpecView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		cr.setResolvedVSpec(target);
		
		view.notifyResolutionViewUpdate();
	}

}
