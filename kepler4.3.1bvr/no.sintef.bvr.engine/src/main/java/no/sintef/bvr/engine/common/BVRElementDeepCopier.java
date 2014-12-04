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

import no.sintef.bvr.engine.interfaces.common.IBVRElementDeepCopier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class BVRElementDeepCopier extends Copier implements IBVRElementDeepCopier {

	private static final long serialVersionUID = -3804582799895873560L;

	@Override
	public void copyElements(Collection<EObject> eObjects){
		clear();
		copyAll(eObjects);
		copyReferences();
	}

	@Override
	public EObject get(EObject eObject) {
		return super.get(eObject);
	}
}
