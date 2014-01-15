package no.sintef.cvl.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.VSpecView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.VSpec;
import cvl.VSpecResolution;

public class SetDecisionEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private VSpecView view;
	private boolean newdecision;
	
	public SetDecisionEvent(ChoiceResolutuion a, VSpecView view, boolean newdecision) {
		cr = a;
		this.newdecision = newdecision;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		cr.setDecision(newdecision);
		
		view.notifyResolutionViewUpdate();
	}

}
