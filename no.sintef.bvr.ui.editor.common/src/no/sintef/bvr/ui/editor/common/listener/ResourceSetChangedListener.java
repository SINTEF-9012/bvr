/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.listener;

import java.util.List;

import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;


public class ResourceSetChangedListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		List<URI> resources = ResourceResourceSavedSubjectMap.eINSTANCE.getReqisteredURIResources();
		for(URI resource : resources){
			if(!resource.isPlatformResource())
				throw new UnsupportedOperationException("resource is not a platform one " + resource);
			IPath path = new Path(resource.toPlatformString(true));
			IResourceDelta delta = event.getDelta().findMember(path);
			if(delta == null)
				continue;
			//only interested in changes resources(not added or removed) and content changes in the resource
			if((delta.getKind() == IResourceDelta.ALL_WITH_PHANTOMS) && ((delta.getFlags() != IResourceDelta.MARKERS))){
				ResourceResourceSavedSubjectMap.eINSTANCE.pokeResourceSubjects(resource);
			}
		}
	}

}
