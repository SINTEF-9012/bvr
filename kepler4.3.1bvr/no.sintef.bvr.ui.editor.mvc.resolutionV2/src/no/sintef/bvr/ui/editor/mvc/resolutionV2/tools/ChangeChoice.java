package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;


import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddSubTreeEvent;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NegResolution;
import bvr.PosResolution;


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

	public static void setType(ChoiceResolution c, boolean bool, BVRResolutionToolView view) {
		if(c instanceof PosResolution){
			if(bool){
				return;
			}
			else{
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
				newRes.setResolvedChoice(c.getResolvedChoice());
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(c, c.getResolvedChoice());//TODO Check
				Context.eINSTANCE.getEditorCommands().addNegChoiceResoulution((Choice) Iterators.getInstance().getParent(view.getBVRModel(), c).getResolvedVSpec(), c, (NegResolution)newRes);
			}
		}
		else if(c instanceof NegResolution){
			if(!bool){
				return;
			}
			else{
				ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
				newRes.setResolvedChoice(c.getResolvedChoice()); //TODO transactional error`?
				Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(c, c.getResolvedChoice());
				AddSubTreeEvent addSubTreeEvent = new AddSubTreeEvent(newRes, view);
				addSubTreeEvent.actionPerformed(null);
				Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution((Choice) Iterators.getInstance().getParent(view.getBVRModel(), c).getResolvedVSpec(), c, (PosResolution)newRes);
			}
		}
		
	}
}
