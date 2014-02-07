package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VSpec;
import bvr.VSpecResolution;

public class SetDecisionEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private BVRView view;
	private boolean newdecision;
	
	public SetDecisionEvent(ChoiceResolutuion a, BVRView view, boolean newdecision) {
		cr = a;
		this.newdecision = newdecision;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		cr.setDecision(newdecision);
		
		view.notifyResolutionViewUpdate();
	}

}
