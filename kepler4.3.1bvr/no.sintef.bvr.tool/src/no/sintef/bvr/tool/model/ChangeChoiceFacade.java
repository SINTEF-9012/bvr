package no.sintef.bvr.tool.model;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.AddResolution;
import bvr.BVRModel;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddSubTreeEvent;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VSpec;
import bvr.VSpecResolution;

public class ChangeChoiceFacade {
	private static ChangeChoiceFacade instance = null;

	private ChangeChoiceFacade() {

	}

	public static synchronized ChangeChoiceFacade getInstance() {
		if (instance == null) {
			instance = new ChangeChoiceFacade();
		}
		return instance;
	}

	public static void setChoiceResolution(ChoiceResolution c, boolean bool, BVRToolModel bvrModel) {

		if (c instanceof PosResolution && !bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return; //is root or c is not in model
				
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
			CommonUtility.setResolved(newRes, c.getResolvedChoice());
			newRes.setName(c.getName());
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (NegResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
		} else if (c instanceof NegResolution && bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return; //is root
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
			CommonUtility.setResolved(newRes, c.getResolvedChoice());
			newRes.setName(c.getName());
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(bvrModel, new AddResolution(), c.getResolvedVSpec(), newRes, false);
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (PosResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
		}

	}
}
