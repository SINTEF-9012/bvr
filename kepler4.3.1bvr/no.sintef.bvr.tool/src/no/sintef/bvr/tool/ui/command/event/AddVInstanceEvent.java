package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.BvrFactory;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddVInstanceEvent implements ActionListener {
	private VSpecResolution cr;
	private VClassifier target;
	private BVRView view;
	
	public AddVInstanceEvent(VSpecResolution parent, VClassifier toResolve, BVRView view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}
	
	static int count = 0;

	public void actionPerformed(ActionEvent arg0) {
		VClassifier v = target;
		
		VInstance vi = BvrFactory.eINSTANCE.createVInstance();
		vi.setResolvedVSpec(v);
		count++;
		vi.setName("vInstance" + count);
		cr.getChild().add(vi);
		
		view.notifyResolutionViewUpdate();
	}

}
