package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddSubTreeEvent;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ChangeChoice {
	private static ChangeChoice instance = null;

	private ChangeChoice() {

	}

	public static synchronized ChangeChoice getInstance() {
		if (instance == null) {
			instance = new ChangeChoice();
		}
		return instance;
	}

	public static void setChoiceResolution(ChoiceResolution c, boolean bool, BVRResolutionToolView view) {
		if (c instanceof PosResolution) {
			if (bool) {
				return;
			} else {
				//System.out.println(">>>>>>>>>>>>>>>>>>STARTING POSTONEG CHANGE<<<<<<<<<<<<<<<<<<<<<<<");
				VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(view.getBVRModel(), c);
					if(parentResolution == null)return; //is root or c is not in model
				
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
				CommonUtility.setResolved(newRes, c.getResolvedChoice());
				newRes.setName(c.getName());
				//System.out.println("created newRes:" +newRes);
				//System.out.println("Parent is " + parentResolution);
				Context.eINSTANCE.getEditorCommands().addNegChoiceResoulution(parentResolution,	(NegResolution) newRes);
				//System.out.println("added newRes");
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);// TODO Check
				//System.out.println("removed c");
				//System.out.println("newRes after remove: " +newRes);
			}
		} else if (c instanceof NegResolution) {
			if (!bool) {
				return;
			} else {
				
				//System.out.println(">>>>>>>>>>>>>>>>>>STARTING NEGTOPOS CHANGE<<<<<<<<<<<<<<<<<<<<<<<");
				VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(view.getBVRModel(), c);
				if(parentResolution == null)return; //is root
				//System.out.println("Parent is " + parentResolution);
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
				CommonUtility.setResolved(newRes, c.getResolvedChoice());
				newRes.setName(c.getName());
				//System.out.println("created newRes:" +newRes);
				ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddResolution(), c.getResolvedVSpec(), newRes, false);
				//System.out.println("newRes After iteration");
				Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution(parentResolution, (PosResolution) newRes);
				//System.out.println("added newRes");
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
				//System.out.println("removed c");
			}
		}

	}
}
