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
package no.sintef.bvr.engine.common;

import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ResourceContentCopier extends Copier implements IResourceContentCopier {

	private static final long serialVersionUID = -6292277081092094075L;
	
	private Resource originalResource;
	
	@Override
	public void copyResource(Resource resource){
		clear();
		setOriginalResource(resource);
		EList<EObject> contents = resource.getContents();
		copyAll(contents);
		copyReferences();
	}

	@Override
	public Resource getOriginalResource() {
		return originalResource;
	}

	private void setOriginalResource(Resource originalResource) {
		this.originalResource = originalResource;
	}

}
