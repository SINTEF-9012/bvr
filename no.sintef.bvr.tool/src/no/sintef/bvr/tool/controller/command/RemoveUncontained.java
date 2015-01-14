package no.sintef.bvr.tool.controller.command;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;

public class RemoveUncontained implements ResCommand {
	BVRToolModel toolModel;
	VSpec vsParent;
	VSpecResolution parent;

	@Override
	public ResCommand init(BVRToolModel toolModel, VSpec vsParent, VSpecResolution parent, boolean onlyOneInstance) {
		this.toolModel = toolModel;
		this.vsParent = vsParent;
		this.parent = parent;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {

		List<VSpecResolution> toRemove = new ArrayList<VSpecResolution>();
		
		if (!(parent instanceof ValueResolution) && !CommonUtility.isOccurrence((VNode) parent.getResolvedVSpec())) {

			if (parent instanceof CompoundResolution) {
				for (VSpecResolution n : ((CompoundResolution) parent).getMembers()) {

					boolean remove = true;
					if (n instanceof ValueResolution) {
						for (Variable var : ((VNode) parent.getResolvedVSpec()).getVariable()) {
								if (var == null) {
								remove = true;
								break;
							}
							if (n.getResolvedVSpec() == null) {
								remove = true;
								break;
							}
							if (n.getResolvedVSpec().equals(var)) {
								remove = false;
								break;
							}

						}
					} else {
						for (VNode v : ((CompoundNode) parent.getResolvedVSpec()).getMember()) {

							if (v == null) {
								remove = true;
								break;
							}
							if (n.getResolvedVSpec() == null) {
								remove = true;
								break;
							}
							if (n.getResolvedVSpec().equals(v)) {
								remove = false;
								break;
							}
						}
					}
					if (remove) {
						toRemove.add(n);
					}
				}
			}
		}
		for (VSpecResolution toR : toRemove) {
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parent, toR);
		}
		List<VSpecResolution> _parent = new ArrayList<VSpecResolution>();
		_parent.add(parent);
		return _parent;
	}

}