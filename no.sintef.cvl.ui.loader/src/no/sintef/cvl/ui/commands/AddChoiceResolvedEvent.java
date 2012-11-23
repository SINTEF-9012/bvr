package no.sintef.cvl.ui.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.cvlFactory;

public class AddChoiceResolvedEvent implements ActionListener {
	private ChoiceResolutuion cr;
	private VSpec target;
	private CVLView view;
	
	public AddChoiceResolvedEvent(ChoiceResolutuion a, VSpec b, CVLView view) {
		cr = a;
		target = b;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		if(target instanceof Choice){
			Choice c = (Choice) target;
			
			ChoiceResolutuion ncr = cvlFactory.eINSTANCE.createChoiceResolutuion();
			ncr.setResolvedChoice(c);
			ncr.setResolvedVSpec(c);
			cr.getChild().add(ncr);
		}else if(target instanceof VClassifier){
			VClassifier v = (VClassifier) target;
			
			VInstance vi = cvlFactory.eINSTANCE.createVInstance();
			vi.setResolvedVSpec(v);
			vi.setName("NewVClassifier");
			vi.getChild().add(vi);
		}
		
		view.notifyResolutionViewUpdate();
	}

}
