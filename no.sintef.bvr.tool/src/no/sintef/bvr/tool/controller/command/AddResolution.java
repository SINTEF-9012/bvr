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
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.PrimitiveTypeFacade;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.PosResolution;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;

public class AddResolution implements ResCommand {
	private BVRToolModel view;
	private VSpec target;
	private boolean onlyOneInstance;
	private VSpecResolution parent;

	/**
	 * NOT TRANSACTIONAL ONLY for use with nodes NOT added to model
	 */
	@Override
	public ResCommand init(BVRToolModel view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.target = vs;
		this.parent = vsr;
		this.onlyOneInstance = onlyOneInstance;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		if (target instanceof Variable)
			thisResolution.add(addResolution((Variable) target, parent));
		if (target instanceof Choice)
			thisResolution.add(addResolution((Choice) target, parent));

		if (target instanceof ChoiceOccurrence)
			thisResolution.add(addResolution((ChoiceOccurrence) target, parent));

		if (target instanceof VClassifier) {
			int min;
			if (((VClassifier) target).getInstanceMultiplicity() != null && !onlyOneInstance) {
				min = ((VClassifier) target).getInstanceMultiplicity().getLower();
			} else {
				min = 1;
			}
			for (int i = 0; i < min; i++) {
				thisResolution.add(addResolution((VClassifier) target, parent));
			}
			min = 0;
		}

		if (target instanceof VClassOccurrence) {
			VClassOccurrence vClassOccurence = (VClassOccurrence) target;
			int min = (vClassOccurence.getInstanceMultiplicity() != null && !onlyOneInstance) ? vClassOccurence.getInstanceMultiplicity().getLower()
					: 1;
			for (int i = 0; i < min; i++)
				thisResolution.add(addResolution((VClassOccurrence) target, parent));
		}

		return thisResolution;
	}

	private VSpecResolution addResolution(VClassifier target, VSpecResolution parent) {

		PosResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName("I:" + view.getIncrementedInstanceCount());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);

		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve Choice
	private VSpecResolution addResolution(Choice target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName(target.getName());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve ChoiceOccurence
	private VSpecResolution addResolution(ChoiceOccurrence target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName(target.getName());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve VClassOccurrence
	private VSpecResolution addResolution(VClassOccurrence target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName("I:" + view.getIncrementedInstanceCount());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);

		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}
	// resolve ValueResolution
	private VSpecResolution addResolution(Variable target, VSpecResolution parent) {
		ValueResolution thisResolution = PrimitiveTypeFacade.getInstance().createDefaultValueResolution(target);
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}
}
