package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.model.CloneResFacade;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
//import bvr.ChoiceResolution;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

//import bvr.VariableValueAssignment;

public class AddMultipleInstanceTreesEvent implements ActionListener {
	int currentInstances;
	int instancesRequested;
	VSpecResolution parent;
	VSpec target;
	BVRResolutionToolView view;

	public AddMultipleInstanceTreesEvent(int instancesRequested, VSpecResolution parent, VSpec target, BVRResolutionToolView view) {
		super();
		this.instancesRequested = instancesRequested;
		this.parent = parent;
		this.target = target;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {

		// System.out.println(parent);
		VSpecResolution grandParent = ResolutionModelIterator.getInstance().getParent(this.view.getBVRModel(), parent);

		if (grandParent == null) {
			for (VSpecResolution c : this.view.getBVRModel().getResolutionModels())
				if (c == parent) {
					VSpecResolution root = create();
					Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolution(view.getBVRModel(), parent);
					Context.eINSTANCE.getEditorCommands().createNewResolution((PosResolution) root, view.getBVRModel());
					Context.eINSTANCE.getEditorCommands().addChoiceResoulution(root, (PosResolution) root);
				}
		} else {

			VSpecResolution root = create();
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof ChoiceResolution) {
				Context.eINSTANCE.getEditorCommands().addChoiceResoulution(grandParent, (PosResolution) root);

			} /*
			 * else if (parent instanceof VariableValueAssignment) { Context.eINSTANCE .getEditorCommands().addVariableValueAssignment(grandParent,
			 * (VariableValueAssignment) root); ;
			 * 
			 * }
			 *//*
				 * else if (parent instanceof VInstance) { Context.eINSTANCE.getEditorCommands ().addVInstance(grandParent, (VInstance) root); }
				 */
			/*
			 * } while(currentInstances < instancesRequested){ new AddVInstanceTreeEvent( parent, target, view).actionPerformed(e);
			 * currentInstances++; }
			 */
		}
	}

	VSpecResolution create() {
		VSpecResolution root = CloneResFacade.getResolution().cloneItStart(parent, view);

		for (int i = 0; i < instancesRequested; i++) {
			PosResolution newInstance = BvrFactory.eINSTANCE.createPosResolution();
			CommonUtility.setResolved(newInstance, target);
			newInstance.setName("I" + view.getIncrementedNameCounter());
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, newInstance, false);
			((CompoundResolution) root).getMembers().add(newInstance);

		}
		return root;
	}

}
