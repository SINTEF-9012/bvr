/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractResourceSubject implements ResourceSubject {

	protected List<ResourceObserver> observers = new ArrayList<ResourceObserver>();

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
		for (ResourceObserver observer : observers)
			observer.update(this);
	}

}
