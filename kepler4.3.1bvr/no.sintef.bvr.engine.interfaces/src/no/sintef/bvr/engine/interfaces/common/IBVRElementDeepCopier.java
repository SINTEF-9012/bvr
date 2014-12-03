package no.sintef.bvr.engine.interfaces.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public interface IBVRElementDeepCopier {

	public void copyElements(Collection<EObject> eObjects);
	
	public EObject get(EObject eObject);
}
