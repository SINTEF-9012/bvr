package no.sintef.cvl.engine.adjacent.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class AdjacentFragmentImpl implements AdjacentFragment {

	private FragSubHolder fragmentHolder;
	private EList<AdjacentFragment> adjacentFragments;

	public AdjacentFragmentImpl(FragSubHolder fragmentHolder){
		this.fragmentHolder = fragmentHolder;
		adjacentFragments = new BasicEList<AdjacentFragment>();
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

}
