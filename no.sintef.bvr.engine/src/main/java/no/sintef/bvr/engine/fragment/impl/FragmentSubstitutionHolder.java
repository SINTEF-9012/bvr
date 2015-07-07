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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;





import bvr.BoundaryElementBinding;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.ToBinding;
import bvr.ToPlacement;
import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;


public class FragmentSubstitutionHolder implements IFragSubHolder {

	private FragmentSubstitution fragment;
	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private EList<BoundaryElementBinding> bindings;
	private EList<ToBinding> toBindings;
	private EList<FromBinding> fromBindings;
	private HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementOHInsideBoundaryMap;
	private HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap;

	public FragmentSubstitutionHolder(FragmentSubstitution fs) throws BasicBVREngineException {
		fragment = fs;
		placement = new PlacementElementHolder(fragment.getPlacement());
		replacement = new ReplacementElementHolder(fragment.getReplacement());
		//if we do not replace a placement, it may bring multiply insideBoundaryElement references for FromPlacement
		fromPlacementOHInsideBoundaryMap = testFromPlacementOHInsideBoundaryMap(placement.getFromPlacementInsBoundaryMap());
		//adjacentness may bring multiply outsideBoundaryElement reference for ToPlacement
		toPlacementOHOutsideBoundaryMap = testToPlacementOHOutsideBoundaryMap(placement.getToPlacementOutBoundaryMap());
		bindings = fragment.getBoundaryElementBinding();
		toBindings = new BasicEList<ToBinding>();
		fromBindings = new BasicEList<FromBinding>();
		for(BoundaryElementBinding binding : bindings){
			if(binding instanceof ToBinding){
				toBindings.add((ToBinding) binding);
			}
			if(binding instanceof FromBinding){
				fromBindings.add((FromBinding) binding);
			}
		}
	}
	
	public void update(boolean replace) throws BasicBVREngineException{
		if(replace) removeNotBoundBoundaries();
		placement.setFromPlacementInsBoundaryMap(fromPlacementOHInsideBoundaryMap);
		placement.setToPlacementOutBoundaryMap(toPlacementOHOutsideBoundaryMap);
		placement.update();
	}
	
	public void refresh() throws BasicBVREngineException{
		placement.setFromPlacementInsBoundaryMap(fromPlacementOHInsideBoundaryMap);
		placement.setToPlacementOutBoundaryMap(toPlacementOHOutsideBoundaryMap);
		placement.update();
	}
	
	@Override
	public PlacementElementHolder getPlacement() {
		return placement;
	}

	@Override
	public ReplacementElementHolder getReplacement() {
		return replacement;
	}

	@Override
	public FragmentSubstitution getFragment() {
		return fragment;
	}

	@Override
	public EList<ToBinding> getToBindings() {
		return toBindings;
	}

	@Override
	public EList<FromBinding> getFromBinding() {
		return fromBindings;
	}
	
	public void setFromPlacementInsideBoundaryElementMap(HashMap<FromPlacement, HashSet<ObjectHandle>> insideBoundaryMap){
		this.fromPlacementOHInsideBoundaryMap = insideBoundaryMap;
	}
	
	public HashMap<FromPlacement, HashSet<ObjectHandle>> getFromPlacementInsideBoundaryElementMap(){
		return this.fromPlacementOHInsideBoundaryMap;
	}
	
	public void setToPlacementOutsideBoundaryElementMap(HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryMap){
		this.toPlacementOHOutsideBoundaryMap = outsideBoundaryMap;
	}
	
	public HashMap<ToPlacement, HashSet<ObjectHandle>> getToPlacementOutsideBoundaryElementMap(){
		return this.toPlacementOHOutsideBoundaryMap;
	}

	private HashMap<FromPlacement, HashSet<ObjectHandle>> testFromPlacementOHInsideBoundaryMap(HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap) {
		HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementOHInsideBoundaryMap = new HashMap<FromPlacement, HashSet<ObjectHandle>>();
		for(Map.Entry<FromPlacement, HashSet<EObject>> entry : fromPlacementInsBoundaryMap.entrySet()){
			FromPlacement fromPlacement = entry.getKey();
			HashSet<EObject> setEObjects = entry.getValue();
			HashSet<ObjectHandle> setObjectHandles = new HashSet<ObjectHandle>(EngineUtility.getPlacementObjectHandlesByEObjects(fragment.getPlacement(), new BasicEList<EObject>(setEObjects)));
			fromPlacementOHInsideBoundaryMap.put(fromPlacement, setObjectHandles);
		}
		return fromPlacementOHInsideBoundaryMap;
	}
	
	private HashMap<ToPlacement, HashSet<ObjectHandle>> testToPlacementOHOutsideBoundaryMap(HashMap<ToPlacement, HashSet<EObject>> toPlacementOutBoundaryMap) {
		HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap = new HashMap<ToPlacement, HashSet<ObjectHandle>>();
		for(Map.Entry<ToPlacement, HashSet<EObject>> entry : toPlacementOutBoundaryMap.entrySet()){
			ToPlacement toPlacement = entry.getKey();
			HashSet<EObject> setEObjects = entry.getValue();
			HashSet<ObjectHandle> setObjectHandles = new HashSet<ObjectHandle>(EngineUtility.getPlacementObjectHandlesByEObjects(fragment.getPlacement(), new BasicEList<EObject>(setEObjects)));
			toPlacementOHOutsideBoundaryMap.put(toPlacement, setObjectHandles);
		}		
		return toPlacementOHOutsideBoundaryMap;
	}
	
	private void removeNotBoundBoundaries() {
		EList<FromPlacement> boundedFromPlacements = new BasicEList<FromPlacement>();
		for(FromBinding fromBinding : fromBindings){
			boundedFromPlacements.add(fromBinding.getFromPlacement());
		}
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementFragment().getPlacementBoundaryElement();
		for(Iterator<PlacementBoundaryElement> iter = placementBoundaries.iterator(); iter.hasNext();){
			PlacementBoundaryElement placementBoundaryElement = iter.next();
			if(placementBoundaryElement instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) placementBoundaryElement;
				if(boundedFromPlacements.indexOf(fromPlacement) < 0){
					iter.remove();
					fromPlacementOHInsideBoundaryMap.remove(fromPlacement);
				}
			}
		}
	}
}
