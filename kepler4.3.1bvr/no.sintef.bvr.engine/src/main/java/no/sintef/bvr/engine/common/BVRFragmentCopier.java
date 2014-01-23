package no.sintef.bvr.engine.common;

import java.util.Collection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class CVLFragmentCopier extends Copier {
	
	// do not copy an object if it has been already copied, useful for the way we represent a fragment as a simple
	// list of all object
	
	private static final long serialVersionUID = 2457702231922299629L;
	private Collection<EObject> fragElements;
		
	@Override
	public EObject copy(EObject eObject){
		if(!fragElements.contains(eObject)){
			//do not copy an object(just return the same) if it does not have belong to a copied fragment
			//it happens because the behavior is to copy containing objects,
			//we do no need this for objects which are contained and outside the defined fragment
			return eObject;
		}
		EObject copyEObject = get(eObject);
		return (copyEObject != null) ? copyEObject : super.copy(eObject);
	}
	
	public void copyFragment(Collection<EObject> eObjects){
		fragElements = eObjects;
		this.copyAll(eObjects);
		this.copyReferences();
	}

}
