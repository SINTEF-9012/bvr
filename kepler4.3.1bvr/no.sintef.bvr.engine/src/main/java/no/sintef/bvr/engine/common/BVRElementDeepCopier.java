package no.sintef.bvr.engine.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class BVRElementDeepCopier extends Copier {

	private static final long serialVersionUID = -3804582799895873560L;

	public void copyElements(Collection<EObject> eObjects){
		clear();
		copyAll(eObjects);
		copyReferences();
	}
}
