package no.sintef.bvr.engine.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface ElementHolderOIF {

	public HashSet<EObject> getInnerNeighboringElements();
	
	public HashSet<EObject> getOuterNeighboringElements();
	
	public HashSet<EObject> getInnerFragmentElements();
	
	public HashSet<EObject> getOuterFragmentElements();
	
}
