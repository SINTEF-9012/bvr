package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddMissingResolutions;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.CloneRes;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Inheritance;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.Choice;
//import bvr.ChoiceResolutuion;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
//import bvr.VariableValueAssignment;

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
		/*VSpecResolution grandParent = Iterators.getInstance().getParent(this.view.getCU(), parent);

		if (grandParent == null) {
			for (VSpecResolution c : this.view.getCU().getOwnedVSpecResolution())
				if (c == parent) {
					VSpecResolution root = create();
					Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(view.getCU(), parent);
					Context.eINSTANCE.getEditorCommands().createNewResolution((ChoiceResolutuion) root, view.getCU());
					Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), root, (ChoiceResolutuion) root);
				}
		}
		else{
			VSpecResolution root = create();
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof ChoiceResolutuion) {
				Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), grandParent, (ChoiceResolutuion) root);
				Inheritance.getInstance().passInheritance( (ChoiceResolutuion) root, ((ChoiceResolutuion) root).isDecision());
			} else if (parent instanceof VariableValueAssignment) {
				Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(grandParent, (VariableValueAssignment) root);

			} else if (parent instanceof VInstance) {
				Context.eINSTANCE.getEditorCommands().addVInstance(grandParent, (VInstance) root);
			}
		}
	}

	VSpecResolution create() {
		VSpecResolution root = CloneRes.getResolution().cloneItStart(parent, view);
		Iterators.getInstance().iterateEmptyOnChildren(view, new AddMissingResolutions(), target, root, false);
		return root;*/
	}
	
	
}
