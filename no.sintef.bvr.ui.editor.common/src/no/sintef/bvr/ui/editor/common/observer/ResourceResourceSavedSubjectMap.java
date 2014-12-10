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
package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;

import org.eclipse.emf.common.util.URI;

public final class ResourceResourceSavedSubjectMap extends AbstractResourceSubjectMap {
		
	public static final ResourceResourceSavedSubjectMap eINSTANCE = getInstance();
	
	private static ResourceResourceSavedSubjectMap getInstance(){
		return new ResourceResourceSavedSubjectMap();
	}

	private ResourceResourceSavedSubjectMap(){
		subjects = new HashMap<URI, List<ResourceSubject>>();
	}
	
	public ResourceSavedSubject testResourceSavedSubject(URI resourceURI){
		List<ResourceSubject> subjs = subjects.get(resourceURI);
		if(subjs != null)
			return (ResourceSavedSubject) subjs.get(0);
		subjs = new ArrayList<ResourceSubject>();
		subjs.add(new ResourceSavedSubject());
		subjects.put(resourceURI, subjs);
		return (ResourceSavedSubject) subjs.get(0);
	}
	
	public List<URI> getReqisteredURIResources(){
		return new ArrayList<URI>(subjects.keySet());
	}
}
