package no.sintef.cvl.engine.containment;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;

import no.sintef.cvl.engine.common.EngineUtility;
import no.sintef.cvl.engine.error.IncorrectCVLModel;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;

public class ReplacPlacCotainmentFinder {

	private Collection<FragmentSubstitutionHolder> fragments;
	private HashMap<PlacementFragment, HashSet<EObject>> placementStaleElements;
	private HashMap<FragmentSubstitutionHolder, HashSet<FragmentSubstitutionHolder>> replcmntPlcmntHolderMap;
	private HashMap<FragmentSubstitutionHolder, HashSet<FragmentSubstitutionHolder>> plcmntReplcmntHolderMap;
	private HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>> adjacentToBoundaries;
	private HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>> adjacentFromBoundaries;
	
	public ReplacPlacCotainmentFinder(Collection<FragmentSubstitutionHolder> collection){
		fragments = collection;
		placementStaleElements = new HashMap<PlacementFragment, HashSet<EObject>>();
		replcmntPlcmntHolderMap = new HashMap<FragmentSubstitutionHolder, HashSet<FragmentSubstitutionHolder>>();
		plcmntReplcmntHolderMap = new HashMap<FragmentSubstitutionHolder, HashSet<FragmentSubstitutionHolder>>();
		adjacentToBoundaries = new HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>>();
		adjacentFromBoundaries = new HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>>();
		caluclateIntersections();
		findAdjacentBoundaries();
	}
	
	
	private void caluclateIntersections(){
		EList<FragmentSubstitutionHolder> pFragments = new BasicEList<FragmentSubstitutionHolder>(fragments);
		for(FragmentSubstitutionHolder rHolder : fragments){
			ReplacementFragmentType replacement = rHolder.getReplacement().getReplacementFragment();
			for(FragmentSubstitutionHolder pHolder : pFragments){
				PlacementFragment placement = pHolder.getPlacement().getPlacementFragment();
				int result = EngineUtility.testPlacementIntersection(replacement, placement);
				if(result == EngineUtility.P_CNTND)
					throw new IncorrectCVLModel("placement is partially contained in replacement, can not handle");
				
				if(result == EngineUtility.CNTND){
					if(placementStaleElements.get(placement) == null)
						placementStaleElements.put(placement, new HashSet<EObject>(pHolder.getPlacement().getElements()));
				
					HashSet<FragmentSubstitutionHolder> plcmntList = replcmntPlcmntHolderMap.get(rHolder);
					if(plcmntList == null){
						plcmntList = new HashSet<FragmentSubstitutionHolder>();
						plcmntList.add(pHolder);
						replcmntPlcmntHolderMap.put(rHolder, plcmntList);
					}else{
						plcmntList.add(pHolder);
					}
					
					HashSet<FragmentSubstitutionHolder> replcmList = plcmntReplcmntHolderMap.get(pHolder);
					if(replcmList == null){
						replcmList = new HashSet<FragmentSubstitutionHolder>();
						replcmList.add(rHolder);
						plcmntReplcmntHolderMap.put(pHolder, replcmList);
					}else{
						replcmList.add(rHolder);
					}
				}
			}
		}
	}
	
