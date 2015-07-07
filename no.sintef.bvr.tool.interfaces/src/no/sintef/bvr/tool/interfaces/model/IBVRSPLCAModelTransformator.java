/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.model;

import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import bvr.CompoundNode;

public interface IBVRSPLCAModelTransformator {

	CompoundNode transformVarModelToSPLCA();

	IVarModelResolutionsCopier getModelCopier();

}
