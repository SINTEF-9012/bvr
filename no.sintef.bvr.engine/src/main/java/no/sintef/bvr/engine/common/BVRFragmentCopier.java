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

import java.util.Collection;

import no.sintef.bvr.engine.interfaces.common.IBVRFragmentCopier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class BVRFragmentCopier extends Copier implements IBVRFragmentCopier {
	
	// do not copy an object if it has been already copied, useful for the way we represent a fragment as a simple
	// list of all object
	
	private static final long serialVersionUID = 2457702231922299629L;
	private Collection<EObject> fragElements;
		
	@Override
	public EObject copy(EObject eObject){
		if(!fragElements.contains(eObject)){
			//do not copy an object(just return the same) if it does not have belong to a copied fragment
			//it happens because the behavior is to copy containing objects,
			//we do no need this for objects which are contained and outside the defined fragment
			return eObject;
		}
		EObject copyEObject = get(eObject);
		return (copyEObject != null) ? copyEObject : super.copy(eObject);
	}
	
	@Override
	public void copyFragment(Collection<EObject> eObjects){
		fragElements = eObjects;
		this.copyAll(eObjects);
		this.copyReferences();
	}

}
