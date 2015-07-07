/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.observer;

public interface ResourceSubject {

	public void attach(ResourceObserver observer);
	
	public void detach(ResourceObserver observer);
	
	public void notifyObservers();
}
