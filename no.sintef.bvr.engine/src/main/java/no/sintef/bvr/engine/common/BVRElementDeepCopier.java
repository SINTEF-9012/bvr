/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import java.util.Collection;

import no.sintef.bvr.engine.interfaces.common.IBVRElementDeepCopier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class BVRElementDeepCopier extends Copier implements IBVRElementDeepCopier {

	private static final long serialVersionUID = -3804582799895873560L;

	@Override
	public void copyElements(Collection<EObject> eObjects){
		clear();
		copyAll(eObjects);
		copyReferences();
	}

	@Override
	public EObject get(EObject eObject) {
		return super.get(eObject);
	}
}
