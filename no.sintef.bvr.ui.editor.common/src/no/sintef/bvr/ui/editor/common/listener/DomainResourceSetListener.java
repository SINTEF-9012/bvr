/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
