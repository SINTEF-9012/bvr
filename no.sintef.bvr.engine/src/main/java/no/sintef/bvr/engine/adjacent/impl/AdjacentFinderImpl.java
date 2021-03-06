/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.adjacent.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.ToBinding;
import bvr.ToPlacement;
import no.sintef.bvr.common.engine.error.UnexpectedOperationFailure;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.interfaces.adjacent.IAdjacentFinder;
import no.sintef.bvr.engine.interfaces.adjacent.IAdjacentFragment;
import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;

public class AdjacentFinderImpl implements IAdjacentFinder {

	private EList<FragmentSubstitutionHolder> fragmentList;
	private HashMap<IFragSubHolder, IAdjacentFragment> adjacentMap;

	public AdjacentFinderImpl(EList<FragmentSubstitutionHolder> fragmentsList){
		this.fragmentList = new BasicEList<FragmentSubstitutionHolder>(fragmentsList);
		this.adjacentMap = new HashMap<IFragSubHolder, IAdjacentFragment>();
		this.findAdjacentness();
		this.findTwinAdjacentFragments();
	}
	
	@Override
	public HashMap<IFragSubHolder, IAdjacentFragment> getAdjacentMap() {
		return this.adjacentMap;
	}
	
	private void findAdjacentness(){
		for(IFragSubHolder fragmentHolder : this.fragmentList){
			EList<IFragSubHolder> viewedFragments = new BasicEList<IFragSubHolder>();
			viewedFragments.add(fragmentHolder);
			IPlacementElementHolder placementHolder = fragmentHolder.getPlacement();
			SetView<IFragSubHolder> toViewFragments = Sets.symmetricDifference(new HashSet<IFragSubHolder>(this.fragmentList), new HashSet<IFragSubHolder>(viewedFragments));
			for(IFragSubHolder fragmentHolder1 : toViewFragments){
				IPlacementElementHolder placementHolder1 = fragmentHolder1.getPlacement();
				if(this.isAdjacent(placementHolder, placementHolder1)){
					HashMap<FromBinding, ToBinding> adjacentBindings = this.getAdjacentBindings(fragmentHolder, fragmentHolder1);
					if(!adjacentBindings.isEmpty()){
						IAdjacentFragment adjacentFragment = this.testAdjacentFragment(fragmentHolder);
						IAdjacentFragment adjacentFragment1 = this.testAdjacentFragment((fragmentHolder1));
						adjacentFragment.setAdjacentFragment(adjacentFragment1);
						adjacentFragment1.setAdjacentFragment(adjacentFragment);
						
						adjacentFragment.setAdjacentFromBindings(adjacentFragment1, adjacentBindings);
						HashMap<ToBinding, FromBinding> adjacentBindingsRev = EngineUtility.reverseMap(adjacentBindings);
						adjacentFragment1.setAdjacentToBindings(adjacentFragment, adjacentBindingsRev);
					}
				}
			}
		}
	}
	
