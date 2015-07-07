/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;

import java.util.Set;

import no.sintef.bvr.tool.interfaces.observer.AbstractResourceSubject;
import bvr.Target;
import bvr.VSpec;

public class TargetChangedSubject extends AbstractResourceSubject {

	private Target new_target;
	private Target stale_target;
	private String new_name;
	private Set<VSpec> vspecs;

	public Target getCurrentTarget() {
		return new_target;
	}

	public void setCurrentTarget(Target target) {
		new_target = target;
	}

	public String getCurrentName() {
		return new_name;
	}

	public void setCurrentName(String name) {
		new_name = name;
	}

	public Set<VSpec> getVSpecs() {
		return vspecs;
	}

	public void setVSpecs(Set<VSpec> vspecs) {
		this.vspecs = vspecs;
	}

	public Target getStaleTarget() {
		return stale_target;
	}

	public void setStaleTarget(Target stale_target) {
		this.stale_target = stale_target;
	}

}
