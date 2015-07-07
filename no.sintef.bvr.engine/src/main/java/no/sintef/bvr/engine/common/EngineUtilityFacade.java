/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.ToReplacement;
import no.sintef.bvr.common.engine.error.GeneralBVREngineException;
import no.sintef.bvr.engine.interfaces.common.IEngineUtility;

public class EngineUtilityFacade implements IEngineUtility {
	
	public static final IEngineUtility eINSTANCE = getInstance();
	
	private static IEngineUtility getInstance() {
		return new EngineUtilityFacade();
	}
	
	private EngineUtilityFacade() {}

	@Override
	public EList<EObject> resolveProxies(EList<? extends EObject> proxyList) {
		return EngineUtility.resolveProxies(proxyList);
	}

	@Override
	public EObject resolveProxies(EObject proxy) {
		return EngineUtility.resolveProxies(proxy);
	}

	@Override
	public EList<ObjectHandle> getPlacementObjectHandlesByEObjects(
			PlacementFragment placement, EList<EObject> eObjectList) {
		return EngineUtility.getPlacementObjectHandlesByEObjects(placement, eObjectList);
	}

	@Override
	public EList<ObjectHandle> getReplacementObjectHandlesByEObjects(
			ReplacementFragmentType replacement, EList<EObject> eObjectList) {
		return EngineUtility.getReplacementObjectHandlesByEObjects(replacement, eObjectList);
	}

	@Override
	public ObjectHandle getObjectHandle(EObject eObject,
			EList<ObjectHandle> objectHandles) {
		return EngineUtility.getObjectHandle(eObject, objectHandles);
	}

	@Override
	public EList<EObject> getListPropertyValue(EObject holder,
			EStructuralFeature property) throws GeneralBVREngineException {
		return EngineUtility.getListPropertyValue(holder, property);
	}

	@Override
	public EList<EObject> subtractAugmentList(EList<EObject> elementsOrig,
			EList<EObject> elementsToRemove, EList<EObject> elementsToAdd) {
		return EngineUtility.subtractAugmentList(elementsOrig, elementsToRemove, elementsToAdd);
	}

	@Override
	public <K, V> HashMap<V, K> reverseMap(Map<K, V> map) {
		return EngineUtility.reverseMap(map);
	}

	@Override
	public boolean isDummyToReplacement(ToReplacement toReplacement) {
		return EngineUtility.isDummyToReplacement(toReplacement);
	}

	@Override
	public boolean isDummyFromPlacement(FromPlacement fromPlacement) {
		return EngineUtility.isDummyFromPlacement(fromPlacement);
	}

	@Override
	public HashSet<EObject> clearSet(HashSet<EObject> set) {
		return EngineUtility.clearSet(set);
	}

	@Override
	public void setProperty(EList<EObject> original, EList<EObject> toRemove,
			EList<EObject> toAdd) {
		EngineUtility.setProperty(original, toRemove, toAdd);
	}

	@Override
	public int testPlacementIntersection(ReplacementFragmentType replcnt,
			PlacementFragment plcnt) {
		return EngineUtility.testPlacementIntersection(replcnt, plcnt);
	}

	@Override
	public void setProperty(EObject targetEObject, EStructuralFeature feature,
			Object value) {
		EngineUtility.setProperty(targetEObject, feature, value);
	}

	@Override
	public int flagNOT_CNTND() {
		return EngineUtility.NOT_CNTND;
	}

	@Override
	public int flagCNTND() {
		return EngineUtility.CNTND;
	}

	@Override
	public int flagP_CNTND() {
		return EngineUtility.P_CNTND;
	}

}
