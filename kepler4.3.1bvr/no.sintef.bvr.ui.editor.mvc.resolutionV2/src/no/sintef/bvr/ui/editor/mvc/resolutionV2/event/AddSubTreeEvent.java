package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddMissingResolutions;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.CloneRes;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VariableValueAssignment;

public class AddSubTreeEvent implements ActionListener {

	private VSpecResolution parent;
	private VSpec target;
	private BVRViewV2  view;

	public AddSubTreeEvent(VSpecResolution parent, BVRViewV2  view) {
		super();
		this.parent = parent;
		this.target = parent.getResolvedVSpec();
		this.view = view;
	}


	public void actionPerformed(ActionEvent e) {
		VSpecResolution grandParent = getParent(this.view.getCU(), parent);

		if (grandParent != null) {
			VSpecResolution root = create();
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof ChoiceResolutuion) {
				Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), grandParent, (ChoiceResolutuion) root);

			} else if (parent instanceof VariableValueAssignment) {
				Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(grandParent, (VariableValueAssignment) root);

			} else if (parent instanceof VInstance) {
				Context.eINSTANCE.getEditorCommands().addVInstance(grandParent, (VInstance) root);
			}

		}

	}

	private VSpecResolution getParent(ConfigurableUnit cu, VSpecResolution child) {
		for (VSpecResolution c : cu.getOwnedVSpecResolution())
			if (c == child) {
				VSpecResolution root = create();

				Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(view.getCU(), child);
				Context.eINSTANCE.getEditorCommands().createNewResolution((ChoiceResolutuion) root, view.getCU());
				Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), root, (ChoiceResolutuion) root);

				return null;
			}
		for (VSpecResolution r : cu.getOwnedVSpecResolution()) {
			VSpecResolution found = getParent(r, child);
			if (found != null)
				return found;
		}
		return null;
	}

	private VSpecResolution getParent(VSpecResolution root, VSpecResolution child) {
		for (VSpecResolution r : root.getChild())
			if (r == child)
				return root;
		for (VSpecResolution r : root.getChild()) {
			VSpecResolution found = getParent(r, child);
			if (found != null)
				return found;
		}
		return null;
	}

	VSpecResolution create() {
		VSpecResolution root = null;
		if (parent instanceof ChoiceResolutuion) {
			root = BvrFactory.eINSTANCE.createChoiceResolutuion();

		} else if (parent instanceof VariableValueAssignment) {
			root = BvrFactory.eINSTANCE.createVariableValueAssignment();

		} else if (parent instanceof VInstance) {
			root = BvrFactory.eINSTANCE.createVInstance();
		}
		CloneRes.getInstance().cloneItStart(root, parent, view);
		Iterators.getInstance().iterateEmptyOnChildren(view, new AddMissingResolutions(), target, root, false);
		return root;
	}
	
	
}
