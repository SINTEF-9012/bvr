/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.common;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface IHolderDataElement {

	public HashSet<EObject> getInnerNeighboringElements();
	
	public void addInnerNeighboringElement(EObject innerElement);
	
	public void addInnerNeighboringElement(Collection<EObject> innerElement);
	
	public HashSet<EObject> getInnerElements();
	
	public void addInnerElement(EObject innerElement);
	
	public void addInnerElement(Collection<EObject> innerElement);
	
	public HashSet<EObject> getOuterNeighboringElements();
	
	public void addOuterNeighboringElement(EObject outerElement);
	
	public void addOuterNeighboringElement(Collection<EObject> outerElement);
	
	public HashSet<EObject> getOuterInsideReferenceElements();
	
	public void addOuterInsideReferenceElements(EObject outerInnerElement);
	
	public void addOuterInsideReferenceElements(Collection<EObject> outerInnerElement);
	
	public HashSet<EObject> getOuterOutsideReferenceElements();
	
	public void addOuterOutsideReferenceElement(EObject outerOuterElement);
	
	public void addOuterOutsideReferenceElement(Collection<EObject> outerOuterElement);
	
	public HashSet<EObject> getBoundaryElementsInternal();
	
	public void addBoundaryElementInternal(EObject boundaryElementInternal);
	
	public void addBoundaryElementInternal(Collection<EObject> boundaryElementInternal);
	
	public HashSet<EObject> getBoundaryElementsExternal();
	
	public void addBoundaryElementExternal(EObject boundaryElementExternal);
	
	public void addBoundaryElementExternal(Collection<EObject> boundaryElementExternal);
	
	public HashSet<EObject> getInnerFragmentElements();
	
	public void addInnerFragmentElements(Collection<EObject> innerFragElements);
}
