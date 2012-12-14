package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.PlacementBoundaryElement;
import cvl.ToPlacement;

public class BasicPlacementElementHolder extends BasicElementHolder {

	protected EList<ToPlacement> tbe;
	protected EList<FromPlacement> fbe;
	private HashSet<EObject> vVertices;
	
	public BasicPlacementElementHolder(FragmentSubstitution f) {
		super(f);
		vVertices = new HashSet<EObject>();
		this.locate();
	}
	
	public void locate(){
		super.locate();
		tbe = new BasicEList<ToPlacement>();
		fbe = new BasicEList<FromPlacement>();
		
		EList<PlacementBoundaryElement> pbes = fragment.getPlacement().getPlacementBoundaryElement();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				frBElementsInternal.addAll(((ToPlacement)pbe).getInsideBoundaryElement());
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				frBElementsExternal.add(((FromPlacement)pbe).getInsideBoundaryElement());
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
		if(!vVertices.contains(element) && !frBElementsExternal.contains(element)){
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
}
