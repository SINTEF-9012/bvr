package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.CloneRes;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
//import bvr.ChoiceResolutuion;
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
/*

		// System.out.println(parent);
		VSpecResolution grandParent = Iterators.getInstance().getParent(this.view.getCU(), parent);

		if (grandParent == null) {
			for (VSpecResolution c : this.view.getCU().getOwnedVSpecResolution())
				if (c == parent) {
					VSpecResolution root = create();
					Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(view.getCU(), parent);
					Context.eINSTANCE.getEditorCommands().createNewResolution((ChoiceResolutuion) root, view.getCU());
					Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), root, (ChoiceResolutuion) root);
				}
		} else {

			VSpecResolution root = create();
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof ChoiceResolutuion) {
				Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), grandParent, (ChoiceResolutuion) root);

			} else if (parent instanceof VariableValueAssignment) {
				Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(grandParent, (VariableValueAssignment) root);
				;

			} else if (parent instanceof VInstance) {
				Context.eINSTANCE.getEditorCommands().addVInstance(grandParent, (VInstance) root);
			}
			/*
			 * } while(currentInstances < instancesRequested){ new AddVInstanceTreeEvent( parent, target, view).actionPerformed(e);
			 * currentInstances++; }
			 */
		//}
	}


	VSpecResolution create() {
		VSpecResolution root = CloneRes.getResolution().cloneItStart(parent, view);

		for (int i = 0; i < instancesRequested; i++) {
			/*VInstance newInstance = BvrFactory.eINSTANCE.createVInstance();
			newInstance.setResolvedVSpec(target);
			newInstance.setName("I" + view.getIncrementedNameCounter());
			Iterators.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, newInstance, false);
			root.getChild().add(newInstance);
			*/
		}
		return root;
	}

}
