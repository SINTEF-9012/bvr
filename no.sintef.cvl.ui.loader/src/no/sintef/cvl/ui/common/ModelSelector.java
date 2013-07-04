package no.sintef.cvl.ui.common;

import java.util.HashMap;
import java.util.List;

import no.sintef.cvl.ui.exception.NoEclipseDetectedException;

import org.eclipse.emf.ecore.EObject;

public interface ModelSelector {

	public void highlightObjects(final HashMap<EObject, Integer> objects) throws NoEclipseDetectedException;
	
	public void clearHighlights() throws NoEclipseDetectedException;
	
	public EObject getEObject(Object object);
	
	public List<Object> getSelections() throws NoEclipseDetectedException;
}
