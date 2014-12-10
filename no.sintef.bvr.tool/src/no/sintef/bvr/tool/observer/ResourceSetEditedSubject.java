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
package no.sintef.bvr.tool.observer;


import java.util.HashSet;
import java.util.Iterator;

import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.model.BVRToolModel;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

public class ResourceSetEditedSubject implements ResourceSubject {

	protected HashSet<ResourceObserver> observers = new HashSet<ResourceObserver>();
	protected HashSet<ResourceObserver> obsolete = new HashSet<ResourceObserver>();
	protected ResourceSetChangeEvent event;
	protected BVRToolModel model;
	
	public ResourceSetEditedSubject(BVRToolModel model) {
		this.model = model;
	}
	
	@Override
	public void attach(ResourceObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(ResourceObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<ResourceObserver> iter = observers.iterator();
		while(iter.hasNext()) {
			ResourceObserver o = iter.next();
			if(!obsolete.contains(o)) {
				o.update(this);
			} else {
				iter.remove();
			}
		}
	}

	public void setResourceSetChangeEvent(ResourceSetChangeEvent e){
		event = e;
	}
	
	public ResourceSetChangeEvent getResourceSetChangeEvent(){
		return event;
	}
	
	public void markObseleteObsever(ResourceObserver observer) {
		if(observers.contains(observer))
			obsolete.add(observer);
	}

}
