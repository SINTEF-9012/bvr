/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.strategy.SelectionStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class GetSelectionContext {
	
	private SelectionStrategy defaultStrategy;

	public GetSelectionContext(){
		this.defaultStrategy = (Context.eINSTANCE.getConfig().isContainmentSelectionMode()) ?
				new ContainmentSelectionStrategy() : new ContainmentLessSelectionStrategy();
	}
	
	public GetSelectionContext(SelectionStrategy selectStrategy){
		this.defaultStrategy = selectStrategy;
	}
	
	public EList<EObject> getSelectedObjects() throws AbstractError{
		EList<EObject> objects = this.defaultStrategy.getSelectedObjects();
		return objects;
	}

}
