package no.sintef.cvl.engine.fragment;

import org.eclipse.emf.common.util.EList;

import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.ToBinding;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;

public interface FragSubHolder {

	public PlacementElementHolder getPlacement();
	
	public ReplacementElementHolder getReplacement();
	
	public FragmentSubstitution getFragment();
	
	public EList<ToBinding> getToBindings();
	
	public EList<FromBinding> getFromBinding();
}
