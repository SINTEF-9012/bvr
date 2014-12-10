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
package no.sintef.bvr.engine.crossing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.PlacementFragment;
import no.sintef.bvr.common.engine.error.IncorrectBVRModel;
import no.sintef.bvr.engine.common.SubstitutionContext;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.fragment.impl.PlacementElementHolder;


public class PlacementCrossingFinder {
	
	private Collection<FragmentSubstitutionHolder> fragments;

	public PlacementCrossingFinder(Collection<FragmentSubstitutionHolder> collection){
		fragments = collection;
		ArrayList<ArrayList<Object>> intersections = calculatePlacementIntersections();
		if(!intersections.isEmpty()){
			String message = new String();
			for(ArrayList<Object> intersection : intersections){
				message += "the placement '"+ ((PlacementFragment) intersection.get(0)).getName() +
						"' intersects the placement '" + ((PlacementFragment) intersection.get(1)).getName() +
						"' on the elements :" + intersection.get(2) + "\n";
			}
			throw new IncorrectBVRModel("can not handle a placements intersection:\n" + message);
		}
	}
	
	private ArrayList<ArrayList<Object>> calculatePlacementIntersections(){
		HashSet<PlacementElementHolder> placements = collectPlacementHolders();
		
		ArrayList<ArrayList<Object>> intersections = new ArrayList<ArrayList<Object>>();
		if(placements.toArray().length <=1)
			return intersections;
		
		ArrayList<PlacementElementHolder> arrayPlacements = new ArrayList<PlacementElementHolder>(placements);
		for(int i=0; i<arrayPlacements.size()-1; i++){
			for(int j=i+1; j<=arrayPlacements.size()-1; j++){
				PlacementElementHolder placement0 = arrayPlacements.get(i);
				PlacementElementHolder placement1 = arrayPlacements.get(j);
				SetView<EObject> intersection = Sets.intersection(placement0.getElements(), placement1.getElements());
				if(!intersection.isEmpty()){
					SetView<EObject> symetricDifference = Sets.symmetricDifference(placement0.getElements(), placement1.getElements());
					if(symetricDifference.isEmpty()){
						SubstitutionContext.ME.getLogger().info("twins detected " + placement0.getPlacementFragment() + " and " + placement1.getPlacementFragment());
					}else{
						ArrayList<Object> intersectonData = new ArrayList<Object>();
						intersectonData.add(arrayPlacements.get(i));
						intersectonData.add(arrayPlacements.get(j));
						intersectonData.add(new HashSet<EObject>(intersection));
						intersections.add(intersectonData);
					}
				}
			}
		}
		return intersections;
	}

	
	private HashSet<PlacementElementHolder> collectPlacementHolders(){
		HashSet<PlacementElementHolder> placements = new HashSet<PlacementElementHolder>();
		for(FragmentSubstitutionHolder fragment : fragments){
			placements.add(fragment.getPlacement());
		}
		return placements;
	}
}
