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

import bvr.PlacementFragment;

public class PlacementOldNewHolder {

	private PlacementFragment placement;
	
	private HashSet<EObject> staleElements;
	
	private HashSet<EObject> currentElements;
	
	public PlacementOldNewHolder(PlacementFragment placement, HashSet<EObject> plecementElements){
		this.placement = placement;
		staleElements = new HashSet<EObject>(plecementElements);
	}

	public PlacementFragment getPlacement() {
		return placement;
	}

	public void setPlacement(PlacementFragment placement) {
		this.placement = placement;
	}

	public HashSet<EObject> getStaleElements() {
		return staleElements;
	}

	public void setStaleElements(HashSet<EObject> staleElements) {
		this.staleElements = new HashSet<EObject>(staleElements);
	}

	public HashSet<EObject> getCurrentElements() {
		return currentElements;
	}

	public void setCurrentElements(HashSet<EObject> currentElements) {
		this.currentElements = new HashSet<EObject>(currentElements);
	}
	
}
