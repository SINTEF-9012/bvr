package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VSpec;
import bvr.VSpecResolution;

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
