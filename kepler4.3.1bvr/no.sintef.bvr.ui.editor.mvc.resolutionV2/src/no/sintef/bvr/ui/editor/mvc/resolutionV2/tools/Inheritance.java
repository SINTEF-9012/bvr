package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.ResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
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
		for (VSpecResolution x : ((CompoundResolution) c).getMembers()) {
			if (x instanceof ChoiceResolution) {
				if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
					ChangeChoice.setType(c, nBool, view);
					passInheritance((ChoiceResolution) x, nBool, view);
				}
			}
		}
	}

	
		// TODO Auto-generated method stub
		
	
}
