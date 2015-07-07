/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.fragment;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ToPlacement;
import no.sintef.bvr.common.engine.error.BasicBVREngineException;


public interface IPlacementElementHolder extends IElementHolderOIF, IElementHolder {

	public void update() throws BasicBVREngineException;
	
	public PlacementFragment getPlacementFragment();
	
	public HashMap<FromPlacement, HashSet<EObject>> getFromPlacementInsBoundaryMap();
	
	public HashMap<ToPlacement,HashSet<EObject>> getToPlacementOutBoundaryMap();
	
	public void setFromPlacementInsBoundaryMap(HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementInsBoundaryMap);
	
	public void setToPlacementOutBoundaryMap(HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap);
}
