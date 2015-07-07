/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface IElementHolder {

	public HashSet<EObject> getElements();
	
	public HashSet<EObject> getBElementsInternal();
	
	public HashSet<EObject> getBElementsExternal();
	
	public HashSet<EObject> getElementsInternal();
	
	//Elements referenced by outsideBoundaryElements and
	//pointing to elements inside a placement
	public HashSet<EObject> getNeighboringInsideElements();
	
	//Elements referenced by outsideBoundaryElements and
	//pointed by elements from a placement
	public HashSet<EObject> getNeighboringOutsideElements();
	
}
