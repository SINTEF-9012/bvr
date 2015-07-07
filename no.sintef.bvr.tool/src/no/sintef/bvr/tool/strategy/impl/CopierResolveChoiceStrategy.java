/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import no.sintef.ict.splcatool.interfaces.IResolveChoiceStrategy;

import org.eclipse.emf.ecore.EObject;

import bvr.VSpec;

public class CopierResolveChoiceStrategy implements IResolveChoiceStrategy {

	private IVarModelResolutionsCopier copier;

	public CopierResolveChoiceStrategy(IVarModelResolutionsCopier _copier) {
		copier = _copier;
	}

	@Override
	public VSpec getOriginalVSpec(VSpec vSpec) {
		EObject eObject = copier.getOriginalEObject(vSpec);
		if (eObject == null)
			throw new UnexpectedException("cannot retrive the orignal vspec from the copier for " + vSpec);
		return (VSpec) eObject;
	}

}
