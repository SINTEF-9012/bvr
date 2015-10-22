/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ResourceContentCopier extends Copier implements IResourceContentCopier {

	private static final long serialVersionUID = -6292277081092094075L;

	private Map<Resource, Collection<EObject>> resourceCopiedObjectMap = new HashMap<Resource, Collection<EObject>>();

	@Override
	public void copyResourceContents(Resource resource) {
		EList<EObject> contents = resource.getContents();
		Collection<EObject> copiedObjects = copyAll(contents);
		resourceCopiedObjectMap.put(resource, copiedObjects);
	}

	@Override
	public void copyCrossContentsReferences() {
		copyReferences();
	}

	@Override
	public Collection<EObject> getCopiedContents(Resource resource) {
		return resourceCopiedObjectMap.get(resource);
	}

	@Override
	public void reset() {
		clear();
		resourceCopiedObjectMap.clear();
	}

}
