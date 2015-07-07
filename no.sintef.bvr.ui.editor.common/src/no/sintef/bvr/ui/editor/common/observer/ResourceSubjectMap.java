/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.observer;

import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;

public interface ResourceSubjectMap {
	
	public List<ResourceSubject> getSubjects(URI resourceURI);	
	public void testResourceSubject(URI resourceURI, ResourceSubject subject);
	public void pokeResourceSubjects(URI resourceURI);
}
