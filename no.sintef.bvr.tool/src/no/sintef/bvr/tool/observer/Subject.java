/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;

import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public interface Subject {

	public void attach(Observer observer);
	
	public void detach(Observer observer);
	
	public void notifyObserver();

	public void setState(ObserverDataBulk data);
	
	public boolean isApplicable(ObserverDataBulk data);
}
