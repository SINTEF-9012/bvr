/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.model;

import java.util.Map;
import java.util.Set;

import bvr.BVRModel;
import bvr.Target;
import bvr.VSpec;

public interface IBVRToolModel {

	public BVRModel getBVRModel();

	public Map<Target, Set<VSpec>> getTargetVSpecMap();
}
