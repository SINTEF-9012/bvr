package no.sintef.bvr.ui.editor.mvc.vspec.listeners;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

import no.sintef.bvr.ui.editor.mvc.vspec.observer.VSpecResourseSetSubject;

public class VSpecResourceSetListener extends ResourceSetListenerImpl{
	
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		System.out.println("VSpecResourceSetListener.resourceSetChanged " + this);
		VSpecResourseSetSubject.eINSTANCE.setResourceSetChangeEvent(event);
		VSpecResourseSetSubject.eINSTANCE.notifyObservers();
	}
}
