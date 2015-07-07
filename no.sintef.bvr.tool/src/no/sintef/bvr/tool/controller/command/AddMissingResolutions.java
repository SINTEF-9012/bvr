/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.controller.command.ResCommand;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.PosResolution;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddMissingResolutions implements ResCommand {
	private BVRToolModel view;
	private VSpec target;
	boolean unresolved;
	private VSpecResolution parent;

	/**
	 * NOT TRANSACTIONAL ONLY for use with nodes NOT added to model
	 */
	@Override
	public ResCommand init(BVRToolModel view, VSpec target, VSpecResolution parent, boolean onlyOneInstance) {
		this.view = view;
		this.target = target;
		this.parent = parent;
		return this;
	}

	/**
	 * NOT TRANSACTIONAL ONLY for use with nodes NOT added to model
	 */
	@Override
	public List<VSpecResolution> execute() {
		ArrayList<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		unresolved = true;
		int instances = 0;
		int min = 0;

		if (parent instanceof PosResolution) {

			for (VSpecResolution x : ((CompoundResolution) parent).getMembers()) {
				if (x.getResolvedVSpec().equals(target)) {
					thisResolution.add(x);
					unresolved = false;
					if (CommonUtility.isVSpecResolutionVClassifier(x)) {
						if (((ChoiceResolution) x).getResolvedVClassOcc() != null) {
							min = ((VClassOccurrence) x.getResolvedVSpec()).getInstanceMultiplicity().getLower();
							instances++;
						} else {
							min = ((VClassifier) x.getResolvedVSpec()).getInstanceMultiplicity().getLower();
							instances++;
						}
					}
				}
			}

			while (instances < min) {
				thisResolution.addAll((ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, true)).execute());
				instances++;
			}
			if (unresolved)
				thisResolution = (ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, false)).execute();
		}
		return thisResolution;
	}

}
