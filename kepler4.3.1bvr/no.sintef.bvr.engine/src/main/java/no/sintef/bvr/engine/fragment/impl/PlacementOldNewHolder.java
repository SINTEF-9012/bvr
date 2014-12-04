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

import bvr.PlacementFragment;

public class PlacementOldNewHolder {

	private PlacementFragment placement;
	
	private HashSet<EObject> staleElements;
	
	private HashSet<EObject> currentElements;
	
	public PlacementOldNewHolder(PlacementFragment placement, HashSet<EObject> plecementElements){
		this.placement = placement;
		staleElements = new HashSet<EObject>(plecementElements);
	}

	public PlacementFragment getPlacement() {
		return placement;
	}

	public void setPlacement(PlacementFragment placement) {
		this.placement = placement;
	}

	public HashSet<EObject> getStaleElements() {
		return staleElements;
	}

	public void setStaleElements(HashSet<EObject> staleElements) {
		this.staleElements = new HashSet<EObject>(staleElements);
	}

	public HashSet<EObject> getCurrentElements() {
		return currentElements;
	}

	public void setCurrentElements(HashSet<EObject> currentElements) {
		this.currentElements = new HashSet<EObject>(currentElements);
	}
	
}
