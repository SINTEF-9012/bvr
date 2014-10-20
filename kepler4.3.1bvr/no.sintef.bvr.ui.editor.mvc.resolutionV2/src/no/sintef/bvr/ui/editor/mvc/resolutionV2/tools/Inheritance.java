package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import bvr.Choice;
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

/*	public void passInheritance(ChoiceResolution c, boolean nBool) {
		for (VSpecResolution x : c.getChild()) {
			if (x instanceof ChoiceResolution) {
				if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
					Context.eINSTANCE
							.getEditorCommands()
							.setResolutionDecision((ChoiceResolution) x, nBool);
					passInheritance((ChoiceResolution) x, nBool);
				}
			}
		}
	}*/
}
