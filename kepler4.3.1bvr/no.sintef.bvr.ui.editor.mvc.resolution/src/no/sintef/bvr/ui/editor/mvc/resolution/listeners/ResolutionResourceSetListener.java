package no.sintef.bvr.ui.editor.mvc.resolution.listeners;

import no.sintef.bvr.ui.editor.mvc.resolution.observer.ResolutionResourceSetSubject;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

public class ResolutionResourceSetListener extends ResourceSetListenerImpl {

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		ResolutionResourceSetSubject.eINSTANCE.setResourceSetChangeEvent(event);
		ResolutionResourceSetSubject.eINSTANCE.notifyObservers();
	}
}
