package no.sintef.bvr.engine.fragment;

import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.ToBinding;
import no.sintef.bvr.engine.fragment.impl.PlacementElementHolder;
import no.sintef.bvr.engine.fragment.impl.ReplacementElementHolder;

public interface FragSubHolder {

	public PlacementElementHolder getPlacement();
	
	public ReplacementElementHolder getReplacement();
	
	public FragmentSubstitution getFragment();
	
	public EList<ToBinding> getToBindings();
	
	public EList<FromBinding> getFromBinding();
}
