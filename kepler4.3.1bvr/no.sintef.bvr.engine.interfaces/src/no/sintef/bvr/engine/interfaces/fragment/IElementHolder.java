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
package no.sintef.bvr.engine.interfaces.fragment;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

public interface IElementHolder {

	public HashSet<EObject> getElements();
	
	public HashSet<EObject> getBElementsInternal();
	
	public HashSet<EObject> getBElementsExternal();
	
	public HashSet<EObject> getElementsInternal();
	
	//Elements referenced by outsideBoundaryElements and
	//pointing to elements inside a placement
	public HashSet<EObject> getNeighboringInsideElements();
	
	//Elements referenced by outsideBoundaryElements and
	//pointed by elements from a placement
	public HashSet<EObject> getNeighboringOutsideElements();
	
}
