/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.listener;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;

public class DomainResourceSetListener extends ResourceSetListenerImpl {

	HashSet<URI> changedResources;
	
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		changedResources = new HashSet<URI>();
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
						changedResources.add(resourceURI);
					}
				}
			}
		}
		
		//if resource has been changed several times we want to notify only once
		Iterator<URI> iterator = changedResources.iterator();
		while(iterator.hasNext())
			ResourceResourceSetSubjectMap.eINSTANCE.pokeResourceSubjects(iterator.next());
	}
}
