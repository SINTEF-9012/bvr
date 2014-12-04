package no.sintef.bvr.engine.interfaces.fragment;

import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.ToBinding;


public interface IFragSubHolder {

	public IPlacementElementHolder getPlacement();
	
	public IReplacementElementHolder getReplacement();
	
	public FragmentSubstitution getFragment();
	
	public EList<ToBinding> getToBindings();
	
	public EList<FromBinding> getFromBinding();
}
