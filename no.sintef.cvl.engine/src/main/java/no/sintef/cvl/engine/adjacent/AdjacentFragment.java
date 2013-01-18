package no.sintef.cvl.engine.adjacent;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;

import cvl.BoundaryElementBinding;
import cvl.FromBinding;
import cvl.ToBinding;

import no.sintef.cvl.engine.fragment.FragSubHolder;

public interface AdjacentFragment {

	public FragSubHolder getFragmentHolder();
	
	public EList<AdjacentFragment> getAdjacentFragments();
	
	public void setAdjacentFragment(AdjacentFragment adjacentFragment);
	
	public HashMap<FromBinding, ToBinding> getAdjacentBindings(AdjacentFragment adjacentFragment);
	
	public void setAdjacentBindings(AdjacentFragment adjacentFragment, HashMap<FromBinding, ToBinding> adjacentBindings);
	
	public HashMap<ToBinding, FromBinding> getAdjacentBindingsRev(AdjacentFragment adjacentFragment);
	
	public void setAdjacentBindingsRev(AdjacentFragment adjacentFragment, HashMap<ToBinding, FromBinding> adjacentBindings);
	
}
