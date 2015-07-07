/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.fragment.impl;

import java.util.HashSet;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;
import no.sintef.bvr.engine.interfaces.fragment.IReplacementElementHolder;
import no.sintef.bvr.engine.interfaces.strategy.IReplacementElementFinderStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.FromReplacement;
import bvr.ReplacementFragmentType;
import bvr.ToReplacement;


public class ReplacementElementHolder extends BasicElementHolder implements IReplacementElementHolder {
	
	protected EList<ToReplacement> tbe;
	protected EList<FromReplacement> fbe;
	protected HashSet<EObject> outerElements;
	protected HashSet<EObject> innerElements;
	private ReplacementFragmentType replacement;
	private IReplacementElementFinderStrategy elementFinder;

	public ReplacementElementHolder(ReplacementFragmentType rft) throws BasicBVREngineException {
		elementFinder = new StrategyReplacementElementFinder();
		replacement = rft;
		this.locate();
	}
	
	@Override
	public void update() throws BasicBVREngineException{
		this.locate();
	}

	@Override
	protected void locate() throws BasicBVREngineException{
		super.locate();
		outerElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		tbe = new BasicEList<ToReplacement>();
		fbe = new BasicEList<FromReplacement>();
		
		IHolderDataElement data = elementFinder.locateReplacementElements(replacement.getReplacementBoundaryElement());
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
	
	@Override
	public ReplacementFragmentType getReplacementFragment(){
		return replacement;
	}

	@Override
	public HashSet<EObject> getInnerFragmentElements() {
		return getElements();
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
		HashSet<EObject> elements = new HashSet<EObject>();
		elements.addAll(outerElements);
		elements.addAll(frElementsOriginal);
		return elements;
	}
}
