/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.interfaces.fragment.IElementHolder;

public abstract class BasicElementHolder implements IElementHolder {

	protected HashSet<EObject> frElementsOriginal;
	protected HashSet<EObject> frBElementsInternal; 
	protected HashSet<EObject> frBElementsExternal;
	protected HashSet<EObject> frElementsInternal;
	protected HashSet<EObject> frNeighboringInsideElements;
	protected HashSet<EObject> frNeighboringOutsideElements;
	
	@Override
	public HashSet<EObject> getElements() {
		return frElementsOriginal;
	}

	@Override
	public HashSet<EObject> getBElementsInternal() {
		return frBElementsInternal;
	}

	@Override
	public HashSet<EObject> getBElementsExternal() {
		return frBElementsExternal;
	}

	@Override
	public HashSet<EObject> getElementsInternal() {
		return frElementsInternal;
	}
	
	@Override
	public HashSet<EObject> getNeighboringInsideElements() {
		return frNeighboringInsideElements;
	}
	
	@Override
	public HashSet<EObject> getNeighboringOutsideElements() {
		return frNeighboringOutsideElements;
	}
		
	protected void locate() throws BasicBVREngineException {
		frElementsOriginal = new HashSet<EObject>();
		frBElementsInternal = new HashSet<EObject>();
		frBElementsExternal = new HashSet<EObject>();
		frElementsInternal = new HashSet<EObject>();
		frNeighboringInsideElements = new HashSet<EObject>();
		frNeighboringOutsideElements = new HashSet<EObject>();
	}

}
