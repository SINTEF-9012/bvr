package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import bvr.Choice;
import bvr.BvrFactory;
import bvr.VSpecResolution;

public class AddChoiceResolvedEvent implements ActionListener {
	private VSpecResolution cr;
	private Choice target;
	private BVRNotifiableController view;
	
	public AddChoiceResolvedEvent(VSpecResolution a, Choice b, BVRNotifiableController view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Choice c = target;
		//ChoiceResolutuion ncr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		
		//Context.eINSTANCE.getEditorCommands().addChoiceResolved(target, cr, ncr);
	}

}
