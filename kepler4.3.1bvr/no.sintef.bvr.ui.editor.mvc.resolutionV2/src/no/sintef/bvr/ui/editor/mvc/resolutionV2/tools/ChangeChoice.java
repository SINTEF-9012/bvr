package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
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
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
				newRes.setResolvedChoice(c.getResolvedChoice());
				newRes.setName(c.getName());
				VSpecResolution parentResolution = Iterators.getInstance().getParent(view.getBVRModel(), c);
				Context.eINSTANCE.getEditorCommands().addNegChoiceResoulution((Choice) parentResolution.getResolvedVSpec(), parentResolution,
						(NegResolution) newRes);
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);// TODO Check
			}
		} else if (c instanceof NegResolution) {
			if (!bool) {
				return;
			} else {
				VSpecResolution parentResolution = Iterators.getInstance().getParent(view.getBVRModel(), c);
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
				newRes.setResolvedChoice(c.getResolvedChoice());
				newRes.setName(c.getName());
				Iterators.getInstance().iterateEmptyOnChildren(view, new AddResolution(), parentResolution.getResolvedVSpec(), newRes, false);
				Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution(
						(Choice) Iterators.getInstance().getParent(view.getBVRModel(), c).getResolvedVSpec(), c, (PosResolution) newRes);
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
			}
		}

	}
}
