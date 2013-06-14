package no.sintef.cvl.ui.common;

import org.eclipse.emf.ecore.EObject;

public interface ModelSelector {

	public void highlightObject(EObject eObject, int type);
	
	public void clearHighlighting(EObject eObject);
	
	public EObject getEObject(Object object);
	
}
