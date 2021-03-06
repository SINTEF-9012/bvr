/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;

import org.eclipse.emf.common.util.URI;

public final class ResourceResourceSavedSubjectMap extends AbstractResourceSubjectMap {
		
	public static final ResourceResourceSavedSubjectMap eINSTANCE = getInstance();
	
	private static ResourceResourceSavedSubjectMap getInstance(){
		return new ResourceResourceSavedSubjectMap();
	}

	private ResourceResourceSavedSubjectMap(){
		subjects = new HashMap<URI, List<ResourceSubject>>();
	}
	
	public ResourceSavedSubject testResourceSavedSubject(URI resourceURI){
		List<ResourceSubject> subjs = subjects.get(resourceURI);
		if(subjs != null)
			return (ResourceSavedSubject) subjs.get(0);
		subjs = new ArrayList<ResourceSubject>();
		subjs.add(new ResourceSavedSubject());
		subjects.put(resourceURI, subjs);
		return (ResourceSavedSubject) subjs.get(0);
	}
	
	public List<URI> getReqisteredURIResources(){
		return new ArrayList<URI>(subjects.keySet());
	}
}
