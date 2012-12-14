package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.ToPlacement;

import no.sintef.cvl.engine.fragment.ElementHolderOIF;

public class PlacementElementHolder extends BasicPlacementElementHolder
		implements ElementHolderOIF {

	private HashSet<EObject> innerElements;
	private HashSet<EObject> outerElements;

	public PlacementElementHolder(FragmentSubstitution f) {
		super(f);
		innerElements = frElementsOriginal;
		outerElements = new HashSet<EObject>();
		for(ToPlacement tp : tbe){
			outerElements.add(tp.getOutsideBoundaryElement());
		}
		for(FromPlacement fp : fbe){
			outerElements.addAll(fp.getOutsideBoundaryElement());
		}
	}

	@Override
	public HashSet<EObject> getInnerFragmentElements() {
		return innerElements;
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
		return outerElements;
	}

}
