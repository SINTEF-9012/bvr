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
package no.sintef.bvr.tool.subject;

import java.util.ArrayList;

import no.sintef.bvr.tool.context.ViewChanageManager;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public abstract class AbstractViewSubject implements Subject {
 
	protected ViewChanageManager changeManager = ViewChanageManager.getChangeManager();
	private String[] fields = {};
	
	@Override
	public void attach(Observer observer) {
		changeManager.register(this, observer);
	}

	@Override
	public void detach(Observer observer) {
		changeManager.unregister(this, observer);
	}

	@Override
	public void notifyObserver() {
		ArrayList<Observer> observers = changeManager.registeredObservers(this);
		if(observers != null){
			for(Observer observer : observers){
				observer.update(this);
			}
		}
	}
	
	@Override
	public boolean isApplicable(ObserverDataBulk data) {
		for(String field : getFileds()){
			if(data.isFieldSet(field))
				return true;
		}
		return false;
	}
	
	protected String[] getFileds(){
		return fields;
	}
}
