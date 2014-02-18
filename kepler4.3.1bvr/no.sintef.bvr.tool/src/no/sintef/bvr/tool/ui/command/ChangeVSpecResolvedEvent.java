package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ChangeVSpecResolvedEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private Choice target;
	private BVRView view;
	
	public ChangeVSpecResolvedEvent(ChoiceResolutuion a, Choice b, BVRView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		//cr.setResolvedVSpec(target);
		Context.eINSTANCE.getEditorCommands().setChoiceResolvedVSpec(cr, target);
		
		view.notifyResolutionViewUpdate();
	}

}
