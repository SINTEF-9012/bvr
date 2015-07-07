/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.IllegalOperationException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.strategy.SelectionStrategy;

public class ContainmentSelectionStrategy implements SelectionStrategy {

	@Override
	public EList<EObject> getSelectedObjects() throws AbstractError {
		EList<EObject> selected = new BasicEList<EObject>();
		List<Object> selections = Context.eINSTANCE.getSelections();

		for(Object object: selections){
			EObject eObject = Context.eINSTANCE.getEObject(object);
			if(eObject == null)
				throw new UnexpectedException("no model element is found from a given selection");
			if(eObject.eContainer() == null)
				throw new IllegalOperationException("selected object is not contained anywhere or simply a top most element, not allowed yet " + eObject);
			selected.add(eObject);
		}
		
		EList<EObject> selectedObjects = this.includeContainedElements(selected);
		return selectedObjects;
	}
	
	private EList<EObject> includeContainedElements(EList<EObject> eObjects){
		HashSet<EObject> set = new HashSet<EObject>();
		for(EObject eObject : eObjects){
			set.add(eObject);
			for(TreeIterator<EObject> iterator = eObject.eAllContents(); iterator.hasNext();){
				EObject eObj = iterator.next();
				set.add(eObj);
			}
		}
		return new BasicEList<EObject>(set);
	}
}