	private boolean isAdjacent(IPlacementElementHolder placement, IPlacementElementHolder placement1){
		HashSet<EObject> iP = placement.getInnerNeighboringElements();
		HashSet<EObject> iP1 = placement1.getInnerNeighboringElements();
		if(Sets.intersection(iP, iP1).isEmpty()){
			HashSet<EObject> oP = placement.getOuterNeighboringElements();
			HashSet<EObject> oP1 = placement1.getOuterNeighboringElements();
			if(!Sets.intersection(iP, oP1).isEmpty() || !Sets.intersection(iP1, oP).isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private IAdjacentFragment testAdjacentFragment(IFragSubHolder fragmentHolder){
		IAdjacentFragment adjacentFragment = this.adjacentMap.get(fragmentHolder);
		if(adjacentFragment == null){
			adjacentFragment = new AdjacentFragmentImpl(fragmentHolder);
			this.adjacentMap.put(fragmentHolder, adjacentFragment);
		}
		return adjacentFragment;
	}
	
	private HashMap<FromBinding, ToBinding> getAdjacentBindings(IFragSubHolder fragmentHolder, IFragSubHolder fragmentHolder1){
		HashMap<FromBinding, ToBinding> boundariesMap = new HashMap<FromBinding, ToBinding>();
		EList<FromBinding> fromBindings = fragmentHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			if(!EngineUtility.isDummyFromPlacement(fromPlacement)){
				ObjectHandle insideBoundaryElement = fromPlacement.getInsideBoundaryElement();
				EObject insideBoundaryElementEObject = EngineUtility.resolveProxies(insideBoundaryElement);
				EList<ObjectHandle> outsideBoundatyElements = fromPlacement.getOutsideBoundaryElement();
				EList<EObject> outsideBoundatyElementsEObject = EngineUtility.resolveProxies(outsideBoundatyElements);
				EList<ToBinding> toBindings = fragmentHolder1.getToBindings();
				for(ToBinding toBinding : toBindings){
					ToPlacement toPlacement = toBinding.getToPlacement();
					ObjectHandle outsideBoundaryElement = toPlacement.getOutsideBoundaryElement();
					EObject outsideBoundaryElementEObject = EngineUtility.resolveProxies(outsideBoundaryElement);
					EList<ObjectHandle> insideBoundaryElements = toPlacement.getInsideBoundaryElement();
					EList<EObject> insideBoundaryElementsEObject = EngineUtility.resolveProxies(insideBoundaryElements);
					if(insideBoundaryElementEObject.equals(outsideBoundaryElementEObject) &&
							!Sets.intersection(new HashSet<EObject>(outsideBoundatyElementsEObject),
									new HashSet<EObject>(insideBoundaryElementsEObject)).isEmpty()){
						boundariesMap.put(fromBinding, toBinding);
					}
				}
			}
		}
		return boundariesMap;
	}
	
	private void findTwinAdjacentFragments(){
		ArrayList<IAdjacentFragment> fragments = new ArrayList<IAdjacentFragment>(adjacentMap.values());
		if(fragments.size() == 0)
			return;
		if(fragments.size() < 2)
			throw new UnexpectedOperationFailure("it is not possible that we just have one adjacent fragment " + fragments);
		
		for(int i=0; i<fragments.size()-1; i++){
			IAdjacentFragment fragment_i = fragments.get(i);
			IPlacementElementHolder pHolder_i = fragment_i.getFragmentHolder().getPlacement();
			HashSet<EObject> placementElements_i = pHolder_i.getElements();
			for(int j=i+1; j<fragments.size(); j++){
				IAdjacentFragment fragment_j = fragments.get(j);
				IPlacementElementHolder pHolder_j = fragment_j.getFragmentHolder().getPlacement();
				HashSet<EObject> placementElements_j = pHolder_j.getElements();
				if(Sets.symmetricDifference(placementElements_i, placementElements_j).isEmpty()){
					fragment_i.addTwinFragment(fragment_j);
					fragment_j.addTwinFragment(fragment_i);
					
					HashMap<ToPlacement, ToPlacement> toPlacements_i_j = new HashMap<ToPlacement, ToPlacement>();
					HashMap<ToPlacement, ToPlacement> toPlacements_j_i = new HashMap<ToPlacement, ToPlacement>();
					HashMap<FromPlacement, FromPlacement> fromPlacements_i_j = new HashMap<FromPlacement, FromPlacement>();
					HashMap<FromPlacement, FromPlacement> fromPlacements_j_i = new HashMap<FromPlacement, FromPlacement>();
					
					EList<PlacementBoundaryElement> boundaryElements_i = fragment_i.getFragmentHolder().getPlacement().getPlacementFragment().getPlacementBoundaryElement();
					EList<PlacementBoundaryElement> boundaryElements_j = fragment_j.getFragmentHolder().getPlacement().getPlacementFragment().getPlacementBoundaryElement();
					for(PlacementBoundaryElement boundary_i : boundaryElements_i){
						for(PlacementBoundaryElement boundary_j : boundaryElements_j){
							if(boundary_i instanceof ToPlacement && boundary_j instanceof ToPlacement){
								ToPlacement toPlacement_i = (ToPlacement) boundary_i;
								ToPlacement toPlacement_j = (ToPlacement) boundary_j;
								
								EObject outside_i = EngineUtility.resolveProxies(toPlacement_i.getOutsideBoundaryElement());
								EObject outside_j = EngineUtility.resolveProxies(toPlacement_j.getOutsideBoundaryElement());
								EList<EObject> inside_i = EngineUtility.resolveProxies(toPlacement_i.getInsideBoundaryElement());
								EList<EObject> inside_j = EngineUtility.resolveProxies(toPlacement_j .getInsideBoundaryElement());
								if(outside_i.equals(outside_j) && inside_i.size() == inside_j.size() &&
										Sets.symmetricDifference(new HashSet<EObject>(inside_i),
												new HashSet<EObject>(inside_j)).isEmpty()){
									toPlacements_i_j.put(toPlacement_i, toPlacement_j);
									toPlacements_j_i.put(toPlacement_j, toPlacement_i);
									break;
								}
								
							}
							if(boundary_i instanceof FromPlacement && boundary_j instanceof FromPlacement){
								FromPlacement fromPlacement_i = (FromPlacement) boundary_i;
								FromPlacement fromPlacement_j = (FromPlacement) boundary_j;
								
								if(EngineUtility.isDummyFromPlacement(fromPlacement_i) || EngineUtility.isDummyFromPlacement(fromPlacement_i))
									break;
								
								EObject inside_i = EngineUtility.resolveProxies(fromPlacement_i.getInsideBoundaryElement());
								EObject inside_j = EngineUtility.resolveProxies(fromPlacement_j.getInsideBoundaryElement());
								EList<EObject> outside_i = EngineUtility.resolveProxies(fromPlacement_i.getOutsideBoundaryElement());
								EList<EObject> outside_j = EngineUtility.resolveProxies(fromPlacement_j.getOutsideBoundaryElement());
								if(inside_i.equals(inside_j) && outside_i.size() == outside_j.size() &&
										Sets.symmetricDifference(new HashSet<EObject>(outside_i),
												new HashSet<EObject>(outside_j)).isEmpty()){
									fromPlacements_i_j.put(fromPlacement_i, fromPlacement_j);
									fromPlacements_j_i.put(fromPlacement_j, fromPlacement_i);
									break;
								}
								
							}
						}
					}
				
					fragment_i.addTwinBoundariesForFragment(fragment_j, toPlacements_i_j, fromPlacements_i_j);
					fragment_j.addTwinBoundariesForFragment(fragment_i, toPlacements_j_i, fromPlacements_j_i);
				}
			}
		}
	}

}
