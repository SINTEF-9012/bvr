package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.CVLView;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.CvlFactory;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;

public class AddVInstanceEvent implements ActionListener {
	private VSpecResolution cr;
	private VClassifier target;
	private CVLView view;
	
	public AddVInstanceEvent(VSpecResolution parent, VClassifier toResolve, CVLView view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}
	
	static int count = 0;

	public void actionPerformed(ActionEvent arg0) {
		VClassifier v = target;
		
		VInstance vi = CvlFactory.eINSTANCE.createVInstance();
		vi.setResolvedVSpec(v);
		count++;
		vi.setName("vInstance" + count);
		cr.getChild().add(vi);
		
		view.notifyResolutionViewUpdate();
	}

}
