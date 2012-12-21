package no.sintef.cvl.engine.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface ElementHolderOIF {

	public HashSet<EObject> getInnerFragmentElements();
	
	public HashSet<EObject> getOuterFragmentElements();
	
}
