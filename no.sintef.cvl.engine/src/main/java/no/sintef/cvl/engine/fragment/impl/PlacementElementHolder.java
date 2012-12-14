package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import no.sintef.cvl.engine.fragment.ElementHolderOIF;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.PlacementBoundaryElement;
import cvl.ToPlacement;

public class PlacementElementHolder extends BasicElementHolder implements ElementHolderOIF {

	protected EList<ToPlacement> tbe;
	protected EList<FromPlacement> fbe;
	protected HashSet<EObject> innerElements;
	protected HashSet<EObject> outerElements;
	private HashSet<EObject> vVertices;
	
	public PlacementElementHolder(FragmentSubstitution f) {
		super(f);
		this.locate();
	}
		
	public void locate(){
		super.locate();
		vVertices = new HashSet<EObject>();
		outerElements = new HashSet<EObject>();
		tbe = new BasicEList<ToPlacement>();
		fbe = new BasicEList<FromPlacement>();
		
		EList<PlacementBoundaryElement> pbes = fragment.getPlacement().getPlacementBoundaryElement();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				frBElementsInternal.addAll(((ToPlacement)pbe).getInsideBoundaryElement());
				outerElements.add(((ToPlacement)pbe).getOutsideBoundaryElement());
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				frBElementsExternal.add(((FromPlacement)pbe).getInsideBoundaryElement());
				outerElements.addAll(((FromPlacement)pbe).getOutsideBoundaryElement());
			}
		}
		this.calculatePlElementsInternal();
		frElementsOriginal.addAll(frBElementsExternal);
		frElementsOriginal.addAll(frBElementsInternal);
		frElementsOriginal.addAll(frElementsInternal);
		innerElements = frElementsOriginal;
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
}
