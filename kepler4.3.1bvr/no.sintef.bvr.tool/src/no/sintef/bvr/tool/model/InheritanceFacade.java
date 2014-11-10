package no.sintef.bvr.tool.model;


import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.VSpecResolution;

public class InheritanceFacade {
	private static InheritanceFacade instance = null;

	private InheritanceFacade() {

	}

	public static synchronized InheritanceFacade getInstance() {
		if (instance == null) {
			instance = new InheritanceFacade();
		}
		return instance;
	}

	public void passInheritance(ChoiceResolution c, boolean nBool, BVRToolModel view) {
		if(c instanceof NegResolution) return;
		for (VSpecResolution x : ((CompoundResolution) c).getMembers()) {
			if (x instanceof ChoiceResolution) {
				if (((ChoiceResolution) x).getResolvedVSpec() instanceof Choice) {
					if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
						ChangeChoiceFacade.eINSTANCE.setChoiceResolution(c, nBool, view);
						passInheritance((ChoiceResolution) x, nBool, view);
					}
				}
				else{//VClassifier
					passInheritance((ChoiceResolution) x, nBool, view);
				}
			}
		}
	}

	// TODO Auto-generated method stub

}
