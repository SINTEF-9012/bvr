package no.sintef.bvr.engine.interfaces.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public interface IBVRFragmentCopier {

	public EObject copy(EObject eObject);
	
	public void copyFragment(Collection<EObject> eObjects);
}
