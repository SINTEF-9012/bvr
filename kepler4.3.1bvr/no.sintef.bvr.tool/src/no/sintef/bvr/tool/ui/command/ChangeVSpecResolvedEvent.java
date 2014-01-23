package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VSpec;
import bvr.VSpecResolution;

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