	private void findAdjacentBoundaries(){
		for(Map.Entry<FragmentSubstitutionHolder, HashSet<FragmentSubstitutionHolder>> entry : plcmntReplcmntHolderMap.entrySet()){
			PlacementFragment placement = entry.getKey().getPlacement().getPlacementFragment();
			HashSet<ReplacementFragmentType> replacements = collectReplacementFragments(entry.getValue());
			
			EList<PlacementBoundaryElement> pBoundaries = placement.getPlacementBoundaryElement();
			for(ReplacementFragmentType replacement : replacements){
				EList<ReplacementBoundaryElement> rBoundaries = replacement.getReplacementBoundaryElement();
				for(PlacementBoundaryElement pBoundary : pBoundaries){
					if(pBoundary instanceof ToPlacement){
						ToPlacement toPlacement = (ToPlacement) pBoundary;
						for(ReplacementBoundaryElement rBoundary : rBoundaries){
							if(rBoundary instanceof ToReplacement){
								ToReplacement toReplacement = (ToReplacement) rBoundary;
								if(isToBoundaryAdjacent(toPlacement, toReplacement)){
									HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>> replacementBoundaryMap = adjacentToBoundaries.get(placement);
									if(replacementBoundaryMap == null){
										replacementBoundaryMap = new HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>();
										HashMap<ToPlacement, HashSet<ToReplacement>> toBoundaryMap = new HashMap<ToPlacement, HashSet<ToReplacement>>();
										replacementBoundaryMap.put(replacement, toBoundaryMap);
										adjacentToBoundaries.put(placement, replacementBoundaryMap);
									}
									HashMap<ToPlacement, HashSet<ToReplacement>> toBoundaryMap = replacementBoundaryMap.get(replacement);
									HashSet<ToReplacement> toReplacements = toBoundaryMap.get(toPlacement);
									if(toReplacements == null){
										toReplacements = new HashSet<ToReplacement>();
										toBoundaryMap.put(toPlacement, toReplacements);
									}
									toReplacements.add(toReplacement);
								}
							}
						}
					}
					if(pBoundary instanceof FromPlacement){
						FromPlacement fromPlacement = (FromPlacement) pBoundary;
						for(ReplacementBoundaryElement rBoundary : rBoundaries){
							if(rBoundary instanceof FromReplacement){
								FromReplacement fromReplacement = (FromReplacement) rBoundary;
								if(isFromBoundaryAdjacent(fromPlacement, fromReplacement)){
									HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>> replacementBoundaryMap = adjacentFromBoundaries.get(placement);
									if(replacementBoundaryMap == null){
										replacementBoundaryMap = new HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>();
										HashMap<FromPlacement, HashSet<FromReplacement>> fromBoundaryMap = new HashMap<FromPlacement, HashSet<FromReplacement>>();
										replacementBoundaryMap.put(replacement, fromBoundaryMap);
										adjacentFromBoundaries.put(placement, replacementBoundaryMap);
									}
									HashMap<FromPlacement, HashSet<FromReplacement>> fromBoundaryMap = replacementBoundaryMap.get(replacement);
									HashSet<FromReplacement> fromReplacements = fromBoundaryMap.get(fromPlacement);
									if(fromReplacements == null){
										fromReplacements = new HashSet<FromReplacement>();
										fromBoundaryMap.put(fromPlacement, fromReplacements);
									}
									fromReplacements.add(fromReplacement);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private HashSet<ReplacementFragmentType> collectReplacementFragments(HashSet<FragmentSubstitutionHolder> fragmentHolders){
		HashSet<ReplacementFragmentType> replacements = new HashSet<ReplacementFragmentType>();
		for(FragmentSubstitutionHolder holder : fragmentHolders){
			replacements.add(holder.getReplacement().getReplacementFragment());
		}
		return replacements;
	}
	
	private boolean isToBoundaryAdjacent(ToPlacement toPlacement, ToReplacement toReplacement){
		if(toPlacement.getOutsideBoundaryElement().getMOFRef().equals(toReplacement.getOutsideBoundaryElement().getMOFRef())){
			EList<EObject> insideBoundaryPlacement = EngineUtility.resolveProxies(toPlacement.getInsideBoundaryElement());
			EList<EObject> insideBoundaryReplacement = EngineUtility.resolveProxies(toReplacement.getInsideBoundaryElement());
			SetView<EObject> intersection = Sets.intersection(new HashSet<EObject>(insideBoundaryPlacement), new HashSet<EObject>(insideBoundaryReplacement));
			if(!intersection.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isFromBoundaryAdjacent(FromPlacement fromPlacement, FromReplacement fromReplacement){
		if(fromReplacement.getInsideBoundaryElement().getMOFRef().equals(fromPlacement.getInsideBoundaryElement().getMOFRef())){
			EList<EObject> outsideBoundaryPlacement = EngineUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
			EList<EObject> outsideBoundaryReplacement = EngineUtility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
			SetView<EObject> intersection = Sets.intersection(new HashSet<EObject>(outsideBoundaryPlacement), new HashSet<EObject>(outsideBoundaryReplacement));
			if(!intersection.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	public HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<ToPlacement, HashSet<ToReplacement>>>> getAdjacentToBoundaries(){
		return adjacentToBoundaries;
	}
	
	public HashMap<PlacementFragment, HashMap<ReplacementFragmentType, HashMap<FromPlacement, HashSet<FromReplacement>>>> getAdjacentFromBoundaries(){
		return adjacentFromBoundaries;
	}
	
	public HashMap<PlacementFragment, HashSet<EObject>> getPlacementStaleElements(){
		return placementStaleElements;
	}
}
