package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import bvr.Choice;
//import bvr.ChoiceResolutuion;
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

/*	public void passInheritance(ChoiceResolutuion c, boolean nBool) {
		for (VSpecResolution x : c.getChild()) {
			if (x instanceof ChoiceResolutuion) {
				if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
					Context.eINSTANCE
							.getEditorCommands()
							.setResolutionDecision((ChoiceResolutuion) x, nBool);
					passInheritance((ChoiceResolutuion) x, nBool);
				}
			}
		}
	}*/
}
