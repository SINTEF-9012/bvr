/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;

import java.util.Set;

import no.sintef.bvr.tool.interfaces.model.IBVRToolModel;
import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.model.VSpecFacade;
import bvr.Target;
import bvr.VSpec;

public class ChangeVSpecName implements ResourceObserver {

	private IBVRToolModel toolModel;

	public ChangeVSpecName(IBVRToolModel _toolModel) {
		toolModel = _toolModel;
	}

	@Override
	public void update(ResourceSubject subject) {
		if (!(subject instanceof TargetChangedSubject))
			return;

		TargetChangedSubject targetSubject = ((TargetChangedSubject) subject);

		Target changedTarget = targetSubject.getCurrentTarget();
		if (changedTarget == null)
			return;

		String new_name = targetSubject.getCurrentName();
		if (new_name == null)
			return;

		Set<VSpec> vspecs = targetSubject.getVSpecs();
		if (vspecs != null) {
			if (changedTarget.equals(targetSubject.getStaleTarget())) {
				for (VSpec vspec : vspecs)
					VSpecFacade.eINSTANCE.updateName(vspec, new_name);
			}
		}
	}

}
