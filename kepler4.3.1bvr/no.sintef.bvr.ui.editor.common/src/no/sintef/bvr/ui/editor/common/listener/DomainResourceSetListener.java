package no.sintef.bvr.ui.editor.common.listener;


import java.util.List;

import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.tool.observer.ResourceSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

public class DomainResourceSetListener extends ResourceSetListenerImpl {

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		List<Notification> notifications =  event.getNotifications();
		for(Notification notification : notifications){
			Object object = notification.getNotifier();
			if(object instanceof EObject){
				EObject eObject = (EObject) object;
				if(eObject.eResource() != null){
					URI resourceURI = eObject.eResource().getURI();
					List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
					if(subjects != null){
						for(ResourceSubject subject : subjects){
							if(subject instanceof ResourceSetEditedSubject){
								((ResourceSetEditedSubject) subject).setResourceSetChangeEvent(event);
							}	
						}
						ResourceResourceSetSubjectMap.eINSTANCE.pokeResourceSubjects(resourceURI);
					}
				}
			}
		}
		
	}
}
