/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.fragment.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;
import no.sintef.bvr.engine.interfaces.strategy.IPlacementElementFinderStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;

import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.ToPlacement;


public class PlacementElementHolder extends BasicElementHolder implements IPlacementElementHolder {

	protected HashSet<EObject> innerElements;
	protected HashSet<EObject> outerElements;
	private PlacementFragment placement;
	private HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap;
	private HashMap<ToPlacement, HashSet<EObject>> toPlacementOutBoundaryMap;
	private IPlacementElementFinderStrategy elementFinder;

	public PlacementElementHolder(PlacementFragment pf) throws BasicBVREngineException {
		elementFinder = new StrategyPlacementElemenetFinder();
		placement = pf;
		fromPlacementInsBoundaryMap = new HashMap<FromPlacement, HashSet<EObject>>();
		toPlacementOutBoundaryMap = new HashMap<ToPlacement, HashSet<EObject>>();
		for(PlacementBoundaryElement pbe : placement.getPlacementBoundaryElement()){
			if(pbe instanceof ToPlacement){
				ToPlacement toPlacement = (ToPlacement) pbe;
				HashSet<EObject> set = new HashSet<EObject>();
				set.add(EngineUtility.resolveProxies(toPlacement.getOutsideBoundaryElement()));
				toPlacementOutBoundaryMap.put(toPlacement, set);
			}
			if(pbe instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) pbe;
				HashSet<EObject> set = new HashSet<EObject>();
				set.add(EngineUtility.resolveProxies(fromPlacement.getInsideBoundaryElement()));
				fromPlacementInsBoundaryMap.put(fromPlacement, set);
			}
		}
		this.locate();
	}
	
	@Override
	public void update() throws BasicBVREngineException {
		this.locate();
	}
	
	@Override
	protected void locate() throws BasicBVREngineException{
		super.locate();
		outerElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		
		IHolderDataElement data = elementFinder.locatePlacementElements(placement.getPlacementBoundaryElement(), fromPlacementInsBoundaryMap, toPlacementOutBoundaryMap);
		frBElementsInternal.addAll(data.getBoundaryElementsInternal());
		frBElementsExternal.addAll(data.getBoundaryElementsExternal());
		frNeighboringInsideElements.addAll(data.getOuterInsideReferenceElements());
		frNeighboringOutsideElements.addAll(data.getOuterOutsideReferenceElements());
		innerElements.addAll(data.getInnerNeighboringElements());
		outerElements.addAll(data.getOuterNeighboringElements());
		frElementsInternal.addAll(data.getInnerElements());
			
		frElementsOriginal.addAll(frBElementsExternal);
		frElementsOriginal.addAll(frBElementsInternal);
		frElementsOriginal.addAll(frElementsInternal);
	}
	
	@Override
	public HashSet<EObject> getInnerNeighboringElements() {
		HashSet<EObject> innElements = new HashSet<EObject>();
		for(HashSet<EObject> innerEl : fromPlacementInsBoundaryMap.values()){
			innElements.addAll(EngineUtility.clearSet(innerEl));
		}
		innElements.addAll(innerElements);
		return innElements;
	}
	
	@Override
	public HashSet<EObject> getBElementsExternal() {
		HashSet<EObject> innElements = new HashSet<EObject>();
		for(Map.Entry<FromPlacement, HashSet<EObject>> entry : fromPlacementInsBoundaryMap.entrySet()){
			FromPlacement fromPlacement = entry.getKey();
			HashSet<EObject> innerEl = entry.getValue();
			if(EngineUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement()).size() != 0){
				innElements.addAll(innerEl);;
			}
		}
		innElements.addAll(frBElementsExternal);
		return innElements;
	}

	@Override
	public HashSet<EObject> getOuterNeighboringElements() {
		return outerElements;
	}
	
	@Override
	public PlacementFragment getPlacementFragment() {
		return placement;
	}
	
	@Override
	public HashMap<FromPlacement, HashSet<EObject>> getFromPlacementInsBoundaryMap(){
		return this.fromPlacementInsBoundaryMap;
	}
	
	@Override
	public HashMap<ToPlacement,HashSet<EObject>> getToPlacementOutBoundaryMap(){
		return this.toPlacementOutBoundaryMap;
	}
	
	@Override
	public void setFromPlacementInsBoundaryMap(HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementInsBoundaryMap){
		HashMap<FromPlacement, HashSet<EObject>> map = new HashMap<FromPlacement, HashSet<EObject>>();
		for(Map.Entry<FromPlacement, HashSet<ObjectHandle>> entry : fromPlacementInsBoundaryMap.entrySet()){
			FromPlacement key = entry.getKey();
			HashSet<ObjectHandle> value = entry.getValue();
			map.put(key, new HashSet<EObject>(EngineUtility.resolveProxies(new BasicEList<ObjectHandle>(value))));
		}
		this.fromPlacementInsBoundaryMap = map;
	}

	@Override
	public void setToPlacementOutBoundaryMap(HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap) {
		HashMap<ToPlacement, HashSet<EObject>> map = new HashMap<ToPlacement, HashSet<EObject>>();
		for(Map.Entry<ToPlacement, HashSet<ObjectHandle>> entry : toPlacementOHOutsideBoundaryMap.entrySet()){
			ToPlacement key = entry.getKey();
			HashSet<ObjectHandle> value = entry.getValue();
			map.put(key, new HashSet<EObject>(EngineUtility.resolveProxies(new BasicEList<ObjectHandle>(value))));
		}
		this.toPlacementOutBoundaryMap = map;
	}
	
	@Override
	public HashSet<EObject> getInnerFragmentElements() {
		return frElementsOriginal;
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
		HashSet<EObject> elements = new HashSet<EObject>();
		elements.addAll(outerElements);
		elements.addAll(frElementsOriginal);
		return elements;
	}
}
