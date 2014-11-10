package no.sintef.bvr.tool.model;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.AddResolution;

import bvr.BvrFactory;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VSpecResolution;

public class ChangeChoiceFacade {
	public static ChangeChoiceFacade eINSTANCE = getInstance();


	private static synchronized ChangeChoiceFacade getInstance() {
		if (eINSTANCE == null) {
			eINSTANCE = new ChangeChoiceFacade();
		}
		return eINSTANCE;
	}

	public ChoiceResolution setChoiceResolution(ChoiceResolution c, boolean bool, BVRToolModel bvrModel) {
		ChoiceResolution created = null;
		if (c instanceof PosResolution && !bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return null; //is root or c is not in model
				
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
			CommonUtility.setResolved(newRes, c.getResolvedChoice());
			newRes.setName(c.getName());
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (NegResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
			created = newRes;
		} else if (c instanceof NegResolution && bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return null; //is root
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
			CommonUtility.setResolved(newRes, c.getResolvedChoice());
			newRes.setName(c.getName());
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(bvrModel, new AddResolution(), c.getResolvedVSpec(), newRes, false);
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (PosResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
			created = newRes;
		}
		return created;
	}
	
	public void replaceChoiceResolution(ChoiceResolution parent, ChoiceResolution oldChild, ChoiceResolution newChild) {
		if(parent == null)
			return; //is root or c is not in model
		
		int index = ((CompoundResolution) parent).getMembers().indexOf(oldChild);
		Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parent, newChild, index);
		Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parent, oldChild);
	}
}
