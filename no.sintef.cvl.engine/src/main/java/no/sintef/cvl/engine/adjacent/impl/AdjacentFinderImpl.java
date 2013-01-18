package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;
import java.util.HashSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.ToBinding;
import cvl.ToPlacement;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.fragment.FragSubHolder;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;

public class AdjacentFinderImpl implements AdjacentFinder {

	private EList<FragmentSubstitutionHolder> fragmentList;
	private HashMap<FragSubHolder, AdjacentFragment> adjacentMap;

	public AdjacentFinderImpl(EList<FragmentSubstitutionHolder> fragmentsList){
		this.fragmentList = new BasicEList<FragmentSubstitutionHolder>(fragmentsList);
		this.adjacentMap = new HashMap<FragSubHolder, AdjacentFragment>();
		this.findAdjacentness();
	}
	
	@Override
	public HashMap<FragSubHolder, AdjacentFragment> getAdjacentMap() {
		return this.adjacentMap;
	}
	
	private void findAdjacentness(){
		EList<FragSubHolder> viewedFragments = new BasicEList<FragSubHolder>();
		for(FragSubHolder fragmentHolder : this.fragmentList){
			viewedFragments.add(fragmentHolder);
			PlacementElementHolder placementHolder = fragmentHolder.getPlacement();
			SetView<FragSubHolder> toViewFragments = Sets.symmetricDifference(new HashSet<FragSubHolder>(this.fragmentList), new HashSet<FragSubHolder>(viewedFragments));
			for(FragSubHolder fragmentHolder1 : toViewFragments){
				PlacementElementHolder placementHolder1 = fragmentHolder1.getPlacement();
				if(this.isAdjacent(placementHolder, placementHolder1)){
					AdjacentFragment adjacentFragment = this.testAdjacentFragment(fragmentHolder);
					AdjacentFragment adjacentFragment1 = this.testAdjacentFragment((fragmentHolder1));
					adjacentFragment.setAdjacentFragment(adjacentFragment1);
					adjacentFragment1.setAdjacentFragment(adjacentFragment);
					
					HashMap<FromBinding, ToBinding> adjacentBindings = this.getAdjacentBindings(fragmentHolder, fragmentHolder1);
					adjacentFragment.setAdjacentBindings(adjacentFragment1, adjacentBindings);
					HashMap<ToBinding, FromBinding> adjacentBindingsRev = Utility.reverseMap(adjacentBindings);
					adjacentFragment1.setAdjacentBindingsRev(adjacentFragment, adjacentBindingsRev);
				}
			}
		}
	}
	
	private boolean isAdjacent(PlacementElementHolder placement, PlacementElementHolder placement1){
		HashSet<EObject> iP = placement.getInnerFragmentElements();
		HashSet<EObject> iP1 = placement1.getInnerFragmentElements();
		if(Sets.intersection(iP, iP1).isEmpty()){
			HashSet<EObject> oP = placement.getOuterFragmentElements();
			HashSet<EObject> oP1 = placement1.getOuterFragmentElements();
			if(!Sets.intersection(iP, oP1).isEmpty() || !Sets.intersection(iP1, oP).isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private AdjacentFragment testAdjacentFragment(FragSubHolder fragmentHolder){
		AdjacentFragment adjacentFragment = this.adjacentMap.get(fragmentHolder);
		if(adjacentFragment == null){
			adjacentFragment = new AdjacentFragmentImpl(fragmentHolder);
			this.adjacentMap.put(fragmentHolder, adjacentFragment);
		}
		return adjacentFragment;
	}
	
	private HashMap<FromBinding, ToBinding> getAdjacentBindings(FragSubHolder fragmentHolder, FragSubHolder fragmentHolder1){
		HashMap<FromBinding, ToBinding> boundariesMap = new HashMap<FromBinding, ToBinding>();
		EList<FromBinding> fromBindings = fragmentHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			ObjectHandle insideBoundaryElement = fromPlacement.getInsideBoundaryElement();
			EList<ObjectHandle> outsideBoundatyElements = fromPlacement.getOutsideBoundaryElement();
			EList<ToBinding> toBindings = fragmentHolder1.getToBindings();
			for(ToBinding toBinding : toBindings){
				ToPlacement toPlacement = toBinding.getToPlacement();
				ObjectHandle outsideBoundaryElement = toPlacement.getOutsideBoundaryElement();
				EList<ObjectHandle> insideBoundaryElements = toPlacement.getInsideBoundaryElement();
				if(insideBoundaryElement.equals(outsideBoundaryElement) && Sets.symmetricDifference(new HashSet<ObjectHandle>(outsideBoundatyElements), new HashSet<ObjectHandle>(insideBoundaryElements)).isEmpty()){
					boundariesMap.put(fromBinding, toBinding);
				}
			}
		}
		return boundariesMap;
	}

}
