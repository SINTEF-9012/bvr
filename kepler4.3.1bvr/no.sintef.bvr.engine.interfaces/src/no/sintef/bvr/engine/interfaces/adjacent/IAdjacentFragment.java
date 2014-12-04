package no.sintef.bvr.engine.interfaces.adjacent;

import java.util.HashMap;
import java.util.HashSet;

import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;

import org.eclipse.emf.common.util.EList;

import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.ToBinding;
import bvr.ToPlacement;


public interface IAdjacentFragment {

	public IFragSubHolder getFragmentHolder();
		
	public void setAdjacentFragment(IAdjacentFragment adjacentFragment);
	
	public HashMap<FromBinding, ToBinding> getAdjacentFromBindings(IAdjacentFragment adjacentFragment);
	
	public void setAdjacentFromBindings(IAdjacentFragment adjacentFragment, HashMap<FromBinding, ToBinding> adjacentBindings);
	
	public HashMap<ToBinding, FromBinding> getAdjacentToBindings(IAdjacentFragment adjacentFragment);
	
	public void setAdjacentToBindings(IAdjacentFragment adjacentFragment, HashMap<ToBinding, FromBinding> adjacentBindings);
	
	public HashMap<IAdjacentFragment, HashMap<FromBinding, ToBinding>> getAllAdjacentFromBindings();
	
	public HashMap<IAdjacentFragment, HashMap<ToBinding, FromBinding>> getAllAdjacentToBindings();

	public HashSet<IAdjacentFragment> getAdjacentFragments();
	
	public EList<IAdjacentFragment> getAdjacentFragmentsList();
	
	public void addTwinFragment(IAdjacentFragment adjacentFragment);
	
	public HashSet<IAdjacentFragment> getTwinFragments();
	
	public void addTwinBoundariesForFragment(IAdjacentFragment adjacentFragment, HashMap<ToPlacement, ToPlacement> toPlacementMap, HashMap<FromPlacement, FromPlacement> fromPlacementMap);
	
	public HashMap<ToPlacement, ToPlacement> getTwinToPlacement(IAdjacentFragment adjacentFragment);
	
	public HashMap<FromPlacement, FromPlacement> getTwinFromPlacement(IAdjacentFragment adjacentFragment);
	
}
