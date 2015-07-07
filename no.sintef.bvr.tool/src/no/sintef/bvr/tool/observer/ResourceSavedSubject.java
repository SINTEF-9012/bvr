/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

public class ResourceSavedSubject implements ResourceSubject {

	protected List<ResourceObserver> observers = new ArrayList<ResourceObserver>();
	protected HashSet<ResourceObserver> obsolete = new HashSet<ResourceObserver>();
	
	@Override
	public void attach(ResourceObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(ResourceObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<ResourceObserver> iter = observers.iterator();
		while(iter.hasNext()) {
			ResourceObserver o = iter.next();
			if(!obsolete.contains(o)) {
				o.update(this);
			} else {
				iter.remove();
			}
		}
	}
	
	public void markObseleteObsever(ResourceObserver observer) {
		if(observers.contains(observer))
			obsolete.add(observer);
	}
}
