package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class SetDecisionEvent implements ActionListener {
	private ChoiceResolution cr;
	private BVRNotifiableController view;
	private boolean newdecision;
	
	public SetDecisionEvent(ChoiceResolution a, BVRNotifiableController view, boolean newdecision) {
		cr = a;
		this.newdecision = newdecision;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		//cr.setDecision(newdecision);
		//Context.eINSTANCE.getEditorCommands().setResolutionDecision(cr, newdecision);
		
		//view.notifyResolutionViewUpdate();
	}

}
