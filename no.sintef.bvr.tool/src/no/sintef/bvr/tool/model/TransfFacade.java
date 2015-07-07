/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.common.VarModelResolutionsCopier;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import bvr.BVRModel;

public final class TransfFacade {

	public static TransfFacade eINSTANCE = getInstance();

	private static TransfFacade getInstance() {
		if (eINSTANCE == null) {
			eINSTANCE = new TransfFacade();
		}
		return eINSTANCE;
	}

	public IBVRSPLCAModelTransformator getSPLCATransformator(BVRModel model) {
		return new BVRSPLCAModelTransformator(model, new VarModelResolutionsCopier());
	}

}
