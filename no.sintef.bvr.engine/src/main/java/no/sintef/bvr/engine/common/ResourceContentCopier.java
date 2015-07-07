/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ResourceContentCopier extends Copier implements IResourceContentCopier {

	private static final long serialVersionUID = -6292277081092094075L;
	
	private Resource originalResource;
	
	@Override
	public void copyResource(Resource resource){
		clear();
		setOriginalResource(resource);
		EList<EObject> contents = resource.getContents();
		copyAll(contents);
		copyReferences();
	}

	@Override
	public Resource getOriginalResource() {
		return originalResource;
	}

	private void setOriginalResource(Resource originalResource) {
		this.originalResource = originalResource;
	}

}
