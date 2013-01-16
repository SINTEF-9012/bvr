package no.sintef.cvl.engine.adjacent;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.engine.fragment.FragSubHolder;

public interface AdjacentFragment {

	public FragSubHolder getFragmentHolder();
	
	public EList<AdjacentFragment> getAdjacentFragments();
	
	public void setAdjacentFragment(AdjacentFragment adjacentFragment);
	
}
