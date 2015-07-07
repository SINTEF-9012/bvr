/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import no.sintef.bvr.common.engine.error.GeneralBVREngineException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.ToReplacement;

public interface IEngineUtility {

	public EList<EObject> resolveProxies(EList<? extends EObject> proxyList);
	
	public EObject resolveProxies(EObject proxy);
	
	public EList<ObjectHandle> getPlacementObjectHandlesByEObjects(PlacementFragment placement, EList<EObject> eObjectList);
	
	public EList<ObjectHandle> getReplacementObjectHandlesByEObjects(ReplacementFragmentType replacement, EList<EObject> eObjectList);
	
	public ObjectHandle getObjectHandle(EObject eObject, EList<ObjectHandle> objectHandles);
	
	public EList<EObject> getListPropertyValue(EObject holder, EStructuralFeature property) throws GeneralBVREngineException;
	
	public EList<EObject> subtractAugmentList(EList<EObject> elementsOrig, EList<EObject> elementsToRemove, EList<EObject> elementsToAdd);
	
	public <K,V> HashMap<V,K> reverseMap(Map<K,V> map);
	
	public boolean isDummyToReplacement(ToReplacement toReplacement);
	
	public boolean isDummyFromPlacement(FromPlacement fromPlacement);
	
	public HashSet<EObject> clearSet(HashSet<EObject> set);
	
	public void setProperty(EList<EObject> original, EList<EObject> toRemove, EList<EObject> toAdd);
	
	public int testPlacementIntersection(ReplacementFragmentType replcnt, PlacementFragment plcnt);
	
	public void setProperty(EObject targetEObject, EStructuralFeature feature, Object value);
	
	public int flagNOT_CNTND();
	
	public int flagCNTND();
	
	public int flagP_CNTND();
}
