package no.sintef.bvr.ui.editor.mvc.realization.listeners;

import no.sintef.bvr.ui.editor.mvc.realization.observer.RealizationResourceSetSubject;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

public class RealizationResourceSetListener extends ResourceSetListenerImpl {
	
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		RealizationResourceSetSubject.eINSTANCE.setResourceSetChangeEvent(event);
		RealizationResourceSetSubject.eINSTANCE.notifyObservers();
	}

}
