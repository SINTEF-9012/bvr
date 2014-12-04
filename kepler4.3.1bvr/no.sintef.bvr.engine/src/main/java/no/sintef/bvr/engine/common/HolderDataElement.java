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
import java.util.HashSet;

import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;

import org.eclipse.emf.ecore.EObject;

public class HolderDataElement implements IHolderDataElement {
	
	private HashSet<EObject> innerNeighboringElements;
	private HashSet<EObject> outerNeighboringElements; 
	private HashSet<EObject> outerInsideReferenceElements;
	private HashSet<EObject> outerOutsideReferenceElements;
	private HashSet<EObject> boundaryElementsInternal;
	private HashSet<EObject> boundaryElementsExternal;
	private HashSet<EObject> innerElements;
	private HashSet<EObject> innerFragmentElements;
	
	public HolderDataElement(){
		innerNeighboringElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		innerFragmentElements = new HashSet<EObject>();
		outerNeighboringElements = new HashSet<EObject>();
		outerInsideReferenceElements = new HashSet<EObject>();
		outerOutsideReferenceElements = new HashSet<EObject>();
		boundaryElementsInternal = new HashSet<EObject>();
		boundaryElementsExternal = new HashSet<EObject>();
	}
	
	public HashSet<EObject> getInnerNeighboringElements() {
		return innerNeighboringElements;
	}
	
	public void addInnerNeighboringElement(EObject innerElement) {
		innerNeighboringElements.add(innerElement);
	}
	
	public void addInnerNeighboringElement(Collection<EObject> innerElement){
		innerNeighboringElements.addAll(innerElement);
	}
	
	public HashSet<EObject> getInnerElements() {
		return innerElements;
	}
	
	public void addInnerElement(EObject innerElement) {
		innerElements.add(innerElement);
	}
	
	public void addInnerElement(Collection<EObject> innerElement){
		innerElements.addAll(innerElement);
	}
	
	public HashSet<EObject> getOuterNeighboringElements() {
		return outerNeighboringElements;
	}
	
	public void addOuterNeighboringElement(EObject outerElement) {
		outerNeighboringElements.add(outerElement);
	}
	
	public void addOuterNeighboringElement(Collection<EObject> outerElement) {
		outerNeighboringElements.addAll(outerElement);
	}
	
	public HashSet<EObject> getOuterInsideReferenceElements() {
		return outerInsideReferenceElements;
	}
	
	public void addOuterInsideReferenceElements(EObject outerInnerElement) {
		outerInsideReferenceElements.add(outerInnerElement);
	}
	
	public void addOuterInsideReferenceElements(Collection<EObject> outerInnerElement) {
		outerInsideReferenceElements.addAll(outerInnerElement);
	}
	
	public HashSet<EObject> getOuterOutsideReferenceElements() {
		return outerOutsideReferenceElements;
	}
	
	public void addOuterOutsideReferenceElement(EObject outerOuterElement) {
		outerOutsideReferenceElements.add(outerOuterElement);
	}
	
	public void addOuterOutsideReferenceElement(Collection<EObject> outerOuterElement) {
		outerOutsideReferenceElements.addAll(outerOuterElement);
	}
	
	public HashSet<EObject> getBoundaryElementsInternal() {
		return boundaryElementsInternal;
	}
	
	public void addBoundaryElementInternal(EObject boundaryElementInternal) {
		boundaryElementsInternal.add(boundaryElementInternal);
	}
	
	public void addBoundaryElementInternal(Collection<EObject> boundaryElementInternal) {
		boundaryElementsInternal.addAll(boundaryElementInternal);
	}
	
	public HashSet<EObject> getBoundaryElementsExternal() {
		return boundaryElementsExternal;
	}
	
	public void addBoundaryElementExternal(EObject boundaryElementExternal) {
		boundaryElementsExternal.add(boundaryElementExternal);
	}
	
	public void addBoundaryElementExternal(Collection<EObject> boundaryElementExternal) {
		boundaryElementsExternal.addAll(boundaryElementExternal);
	}

	public HashSet<EObject> getInnerFragmentElements() {
		return innerFragmentElements;
	}

	public void addInnerFragmentElements(Collection<EObject> innerFragElements) {
		innerFragmentElements.addAll(innerFragElements);
	}
}
