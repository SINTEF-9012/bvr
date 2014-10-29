package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.ResolutionRootController;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
//import bvr.ChoiceResolution;
import bvr.VSpecResolution;

public class Inheritance {
	private static Inheritance instance = null;

	private Inheritance() {

	}

	public static synchronized Inheritance getInstance() {
		if (instance == null) {
			instance = new Inheritance();
		}
		return instance;
	}

	public void passInheritance(ChoiceResolution c, boolean nBool, BVRResolutionToolView view) {
		if(c instanceof NegResolution)return;
		for (VSpecResolution x : ((CompoundResolution) c).getMembers()) {
			if (x instanceof ChoiceResolution) {
				if (((ChoiceResolution) x).getResolvedVSpec() instanceof Choice) {
					if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
						ChangeChoice.setChoiceResolution(c, nBool, view);
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
