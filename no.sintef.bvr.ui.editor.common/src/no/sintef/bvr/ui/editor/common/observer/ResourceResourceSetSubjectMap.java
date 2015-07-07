/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.observer;

import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;


public final class ResourceResourceSetSubjectMap extends AbstractResourceSubjectMap {
	
	public static final ResourceResourceSetSubjectMap eINSTANCE = getInstance();
	
	private static ResourceResourceSetSubjectMap getInstance(){
		return new ResourceResourceSetSubjectMap();
	}

	private ResourceResourceSetSubjectMap(){
		subjects = new HashMap<URI, List<ResourceSubject>>();
	}
}
