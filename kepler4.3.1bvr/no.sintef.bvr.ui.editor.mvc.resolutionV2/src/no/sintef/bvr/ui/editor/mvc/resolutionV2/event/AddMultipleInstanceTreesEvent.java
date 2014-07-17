package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.AddResolution;
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


	public void actionPerformed(ActionEvent e) {

		if (currentInstances < 0) {
			System.err.println("error current VInsgtance count <0");
			return;
		}
		for (VSpecResolution x : parent.getChild()) {
			if (x.getResolvedVSpec() == target) {
				if (x.getResolvedVSpec() == target) {
					currentInstances++;
				}
			}
		}


		// System.out.println(parent);
		VSpecResolution grandParent = getParent(this.view.getCU(), parent);
		
		if (grandParent != null) {
			
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
		}
	}

	private VSpecResolution getParent(ConfigurableUnit cu, VSpecResolution child) {
		for (VSpecResolution c : cu.getOwnedVSpecResolution())
			if (c == child) {
				VSpecResolution root =create();
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


	VSpecResolution create(){
		VSpecResolution root = null;
		if (parent instanceof ChoiceResolutuion) {
			root = BvrFactory.eINSTANCE.createChoiceResolutuion();

		} else if (parent instanceof VariableValueAssignment) {
			root = BvrFactory.eINSTANCE.createVariableValueAssignment();

		} else if (parent instanceof VInstance) {
			root = BvrFactory.eINSTANCE.createVInstance();
		}
		// populate top choice

		CloneRes.getInstance().cloneItStart(root, parent, view);

		for (int i = 0; i <instancesRequested; i++) {
			VInstance newInstance = BvrFactory.eINSTANCE.createVInstance();
			newInstance.setResolvedVSpec(target);
			newInstance.setName(target.getName());
			Iterators.getInstance().iterateEmptyOnChildren(view, new AddResolution(), target, newInstance, false);
			root.getChild().add(newInstance);
			i++;
		}
		return root;
	}


}
