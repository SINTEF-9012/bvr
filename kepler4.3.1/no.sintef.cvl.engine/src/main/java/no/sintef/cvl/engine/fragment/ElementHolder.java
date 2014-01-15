package no.sintef.cvl.engine.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface ElementHolder {

	public HashSet<EObject> getElements();
	
	public HashSet<EObject> getBElementsInternal();
	
	public HashSet<EObject> getBElementsExternal();
	
	public HashSet<EObject> getElementsInternal();
	
	//Elements referenced by outsideBoundaryElements and
	//pointing to elements inside a placement
	public HashSet<EObject> getNeighboringInsideElements();
	
	//Elements referenced by outsideBoundaryElements and
	//pointed by elements from a placement
	public HashSet<EObject> getNeighboringOutsideElements();
	
}
