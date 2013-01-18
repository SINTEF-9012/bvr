package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.BoundaryElementBinding;
import cvl.FromBinding;
import cvl.ToBinding;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentFragmentImpl implements AdjacentFragment {

	private FragSubHolder fragmentHolder;
	private EList<AdjacentFragment> adjacentFragments;
	private HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>> adjacentBindings;
	private HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>> adjacentBindingsRev;

	public AdjacentFragmentImpl(FragSubHolder fragmentHolder){
		this.fragmentHolder = fragmentHolder;
		adjacentFragments = new BasicEList<AdjacentFragment>();
		adjacentBindings = new HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>>();
		adjacentBindingsRev = new HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>>();
	}
		
	@Override
	public FragSubHolder getFragmentHolder() {
		return this.fragmentHolder;
	}

	@Override
	public EList<AdjacentFragment> getAdjacentFragments() {
		return this.adjacentFragments;
	}

	@Override
	public void setAdjacentFragment(AdjacentFragment adjacentFragment) {
		this.adjacentFragments.add(adjacentFragment);
	}

	@Override
	public HashMap<FromBinding, ToBinding> getAdjacentBindings(AdjacentFragment adjacentFragment) {
		return this.adjacentBindings.get(adjacentFragment);
	}

	@Override
	public void setAdjacentBindings(AdjacentFragment adjacentFragment, HashMap<FromBinding, ToBinding> adjacentBindings) {
		this.adjacentBindings.put(adjacentFragment, adjacentBindings);		
	}

	@Override
	public HashMap<ToBinding, FromBinding> getAdjacentBindingsRev(AdjacentFragment adjacentFragment) {
		return this.adjacentBindingsRev.get(adjacentFragment);
	}

	@Override
	public void setAdjacentBindingsRev(AdjacentFragment adjacentFragment, HashMap<ToBinding, FromBinding> adjacentBindings) {
		this.adjacentBindingsRev.put(adjacentFragment, adjacentBindings);
	}

}
