package no.sintef.cvl.tool.strategy.impl;

import java.util.HashSet;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.FragmentSubstitution;
import cvl.PlacementFragment;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.tool.common.LoaderUtility;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.PlacementIntersectionResolverStrategy;

public class PlacementIntersectionLessStrategy implements
		PlacementIntersectionResolverStrategy {

	@Override
	public void resolveIntersection(SymbolTable table) {
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
				PlacementElementHolder placement0 = new PlacementElementHolder(arrayPlacements.get(i));
				PlacementElementHolder placement1 = new PlacementElementHolder(arrayPlacements.get(j));
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
