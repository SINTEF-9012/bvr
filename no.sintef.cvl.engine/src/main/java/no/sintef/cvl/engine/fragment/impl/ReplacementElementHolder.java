package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import no.sintef.cvl.engine.common.HolderDataElement;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.fragment.ElementHolderOIF;
import no.sintef.cvl.engine.fragment.ReplacementElementFinderStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


import cvl.FromReplacement;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;

public class ReplacementElementHolder extends BasicElementHolder implements ElementHolderOIF {
	
	protected EList<ToReplacement> tbe;
	protected EList<FromReplacement> fbe;
	protected HashSet<EObject> outerElements;
	protected HashSet<EObject> innerElements;
	private ReplacementFragmentType replacement;
	private ReplacementElementFinderStrategy elementFinder;

	public ReplacementElementHolder(ReplacementFragmentType rft) throws BasicCVLEngineException {
		elementFinder = new StrategyReplacementElementFinder();
		replacement = rft;
		this.locate();
	}
	
	public void update() throws BasicCVLEngineException{
		this.locate();
	}

	@Override
	protected void locate() throws BasicCVLEngineException{
		super.locate();
		outerElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		tbe = new BasicEList<ToReplacement>();
		fbe = new BasicEList<FromReplacement>();
		
		HolderDataElement data = elementFinder.locateReplacementElements(replacement.getReplacementBoundaryElement());
		frBElementsInternal.addAll(data.getBoundaryElementsInternal());
		frBElementsExternal.addAll(data.getBoundaryElementsExternal());
		frNeighboringInsideElements.addAll(data.getOuterInsideReferenceElements());
		frNeighboringOutsideElements.addAll(data.getOuterOutsideReferenceElements());
		innerElements.addAll(data.getInnerNeighboringElements());
		outerElements.addAll(data.getOuterNeighboringElements());
		frElementsInternal.addAll(data.getInnerElements());
		
		frElementsOriginal.addAll(frBElementsExternal);
		frElementsOriginal.addAll(frBElementsInternal);
		frElementsOriginal.addAll(frElementsInternal);
		
	}

	@Override
	public HashSet<EObject> getInnerNeighboringElements() {
		return innerElements;
	}

	@Override
	public HashSet<EObject> getOuterNeighboringElements() {
		return outerElements;
	}
	
	
	public ReplacementFragmentType getReplacementFragment(){
		return replacement;
	}

	@Override
	public HashSet<EObject> getInnerFragmentElements() {
		return frElementsOriginal;
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
		HashSet<EObject> elements = new HashSet<EObject>();
		elements.addAll(outerElements);
		elements.addAll(frElementsOriginal);
		return elements;
	}
}
