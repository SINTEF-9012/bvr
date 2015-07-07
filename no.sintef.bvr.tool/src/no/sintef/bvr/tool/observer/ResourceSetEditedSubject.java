/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;


import java.util.HashSet;
import java.util.Iterator;

import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.model.BVRToolModel;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

public class ResourceSetEditedSubject implements ResourceSubject {

	protected HashSet<ResourceObserver> observers = new HashSet<ResourceObserver>();
	protected HashSet<ResourceObserver> obsolete = new HashSet<ResourceObserver>();
	protected ResourceSetChangeEvent event;
	protected BVRToolModel model;
	
	public ResourceSetEditedSubject(BVRToolModel model) {
		this.model = model;
	}
	
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

	public void setResourceSetChangeEvent(ResourceSetChangeEvent e){
		event = e;
	}
	
	public ResourceSetChangeEvent getResourceSetChangeEvent(){
		return event;
	}
	
	public void markObseleteObsever(ResourceObserver observer) {
		if(observers.contains(observer))
			obsolete.add(observer);
	}

}
