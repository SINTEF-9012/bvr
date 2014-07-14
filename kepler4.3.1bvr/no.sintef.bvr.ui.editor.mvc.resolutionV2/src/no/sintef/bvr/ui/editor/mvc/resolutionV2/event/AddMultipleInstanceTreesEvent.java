package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.edit.VariableValueAssignmentPropertyEditor;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VariableValueAssignment;

public class AddMultipleInstanceTreesEvent implements ActionListener {
	int currentInstances;
	int instancesRequested;
	VSpecResolution parent;
	VSpec target;
	BVRView view;

	// parent er choice o.l. over
	public AddMultipleInstanceTreesEvent(int instancesRequested, VSpecResolution parent, VSpec target, BVRView view) {
		super();
		this.instancesRequested = instancesRequested;
		this.currentInstances = 0;
		this.parent = parent;
		this.target = target;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (currentInstances < 0) {
			return;
		}
		for (VSpecResolution x : parent.getChild()) {
			if (x instanceof VInstance) {
				if (x.getResolvedVSpec() == target) {
					currentInstances++;
				}
			}
		}
		//System.out.println(parent);
		VSpecResolution grandParent = getParent(this.view.getCU(), parent);
		/*
		 * if (grandParent == null){ System.err.println("error in addmultipleVInstances"); return; }
		 */
		// TODO insert check and stuff for multiple types.
		ChoiceResolutuion root = BvrFactory.eINSTANCE.createChoiceResolutuion();
		// populate top choice

		cloneRes(root, parent);
		while (currentInstances <= instancesRequested) {
			new Iterators().iterateEmptyOnChildren(view, new AddResolution(), parent.getResolvedVSpec(), root, false);
			currentInstances++;
		}
		

		Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
		Context.eINSTANCE.getEditorCommands().addChoiceResolved((Choice) root.getResolvedVSpec(), grandParent, root);
		/*
		 * } while(currentInstances < instancesRequested){ new AddVInstanceTreeEvent( parent, target, view).actionPerformed(e); currentInstances++; }
		 */
	}

	private VSpecResolution getParent(ConfigurableUnit cu, VSpecResolution child) {
		for (VSpecResolution c : cu.getOwnedVSpecResolution())
			if (c == child) {
				// TODO
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

	private void cloneRes(VSpecResolution copyTo, VSpecResolution copyFrom) {

		if (copyFrom instanceof ChoiceResolutuion) {
			((ChoiceResolutuion) copyTo).setDecision(((ChoiceResolutuion) copyFrom).isDecision());
			
		} else if (copyFrom instanceof VariableValueAssignment) {
			((VariableValueAssignment) copyTo).setValue(((VariableValueAssignment) copyFrom).getValue());
			
		} else if (copyFrom instanceof VInstance) {
			copyTo = BvrFactory.eINSTANCE.createVInstance();
		}
		copyTo.setResolvedVSpec(copyFrom.getResolvedVSpec());
		copyTo.setName(copyFrom.getName());
	}
}
