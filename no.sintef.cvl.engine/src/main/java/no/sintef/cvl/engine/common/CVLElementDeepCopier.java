package no.sintef.cvl.engine.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class CVLElementDeepCopier extends Copier {

	public void copyElements(Collection<EObject> eObjects){
		clear();
		copyAll(eObjects);
		copyReferences();
	}
}
