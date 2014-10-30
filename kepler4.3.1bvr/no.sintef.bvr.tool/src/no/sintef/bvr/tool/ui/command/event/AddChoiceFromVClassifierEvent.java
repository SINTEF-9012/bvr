package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import bvr.Choice;
import bvr.BvrFactory;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddChoiceFromVClassifierEvent implements ActionListener {
	private VSpecResolution cr;
	private VClassifier target;
	private BVRNotifiableController view;
	
	public AddChoiceFromVClassifierEvent(VSpecResolution parent, VClassifier toResolve, BVRNotifiableController view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}
	
	static int count = 0;

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("AddMultipleChoicesFromVClassifier running but unimplemented");
		/*VClassifier v = target;
		
		VInstance vi = BvrFactory.eINSTANCE.createVInstance();
		vi.setResolvedVSpec(v);
		count++;
		vi.setName("vInstance" + count);
		
		Context.eINSTANCE.getEditorCommands().addVInstance(cr, vi);*/
	}
}
