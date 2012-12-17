package no.sintef.cvl.engine.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class CVLFragmentCopier extends Copier {
	
	// do not copy an object if it has been already copied, useful for the way we represent a fragment as a simple
	// list of all object
	
	private static final long serialVersionUID = 2457702231922299629L;
	
	@Override
	public EObject copy(EObject eObject){
		EObject copyEObject = get(eObject);
		return (copyEObject != null) ? copyEObject : super.copy(eObject);
	}

}
