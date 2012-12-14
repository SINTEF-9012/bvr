package no.sintef.cvl.engine.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import cvl.FragmentSubstitution;

public interface ElementHolder {

	public HashSet<EObject> getElements();
	
	public HashSet<EObject> getBElementsInternal();
	
	public HashSet<EObject> getBElementsExternal();
	
	public HashSet<EObject> getElementsInternal();
	
	public FragmentSubstitution getFragmentSubstitution();
	
	public void locate();
}
