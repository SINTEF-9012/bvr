package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.fragment.ElementHolderOIF;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FromReplacement;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;

public class ReplacementElementHolder extends BasicElementHolder implements ElementHolderOIF {
	
	protected EList<ToReplacement> tbe;
	protected EList<FromReplacement> fbe;
	protected HashSet<EObject> outerElements;
	protected HashSet<EObject> innerElements;
	private HashSet<EObject> vVertices;
	private ReplacementFragmentType replacement;

	public ReplacementElementHolder(ReplacementFragmentType rft) throws BasicCVLEngineException {
		replacement = rft;
		this.locate();
	}
	
	public void update() throws BasicCVLEngineException{
		this.locate();
	}

	@Override
	protected void locate() throws BasicCVLEngineException{
		super.locate();
		vVertices = new HashSet<EObject>();
		outerElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		tbe = new BasicEList<ToReplacement>();
		fbe = new BasicEList<FromReplacement>();
		
		EList<ReplacementBoundaryElement> rbes = replacement.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement rbe : rbes){
			if(rbe instanceof ToReplacement){
				tbe.add((ToReplacement)rbe);
				EList<EObject> insideBoundaryElements = Utility.resolveProxies(((ToReplacement)rbe).getInsideBoundaryElement());
				EObject outsideBoundaryElement = Utility.resolveProxies(((ToReplacement)rbe).getOutsideBoundaryElement());
				frBElementsInternal.addAll(insideBoundaryElements);
				frNeighboringInsideElements.add(outsideBoundaryElement);
				outerElements.add(outsideBoundaryElement);
				innerElements.addAll(insideBoundaryElements);
			}
			if(rbe instanceof FromReplacement){
				fbe.add((FromReplacement) rbe);
				EObject insideBoundaryElement = Utility.resolveProxies(((FromReplacement)rbe).getInsideBoundaryElement());
				EList<EObject> outsideBoundaryElements = Utility.resolveProxies(((FromReplacement)rbe).getOutsideBoundaryElement());
				frBElementsExternal.add(insideBoundaryElement);
				frNeighboringOutsideElements.addAll(outsideBoundaryElements);
				outerElements.addAll(outsideBoundaryElements);
				innerElements.add(insideBoundaryElement);
			}
		}
		this.calculatePlElementsInternal();
		frElementsOriginal.addAll(frBElementsExternal);
		frElementsOriginal.addAll(frBElementsInternal);
		frElementsOriginal.addAll(frElementsInternal);
	}
	
	private void calculatePlElementsInternal(){
		for(EObject element : frBElementsInternal){
			this.traversRelation(element);
		}
	}
	
	private void traversRelation(EObject element) {
		if(!vVertices.contains(element) && !frBElementsExternal.contains(element) && !outerElements.contains(element)){
			vVertices.add(element);
			if(!frBElementsInternal.contains(element)){
				frElementsInternal.add(element);
			}
			EList<EObject> references = element.eCrossReferences();
			for(EObject ref : references){
				this.traversRelation(ref);
			}
			EList<EObject> contents = element.eContents();
			for(EObject con : contents){
				this.traversRelation(con);
			}
		}
		
	}

	@Override
	public HashSet<EObject> getInnerNeighboringElements() {
		return innerElements;
	}

	@Override
	public HashSet<EObject> getOuterNeighboringElements() {
		return outerElements;
	}
	
	public EList<ToReplacement> getToReplacementBoundaries(){
		return tbe;
	}
	
	public EList<FromReplacement> getFromReplacementBoundaries(){
		return fbe;
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
