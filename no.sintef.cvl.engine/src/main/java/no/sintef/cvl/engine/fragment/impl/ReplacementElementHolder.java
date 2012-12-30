package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import no.sintef.cvl.engine.common.Utility;
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

	public ReplacementElementHolder(ReplacementFragmentType rft) {
		replacement = rft;
		this.locate();
	}

	@Override
	protected void locate(){
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
				frBElementsInternal.addAll(Utility.resolveProxies(((ToReplacement)rbe).getInsideBoundaryElement()));
				outerElements.add(Utility.resolveProxies(((ToReplacement)rbe).getOutsideBoundaryElement()));
				innerElements.addAll(Utility.resolveProxies(((ToReplacement)rbe).getInsideBoundaryElement()));
			}
			if(rbe instanceof FromReplacement){
				fbe.add((FromReplacement) rbe);
				frBElementsExternal.add(Utility.resolveProxies(((FromReplacement)rbe).getInsideBoundaryElement()));
				outerElements.addAll(Utility.resolveProxies(((FromReplacement)rbe).getOutsideBoundaryElement()));
				innerElements.add(Utility.resolveProxies(((FromReplacement)rbe).getInsideBoundaryElement()));
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
	public HashSet<EObject> getInnerFragmentElements() {
		return innerElements;
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
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
}
