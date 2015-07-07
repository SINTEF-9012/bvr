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
import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;

public abstract class AbstractResourceSubjectMap implements ResourceSubjectMap {

	protected HashMap<URI, List<ResourceSubject>> subjects;

	public List<ResourceSubject> getSubjects(URI resourceURI){
		return subjects.get(resourceURI);
	}
	
	public void testResourceSubject(URI resourceURI, ResourceSubject subject){
		List<ResourceSubject> list = subjects.get(resourceURI);
		if(list != null){
			if(!list.contains(subject)){
				list.add(subject);
			}
		}else{
			list = new ArrayList<ResourceSubject>();
			list.add(subject);
			subjects.put(resourceURI, list);
		}
	}
	
	public void pokeResourceSubjects(URI resourceURI){
		List<ResourceSubject> list = subjects.get(resourceURI);
		if(list != null){
			Iterator<ResourceSubject> iter = list.iterator();
			while(iter.hasNext()) {
				ResourceSubject subject = iter.next();
				subject.notifyObservers();
			}
		}
	}
}
