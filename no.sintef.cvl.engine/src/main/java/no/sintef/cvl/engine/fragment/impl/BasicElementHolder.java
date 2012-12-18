package no.sintef.cvl.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import cvl.FragmentSubstitution;
import no.sintef.cvl.engine.fragment.ElementHolder;

public abstract class BasicElementHolder implements ElementHolder {

	protected HashSet<EObject> frElementsOriginal;
	protected HashSet<EObject> frBElementsInternal; 
	protected HashSet<EObject> frBElementsExternal;
	protected HashSet<EObject> frElementsInternal;
	
	@Override
	public HashSet<EObject> getElements() {
		return frElementsOriginal;
	}

	@Override
	public HashSet<EObject> getBElementsInternal() {
		return frBElementsInternal;
	}

	@Override
	public HashSet<EObject> getBElementsExternal() {
		return frBElementsExternal;
	}

	@Override
	public HashSet<EObject> getElementsInternal() {
		return frElementsInternal;
	}
		
	@Override
	public void locate() {
		frElementsOriginal = new HashSet<EObject>();
		frBElementsInternal = new HashSet<EObject>();
		frBElementsExternal = new HashSet<EObject>();
		frElementsInternal = new HashSet<EObject>();
	}

}
