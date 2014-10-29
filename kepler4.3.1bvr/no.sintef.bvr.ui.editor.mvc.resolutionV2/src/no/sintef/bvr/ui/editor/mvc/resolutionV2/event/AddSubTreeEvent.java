package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.model.CloneResFacade;
import no.sintef.bvr.tool.model.InheritanceFacade;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddMissingResolutions;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NegResolution;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
//import bvr.VariableValueAssignment;

public class AddSubTreeEvent implements ActionListener {

	private VSpecResolution parent;
	private VSpec target;
	private BVRResolutionToolView  view;

	public AddSubTreeEvent(VSpecResolution parent, BVRResolutionToolView  view) {
		super();
		this.parent = parent;
		this.target = parent.getResolvedVSpec();
		this.view = view;
	}


	public void actionPerformed(ActionEvent e) {
		VSpecResolution grandParent = ResolutionModelIterator.getInstance().getParent(this.view.getBVRModel(), parent);

		if (grandParent == null) {
			for (VSpecResolution c : this.view.getBVRModel().getResolutionModels())
				if (c == parent) {
					VSpecResolution root = create();
					Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolution(view.getBVRModel(), parent);
					Context.eINSTANCE.getEditorCommands().createNewResolution((PosResolution) root, view.getBVRModel());
					Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution(root, (PosResolution) root);
				}
		}
		else{
			VSpecResolution root = create();
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof PosResolution) {
				Context.eINSTANCE.getEditorCommands().addPosChoiceResoulution( grandParent, (PosResolution) root);
				InheritanceFacade.getInstance().passInheritance((ChoiceResolution)root, (root instanceof PosResolution), view);
			}
			else if(parent instanceof NegResolution){
				Context.eINSTANCE.getEditorCommands().addNegChoiceResoulution(grandParent, (NegResolution) root);
				InheritanceFacade.getInstance().passInheritance((ChoiceResolution)root, (root instanceof PosResolution), view);
			}/* else if (parent instanceof VariableValueAssignment) {
			}
				Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(grandParent, (VariableValueAssignment) root);

			} else if (parent instanceof VInstance) {
				Context.eINSTANCE.getEditorCommands().addVInstance(grandParent, (VInstance) root);
			}*/
		}
	}

	VSpecResolution create() {
		VSpecResolution root = CloneResFacade.getResolution().cloneItStart(parent, view);
		ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddMissingResolutions(), target, root, false);
		return root;
	}
	
	
}
