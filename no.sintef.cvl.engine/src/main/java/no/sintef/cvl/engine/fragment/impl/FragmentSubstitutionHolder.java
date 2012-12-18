package no.sintef.cvl.engine.fragment.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.BoundaryElementBinding;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.ToBinding;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class FragmentSubstitutionHolder implements FragSubHolder {

	private FragmentSubstitution fragment;
	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private EList<BoundaryElementBinding> bindings;
	private EList<ToBinding> toBinding;
	private EList<FromBinding> fromBinding;

	public FragmentSubstitutionHolder(FragmentSubstitution fs) {
		fragment = fs;
		placement = new PlacementElementHolder(fragment.getPlacement());
		replacement = new ReplacementElementHolder(fragment.getReplacement());
		bindings = fragment.getBoundaryElementBinding();
		toBinding = new BasicEList<ToBinding>();
		fromBinding = new BasicEList<FromBinding>();
		for(BoundaryElementBinding binding : bindings){
			if(binding instanceof ToBinding){
				toBinding.add((ToBinding) binding);
			}
			if(binding instanceof FromBinding){
				fromBinding.add((FromBinding) binding);
			}
		}
	}
	
	@Override
	public PlacementElementHolder getPlacement() {
		return placement;
	}

	@Override
	public ReplacementElementHolder getReplacement() {
		return replacement;
	}

	@Override
	public FragmentSubstitution getFragment() {
		return fragment;
	}

	@Override
	public EList<ToBinding> getToBindings() {
		return toBinding;
	}

	@Override
	public EList<FromBinding> getFromBinding() {
		return fromBinding;
	}

}
