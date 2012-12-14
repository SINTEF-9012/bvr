package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.BoundaryElementBinding;
import cvl.FragmentSubstitution;
import cvl.FromReplacement;
import cvl.ToReplacement;

public class BasicReplacementElementHolder extends BasicElementHolder {
	
	protected EList<ToReplacement> tbe;
	protected EList<FromReplacement> fbe;
	private HashSet<EObject> vVertices;

	public BasicReplacementElementHolder(FragmentSubstitution f) {
		super(f);
		vVertices = new HashSet<EObject>();
		this.locate();
	}

	public void locate(){
		super.locate();
		tbe = new BasicEList<ToReplacement>();
		fbe = new BasicEList<FromReplacement>();
		
		EList<BoundaryElementBinding> pbes = fragment.getBoundaryElementBinding();
		for(BoundaryElementBinding pbe : pbes){
			if(pbe instanceof ToReplacement){
				tbe.add((ToReplacement)pbe);
				frBElementsInternal.addAll(((ToReplacement)pbe).getInsideBoundaryElement());
			}
			if(pbe instanceof FromReplacement){
				fbe.add((FromReplacement) pbe);
				frBElementsExternal.add(((FromReplacement)pbe).getInsideBoundaryElement());
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

	@Override
	public FragmentSubstitution getFragmentSubstitution() {
		return fragment;
	}
}
