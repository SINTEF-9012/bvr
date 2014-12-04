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
package no.sintef.bvr.engine.interfaces.common;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface IHolderDataElement {

	public HashSet<EObject> getInnerNeighboringElements();
	
	public void addInnerNeighboringElement(EObject innerElement);
	
	public void addInnerNeighboringElement(Collection<EObject> innerElement);
	
	public HashSet<EObject> getInnerElements();
	
	public void addInnerElement(EObject innerElement);
	
	public void addInnerElement(Collection<EObject> innerElement);
	
	public HashSet<EObject> getOuterNeighboringElements();
	
	public void addOuterNeighboringElement(EObject outerElement);
	
	public void addOuterNeighboringElement(Collection<EObject> outerElement);
	
	public HashSet<EObject> getOuterInsideReferenceElements();
	
	public void addOuterInsideReferenceElements(EObject outerInnerElement);
	
	public void addOuterInsideReferenceElements(Collection<EObject> outerInnerElement);
	
	public HashSet<EObject> getOuterOutsideReferenceElements();
	
	public void addOuterOutsideReferenceElement(EObject outerOuterElement);
	
	public void addOuterOutsideReferenceElement(Collection<EObject> outerOuterElement);
	
	public HashSet<EObject> getBoundaryElementsInternal();
	
	public void addBoundaryElementInternal(EObject boundaryElementInternal);
	
	public void addBoundaryElementInternal(Collection<EObject> boundaryElementInternal);
	
	public HashSet<EObject> getBoundaryElementsExternal();
	
	public void addBoundaryElementExternal(EObject boundaryElementExternal);
	
	public void addBoundaryElementExternal(Collection<EObject> boundaryElementExternal);
	
	public HashSet<EObject> getInnerFragmentElements();
	
	public void addInnerFragmentElements(Collection<EObject> innerFragElements);
}
