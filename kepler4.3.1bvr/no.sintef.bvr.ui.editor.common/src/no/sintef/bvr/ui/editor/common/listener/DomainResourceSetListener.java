package no.sintef.bvr.ui.editor.common.listener;


import java.util.List;

import no.sintef.bvr.ui.editor.common.observer.ResourceSetEditorSubject;
import no.sintef.bvr.ui.editor.common.observer.EditorSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceSubjectMap;

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
				URI resourceURI = eObject.eResource().getURI();
				List<EditorSubject> subjects = ResourceSubjectMap.eINSTANCE.getSubjects(resourceURI);
				if(subjects != null){
					for(EditorSubject subject : subjects){
						if(subject instanceof ResourceSetEditorSubject){
							((ResourceSetEditorSubject) subject).setResourceSetChangeEvent(event);
						}	
					}
					ResourceSubjectMap.eINSTANCE.pokeResourceSubjects(resourceURI);
				}
			}
		}
		
	}
}
