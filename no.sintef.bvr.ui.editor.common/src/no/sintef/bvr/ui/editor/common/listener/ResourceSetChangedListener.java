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

import java.util.List;

import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;


public class ResourceSetChangedListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		List<URI> resources = ResourceResourceSavedSubjectMap.eINSTANCE.getReqisteredURIResources();
		for(URI resource : resources){
			if(!resource.isPlatformResource())
				throw new UnsupportedOperationException("resource is not a platform one " + resource);
			IPath path = new Path(resource.toPlatformString(true));
			IResourceDelta delta = event.getDelta().findMember(path);
			if(delta == null)
				continue;
			//only interested in changes resources(not added or removed) and content changes in the resource
			if((delta.getKind() == IResourceDelta.ALL_WITH_PHANTOMS) && ((delta.getFlags() != IResourceDelta.MARKERS))){
				ResourceResourceSavedSubjectMap.eINSTANCE.pokeResourceSubjects(resource);
			}
		}
	}

}
