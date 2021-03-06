/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import java.util.Collection;
import java.util.HashSet;

import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;

import org.eclipse.emf.ecore.EObject;

public class HolderDataElement implements IHolderDataElement {
	
	private HashSet<EObject> innerNeighboringElements;
	private HashSet<EObject> outerNeighboringElements; 
	private HashSet<EObject> outerInsideReferenceElements;
	private HashSet<EObject> outerOutsideReferenceElements;
	private HashSet<EObject> boundaryElementsInternal;
	private HashSet<EObject> boundaryElementsExternal;
	private HashSet<EObject> innerElements;
	private HashSet<EObject> innerFragmentElements;
	
	public HolderDataElement(){
		innerNeighboringElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		innerFragmentElements = new HashSet<EObject>();
		outerNeighboringElements = new HashSet<EObject>();
		outerInsideReferenceElements = new HashSet<EObject>();
		outerOutsideReferenceElements = new HashSet<EObject>();
		boundaryElementsInternal = new HashSet<EObject>();
		boundaryElementsExternal = new HashSet<EObject>();
	}
	
	public HashSet<EObject> getInnerNeighboringElements() {
		return innerNeighboringElements;
	}
	
	public void addInnerNeighboringElement(EObject innerElement) {
		innerNeighboringElements.add(innerElement);
	}
	
	public void addInnerNeighboringElement(Collection<EObject> innerElement){
		innerNeighboringElements.addAll(innerElement);
	}
	
	public HashSet<EObject> getInnerElements() {
		return innerElements;
	}
	
	public void addInnerElement(EObject innerElement) {
		innerElements.add(innerElement);
	}
	
	public void addInnerElement(Collection<EObject> innerElement){
		innerElements.addAll(innerElement);
	}
	
	public HashSet<EObject> getOuterNeighboringElements() {
		return outerNeighboringElements;
	}
	
	public void addOuterNeighboringElement(EObject outerElement) {
		outerNeighboringElements.add(outerElement);
	}
	
	public void addOuterNeighboringElement(Collection<EObject> outerElement) {
		outerNeighboringElements.addAll(outerElement);
	}
	
	public HashSet<EObject> getOuterInsideReferenceElements() {
		return outerInsideReferenceElements;
	}
	
	public void addOuterInsideReferenceElements(EObject outerInnerElement) {
		outerInsideReferenceElements.add(outerInnerElement);
	}
	
	public void addOuterInsideReferenceElements(Collection<EObject> outerInnerElement) {
		outerInsideReferenceElements.addAll(outerInnerElement);
	}
	
	public HashSet<EObject> getOuterOutsideReferenceElements() {
		return outerOutsideReferenceElements;
	}
	
	public void addOuterOutsideReferenceElement(EObject outerOuterElement) {
		outerOutsideReferenceElements.add(outerOuterElement);
	}
	
	public void addOuterOutsideReferenceElement(Collection<EObject> outerOuterElement) {
		outerOutsideReferenceElements.addAll(outerOuterElement);
	}
	
	public HashSet<EObject> getBoundaryElementsInternal() {
		return boundaryElementsInternal;
	}
	
	public void addBoundaryElementInternal(EObject boundaryElementInternal) {
		boundaryElementsInternal.add(boundaryElementInternal);
	}
	
	public void addBoundaryElementInternal(Collection<EObject> boundaryElementInternal) {
		boundaryElementsInternal.addAll(boundaryElementInternal);
	}
	
	public HashSet<EObject> getBoundaryElementsExternal() {
		return boundaryElementsExternal;
	}
	
	public void addBoundaryElementExternal(EObject boundaryElementExternal) {
		boundaryElementsExternal.add(boundaryElementExternal);
	}
	
	public void addBoundaryElementExternal(Collection<EObject> boundaryElementExternal) {
		boundaryElementsExternal.addAll(boundaryElementExternal);
	}

	public HashSet<EObject> getInnerFragmentElements() {
		return innerFragmentElements;
	}

	public void addInnerFragmentElements(Collection<EObject> innerFragElements) {
		innerFragmentElements.addAll(innerFragElements);
	}
}
