/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.observer;

import java.util.ArrayList;

import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public interface ChangeManager {

	public void register(Subject subject, Observer observer);
	
	public void unregister(Subject subject, Observer observer);
	
	public void notifyObserver();
	
	public void updateSubjects(ObserverDataBulk data, Observer observer);

	public ArrayList<Observer> registeredObservers(Subject subject);
	
	public void refreshSubject(Subject subject);

	public ArrayList<Subject> registeredSubjects(Observer observer);
}
