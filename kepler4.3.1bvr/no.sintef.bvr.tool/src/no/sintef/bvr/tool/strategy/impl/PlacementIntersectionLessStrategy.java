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
package no.sintef.bvr.tool.strategy.impl;

import java.util.HashSet;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.PlacementIntersectionResolverStrategy;

public class PlacementIntersectionLessStrategy implements
		PlacementIntersectionResolverStrategy {

	@Override
	public void resolveIntersection(SymbolVSpecResolutionTable table) {
		HashSet<FragmentSubstitution> fragmentSubstitutions = LoaderUtility.collectFragmentSubstitutionsInTable(table);
		ArrayList<ArrayList<Object>> intersections = calculatePlacementIntersections(fragmentSubstitutions);
		if(!intersections.isEmpty()){
			String message = new String();
			for(ArrayList<Object> intersection : intersections){
				message += "the placement '"+ ((PlacementFragment) intersection.get(0)).getName() +
						"' intersects the placement '" + ((PlacementFragment) intersection.get(1)).getName() +
						"' on the elements :" + intersection.get(2) + "\n";
			}
			throw new UnsupportedOperationException("can not handle a placements intersection:\n" + message);
		}
	}
	
	private ArrayList<ArrayList<Object>> calculatePlacementIntersections(HashSet<FragmentSubstitution> fragments){
		HashSet<PlacementFragment> placements = new HashSet<PlacementFragment>();
		for(FragmentSubstitution fragment : fragments)
			placements.add(fragment.getPlacement());
		
		ArrayList<ArrayList<Object>> intersections = new ArrayList<ArrayList<Object>>();
		if(placements.toArray().length <=1)
			return intersections;
		
		ArrayList<PlacementFragment> arrayPlacements = new ArrayList<PlacementFragment>(placements);
		for(int i=0; i<arrayPlacements.size()-1; i++){
			for(int j=i+1; j<=arrayPlacements.size()-1; j++){
				IPlacementElementHolder placement0 = Context.eINSTANCE.getSubEngine().createPlacementElementHolder(arrayPlacements.get(i));
				IPlacementElementHolder placement1 = Context.eINSTANCE.getSubEngine().createPlacementElementHolder(arrayPlacements.get(j));
				SetView<EObject> intersection = Sets.intersection(placement0.getElements(), placement1.getElements());
				if(!intersection.isEmpty()){
					ArrayList<Object> intersectonData = new ArrayList<Object>();
					intersectonData.add(arrayPlacements.get(i));
					intersectonData.add(arrayPlacements.get(j));
					intersectonData.add(new HashSet<EObject>(intersection));
					intersections.add(intersectonData);
				}
			}
		}
		return intersections;
	}

}
