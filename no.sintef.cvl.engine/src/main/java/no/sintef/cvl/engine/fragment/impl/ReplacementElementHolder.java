package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import cvl.FragmentSubstitution;
import cvl.FromReplacement;
import cvl.ToReplacement;

import no.sintef.cvl.engine.fragment.ElementHolderOIF;

public class ReplacementElementHolder extends BasicReplacementElementHolder
		implements ElementHolderOIF {

	private HashSet<EObject> outerElements;
	private HashSet<EObject> innerElements;

	public ReplacementElementHolder(FragmentSubstitution f) {
		super(f);
		innerElements = frElementsOriginal;
		outerElements = new HashSet<EObject>();
		for(ToReplacement tr : tbe){
			outerElements.add(tr.getOutsideBoundaryElement());
		}
		for(FromReplacement fr : fbe){
			outerElements.addAll(fr.getOutsideBoundaryElement());
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
