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
package no.sintef.bvr.engine.adjacent.impl;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.ToBinding;
import bvr.ToPlacement;
import no.sintef.bvr.engine.interfaces.adjacent.IAdjacentFragment;
import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;

public class AdjacentFragmentImpl implements IAdjacentFragment {

	private IFragSubHolder fragmentHolder;
	private HashSet<IAdjacentFragment> adjacentFragments;
	private HashMap<IAdjacentFragment, HashMap<FromBinding, ToBinding>> adjacentFromBindings;
	private HashMap<IAdjacentFragment, HashMap<ToBinding, FromBinding>> adjacentToBindings;
	private HashSet<IAdjacentFragment> twins;
	private HashMap<IAdjacentFragment, HashMap<ToPlacement, ToPlacement>> twinsToPlacement;
	private HashMap<IAdjacentFragment, HashMap<FromPlacement, FromPlacement>> twinsFromPlacement;

	public AdjacentFragmentImpl(IFragSubHolder fragmentHolder){
		this.fragmentHolder = fragmentHolder;
		adjacentFragments = new HashSet<IAdjacentFragment>();
		adjacentFromBindings = new HashMap<IAdjacentFragment, HashMap<FromBinding, ToBinding>>();
		adjacentToBindings = new HashMap<IAdjacentFragment, HashMap<ToBinding, FromBinding>>();
		twins = new HashSet<IAdjacentFragment>();
		twinsToPlacement = new HashMap<IAdjacentFragment, HashMap<ToPlacement, ToPlacement>>();
		twinsFromPlacement = new HashMap<IAdjacentFragment, HashMap<FromPlacement, FromPlacement>>();
	}
		
	@Override
	public IFragSubHolder getFragmentHolder() {
		return this.fragmentHolder;
	}

	@Override
	public HashSet<IAdjacentFragment> getAdjacentFragments() {
		return this.adjacentFragments;
	}
	
	@Override
	public EList<IAdjacentFragment> getAdjacentFragmentsList() {
		return new BasicEList<IAdjacentFragment>(this.adjacentFragments);
	}

	@Override
	public void setAdjacentFragment(IAdjacentFragment adjacentFragment) {
		if(this.adjacentFragments.contains(adjacentFragment))
			return;
		this.adjacentFragments.add(adjacentFragment);
	}

	@Override
	public HashMap<FromBinding, ToBinding> getAdjacentFromBindings(IAdjacentFragment adjacentFragment) {
		return this.adjacentFromBindings.get(adjacentFragment);
	}

	@Override
	public void setAdjacentFromBindings(IAdjacentFragment adjacentFragment, HashMap<FromBinding, ToBinding> adjacentBindings) {
		this.adjacentFromBindings.put(adjacentFragment, adjacentBindings);		
	}

	@Override
	public HashMap<ToBinding, FromBinding> getAdjacentToBindings(IAdjacentFragment adjacentFragment) {
		return this.adjacentToBindings.get(adjacentFragment);
	}

	@Override
	public void setAdjacentToBindings(IAdjacentFragment adjacentFragment, HashMap<ToBinding, FromBinding> adjacentBindings) {
		this.adjacentToBindings.put(adjacentFragment, adjacentBindings);
	}

	@Override
	public HashMap<IAdjacentFragment, HashMap<FromBinding, ToBinding>> getAllAdjacentFromBindings() {
		return this.adjacentFromBindings;
	}

	@Override
	public HashMap<IAdjacentFragment, HashMap<ToBinding, FromBinding>> getAllAdjacentToBindings() {
		return this.adjacentToBindings;
	}

	@Override
	public void addTwinFragment(IAdjacentFragment adjacentFragment) {
		twins.add(adjacentFragment);
	}

	@Override
	public HashSet<IAdjacentFragment> getTwinFragments() {
		return twins;
	}

	@Override
	public void addTwinBoundariesForFragment(IAdjacentFragment adjacentFragment,
			HashMap<ToPlacement, ToPlacement> toPlacementMap,
			HashMap<FromPlacement, FromPlacement> fromPlacementMap) {
		twinsToPlacement.put(adjacentFragment, toPlacementMap);
		twinsFromPlacement.put(adjacentFragment, fromPlacementMap);
	}

	@Override
	public HashMap<ToPlacement, ToPlacement> getTwinToPlacement(
			IAdjacentFragment adjacentFragment) {
		return twinsToPlacement.get(adjacentFragment);
	}

	@Override
	public HashMap<FromPlacement, FromPlacement> getTwinFromPlacement(
			IAdjacentFragment adjacentFragment) {
		return twinsFromPlacement.get(adjacentFragment);
	}

}
