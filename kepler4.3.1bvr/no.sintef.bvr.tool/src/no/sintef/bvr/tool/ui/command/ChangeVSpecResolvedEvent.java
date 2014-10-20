package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ChangeVSpecResolvedEvent implements ActionListener {
	private ChoiceResolution cr;
	private Choice target;
	private BVRNotifiableController view;
	
	public ChangeVSpecResolvedEvent(ChoiceResolution a, Choice b, BVRNotifiableController view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		//cr.setResolvedVSpec(target);
		//Context.eINSTANCE.getEditorCommands().setChoiceResolvedVSpec(cr, target);
		
		//view.notifyResolutionViewUpdate();
	}

}
