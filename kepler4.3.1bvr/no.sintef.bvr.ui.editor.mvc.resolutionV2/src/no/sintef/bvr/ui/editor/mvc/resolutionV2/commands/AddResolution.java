package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddVariableValueAssignmentEventV2;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;

public class AddResolution implements ResCommand {
	private BVRView view;
	private VSpec target;
	private boolean onlyOneInstance;
	private VSpecResolution parent;

	@Override
	public ResCommand init(BVRView view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.target = vs;
		this.parent = vsr;
		this.onlyOneInstance = onlyOneInstance;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		// TODO Auto-generated method stub
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		if (target instanceof Choice) {
			thisResolution.add(addResolution((Choice) target, parent));
		}
		if (target instanceof VClassifier) {
			int min;

			if (((VClassifier) target).getInstanceMultiplicity() != null && !onlyOneInstance) {
				min = ((VClassifier) target).getInstanceMultiplicity().getLower();
			} else {
				System.err.println("instance error");
				min = 1;
			}
			for (int i = 0; i < min; i++) {
				thisResolution.add(addResolution((VClassifier) target, parent));
				// new recursiveResolve().init(view, target, thisResolution).execute();
			}
			min = 0;
		}
		if (target instanceof Variable) {

			thisResolution.add(addResolution((Variable) target, parent));

		}
		if (thisResolution.size() == 0) {
			System.err.println("VSpecResolution of this type is not implemented");
		}
		return thisResolution;
	}

	private VSpecResolution addResolution(VClassifier target, VSpecResolution parent) {
		VInstance thisResolution = BvrFactory.eINSTANCE.createVInstance();
		thisResolution.setResolvedVSpec(target);
		// count++;
		// vi.setName("vInstance" + count);
		thisResolution.setName("instance");
		Context.eINSTANCE.getEditorCommands().addVInstance(parent, thisResolution);
		return thisResolution;
	}

	// resolve Choice
	private VSpecResolution addResolution(Choice target, VSpecResolution parent) {
		ChoiceResolutuion thisResolution = BvrFactory.eINSTANCE.createChoiceResolutuion();
		Context.eINSTANCE.getEditorCommands().addChoiceResolved(target, parent, thisResolution);
		Context.eINSTANCE.getEditorCommands().setResolutionDecision(thisResolution, false);
		return thisResolution;
	}

	// resolve Variable
	private VSpecResolution addResolution(Variable vSpecFound, VSpecResolution parent) {
		AddVariableValueAssignmentEventV2 v = new AddVariableValueAssignmentEventV2(parent, vSpecFound, view);
		v.actionPerformed(null);
		System.out.println(v.getVarableValueAssignment().getName());
		return v.getVarableValueAssignment();
	}
}
