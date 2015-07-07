/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.common;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.CompoundResolution;

public interface IVarModelResolutionsCopier {

	public void copyAbsractions(BVRModel model);

	public CompoundNode getOriginalVariabilityModel();

	public List<CompoundResolution> getOriginalResolutions();

	public CompoundNode getCopiedVariabilityModel();

	public List<CompoundResolution> getCopiedResolutions();

	public BVRModel getOriginalBVRModel();

	public BVRModel getCopiedBVRModel();

	public EObject getOriginalEObject(EObject eObject);

}
