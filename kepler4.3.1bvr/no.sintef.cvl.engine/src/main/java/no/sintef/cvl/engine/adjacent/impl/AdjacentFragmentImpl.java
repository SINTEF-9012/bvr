package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.ToBinding;
import cvl.ToPlacement;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentFragmentImpl implements AdjacentFragment {

	private FragSubHolder fragmentHolder;
	private HashSet<AdjacentFragment> adjacentFragments;
	private HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>> adjacentFromBindings;
	private HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>> adjacentToBindings;
	private HashSet<AdjacentFragment> twins;
	private HashMap<AdjacentFragment, HashMap<ToPlacement, ToPlacement>> twinsToPlacement;
	private HashMap<AdjacentFragment, HashMap<FromPlacement, FromPlacement>> twinsFromPlacement;

	public AdjacentFragmentImpl(FragSubHolder fragmentHolder){
		this.fragmentHolder = fragmentHolder;
		adjacentFragments = new HashSet<AdjacentFragment>();
		adjacentFromBindings = new HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>>();
		adjacentToBindings = new HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>>();
		twins = new HashSet<AdjacentFragment>();
		twinsToPlacement = new HashMap<AdjacentFragment, HashMap<ToPlacement, ToPlacement>>();
		twinsFromPlacement = new HashMap<AdjacentFragment, HashMap<FromPlacement, FromPlacement>>();
	}
		
	@Override
	public FragSubHolder getFragmentHolder() {
		return this.fragmentHolder;
	}

	@Override
	public HashSet<AdjacentFragment> getAdjacentFragments() {
		return this.adjacentFragments;
	}
	
	@Override
	public EList<AdjacentFragment> getAdjacentFragmentsList() {
		return new BasicEList<AdjacentFragment>(this.adjacentFragments);
	}

	@Override
	public void setAdjacentFragment(AdjacentFragment adjacentFragment) {
		if(this.adjacentFragments.contains(adjacentFragment))
			return;
		this.adjacentFragments.add(adjacentFragment);
	}

	@Override
	public HashMap<FromBinding, ToBinding> getAdjacentFromBindings(AdjacentFragment adjacentFragment) {
		return this.adjacentFromBindings.get(adjacentFragment);
	}

	@Override
	public void setAdjacentFromBindings(AdjacentFragment adjacentFragment, HashMap<FromBinding, ToBinding> adjacentBindings) {
		this.adjacentFromBindings.put(adjacentFragment, adjacentBindings);		
	}

	@Override
	public HashMap<ToBinding, FromBinding> getAdjacentToBindings(AdjacentFragment adjacentFragment) {
		return this.adjacentToBindings.get(adjacentFragment);
	}

	@Override
	public void setAdjacentToBindings(AdjacentFragment adjacentFragment, HashMap<ToBinding, FromBinding> adjacentBindings) {
		this.adjacentToBindings.put(adjacentFragment, adjacentBindings);
	}

	@Override
	public HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>> getAllAdjacentFromBindings() {
		return this.adjacentFromBindings;
	}

	@Override
	public HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>> getAllAdjacentToBindings() {
		return this.adjacentToBindings;
	}

	@Override
	public void addTwinFragment(AdjacentFragment adjacentFragment) {
		twins.add(adjacentFragment);
	}

	@Override
	public HashSet<AdjacentFragment> getTwinFragments() {
		return twins;
	}

	@Override
	public void addTwinBoundariesForFragment(AdjacentFragment adjacentFragment,
			HashMap<ToPlacement, ToPlacement> toPlacementMap,
			HashMap<FromPlacement, FromPlacement> fromPlacementMap) {
		twinsToPlacement.put(adjacentFragment, toPlacementMap);
		twinsFromPlacement.put(adjacentFragment, fromPlacementMap);
	}

	@Override
	public HashMap<ToPlacement, ToPlacement> getTwinToPlacement(
			AdjacentFragment adjacentFragment) {
		return twinsToPlacement.get(adjacentFragment);
	}

	@Override
	public HashMap<FromPlacement, FromPlacement> getTwinFromPlacement(
			AdjacentFragment adjacentFragment) {
		return twinsFromPlacement.get(adjacentFragment);
	}

}
