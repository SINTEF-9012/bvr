package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.BvrFactory;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddChoiceResolvedEvent implements ActionListener {
	private VSpecResolution cr;
	private Choice target;
	private BVRView view;
	
	public AddChoiceResolvedEvent(VSpecResolution a, Choice b, BVRView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Choice c = target;
		
		ChoiceResolutuion ncr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		ncr.setResolvedVSpec(c);
		cr.getChild().add(ncr);
		
		view.notifyResolutionViewUpdate();
	}

}
