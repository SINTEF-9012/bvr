package no.sintef.cvl.engine.adjacent.impl;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.FromBinding;
import cvl.ToBinding;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentFragmentImpl implements AdjacentFragment {

	private FragSubHolder fragmentHolder;
	private EList<AdjacentFragment> adjacentFragments;
	private HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>> adjacentFromBindings;
	private HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>> adjacentToBindings;

	public AdjacentFragmentImpl(FragSubHolder fragmentHolder){
		this.fragmentHolder = fragmentHolder;
		adjacentFragments = new BasicEList<AdjacentFragment>();
		adjacentFromBindings = new HashMap<AdjacentFragment, HashMap<FromBinding, ToBinding>>();
		adjacentToBindings = new HashMap<AdjacentFragment, HashMap<ToBinding, FromBinding>>();
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

}
