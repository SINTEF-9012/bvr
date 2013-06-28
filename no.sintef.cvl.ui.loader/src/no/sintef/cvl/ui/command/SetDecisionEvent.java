package no.sintef.cvl.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.VSpec;
import cvl.VSpecResolution;

public class SetDecisionEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private CVLView view;
	private boolean newdecision;
	
	public SetDecisionEvent(ChoiceResolutuion a, CVLView view, boolean newdecision) {
		cr = a;
		this.newdecision = newdecision;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		cr.setDecision(newdecision);
		
		view.notifyResolutionViewUpdate();
	}

}
