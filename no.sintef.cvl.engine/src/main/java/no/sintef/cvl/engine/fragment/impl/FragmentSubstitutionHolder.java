package no.sintef.cvl.engine.fragment.impl;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.BoundaryElementBinding;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.ToBinding;
import cvl.ToPlacement;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public class FragmentSubstitutionHolder implements FragSubHolder {

	private FragmentSubstitution fragment;
	private PlacementElementHolder placement;
	private ReplacementElementHolder replacement;
	private EList<BoundaryElementBinding> bindings;
	private EList<ToBinding> toBinding;
	private EList<FromBinding> fromBinding;
	private HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementOHInsideBoundaryMap;
	private HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap;

	public FragmentSubstitutionHolder(FragmentSubstitution fs) {
		fragment = fs;
		fromPlacementOHInsideBoundaryMap = new HashMap<FromPlacement, HashSet<ObjectHandle>>();
		toPlacementOHOutsideBoundaryMap = new HashMap<ToPlacement, HashSet<ObjectHandle>>();
		placement = new PlacementElementHolder(fragment.getPlacement());
		replacement = new ReplacementElementHolder(fragment.getReplacement());
		bindings = fragment.getBoundaryElementBinding();
		toBinding = new BasicEList<ToBinding>();
		fromBinding = new BasicEList<FromBinding>();
		for(BoundaryElementBinding binding : bindings){
			if(binding instanceof ToBinding){
				toBinding.add((ToBinding) binding);
				//adjacentness may bring multiply outsideBoundaryElement reference for ToPlacement 
				HashSet<ObjectHandle> set = new HashSet<ObjectHandle>();
				set.add(((ToBinding) binding).getToPlacement().getOutsideBoundaryElement());
				toPlacementOHOutsideBoundaryMap.put(((ToBinding) binding).getToPlacement(), set);
			}
			if(binding instanceof FromBinding){
				fromBinding.add((FromBinding) binding);
				//if we do not replace a placement, it may bring multiply insideBoundaryElement reference for FromPlacement
				HashSet<ObjectHandle> set = new HashSet<ObjectHandle>();
				set.add(((FromBinding) binding).getFromPlacement().getInsideBoundaryElement());
				fromPlacementOHInsideBoundaryMap.put(((FromBinding) binding).getFromPlacement(), set);
			}
		}
	}
	
	public void update(boolean replace){
		placement.update(replace);
	}
	
	@Override
	public PlacementElementHolder getPlacement() {
		return placement;
	}

	@Override
	public ReplacementElementHolder getReplacement() {
		return replacement;
	}

	@Override
	public FragmentSubstitution getFragment() {
		return fragment;
	}

	@Override
	public EList<ToBinding> getToBindings() {
		return toBinding;
	}

	@Override
	public EList<FromBinding> getFromBinding() {
		return fromBinding;
	}
	
	public void setFromPlacementInsideBoundaryElementMap(HashMap<FromPlacement, HashSet<ObjectHandle>> insideBoundaryMap){
		this.fromPlacementOHInsideBoundaryMap = insideBoundaryMap;
	}
	
	public HashMap<FromPlacement, HashSet<ObjectHandle>> getFromPlacementInsideBoundaryElementMap(){
		return this.fromPlacementOHInsideBoundaryMap;
	}
	
	public void setToPlacementOutsideBoundaryElementMap(HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryMap){
		this.toPlacementOHOutsideBoundaryMap = outsideBoundaryMap;
	}
	
	public HashMap<ToPlacement, HashSet<ObjectHandle>> getToPlacementOutsideBoundaryElementMap(){
		return this.toPlacementOHOutsideBoundaryMap;
	}

}
