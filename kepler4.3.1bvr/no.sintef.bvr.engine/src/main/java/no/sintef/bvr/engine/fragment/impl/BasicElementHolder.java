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
package no.sintef.bvr.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.interfaces.fragment.IElementHolder;

public abstract class BasicElementHolder implements IElementHolder {

	protected HashSet<EObject> frElementsOriginal;
	protected HashSet<EObject> frBElementsInternal; 
	protected HashSet<EObject> frBElementsExternal;
	protected HashSet<EObject> frElementsInternal;
	protected HashSet<EObject> frNeighboringInsideElements;
	protected HashSet<EObject> frNeighboringOutsideElements;
	
	@Override
	public HashSet<EObject> getElements() {
		return frElementsOriginal;
	}

	@Override
	public HashSet<EObject> getBElementsInternal() {
		return frBElementsInternal;
	}

	@Override
	public HashSet<EObject> getBElementsExternal() {
		return frBElementsExternal;
	}

	@Override
	public HashSet<EObject> getElementsInternal() {
		return frElementsInternal;
	}
	
	@Override
	public HashSet<EObject> getNeighboringInsideElements() {
		return frNeighboringInsideElements;
	}
	
	@Override
	public HashSet<EObject> getNeighboringOutsideElements() {
		return frNeighboringOutsideElements;
	}
		
	protected void locate() throws BasicBVREngineException {
		frElementsOriginal = new HashSet<EObject>();
		frBElementsInternal = new HashSet<EObject>();
		frBElementsExternal = new HashSet<EObject>();
		frElementsInternal = new HashSet<EObject>();
		frNeighboringInsideElements = new HashSet<EObject>();
		frNeighboringOutsideElements = new HashSet<EObject>();
	}

}
