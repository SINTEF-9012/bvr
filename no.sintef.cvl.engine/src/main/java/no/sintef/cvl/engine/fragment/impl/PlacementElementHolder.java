package no.sintef.cvl.engine.fragment.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.fragment.ElementHolderOIF;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ToPlacement;

public class PlacementElementHolder extends BasicElementHolder implements ElementHolderOIF {

	protected EList<ToPlacement> tbe;
	protected EList<FromPlacement> fbe;
	protected HashSet<EObject> innerElements;
	protected HashSet<EObject> outerElements;
	private HashSet<EObject> vVertices;
	private PlacementFragment placement;
	private HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap;

	public PlacementElementHolder(PlacementFragment pf) {
		placement = pf;
		fromPlacementInsBoundaryMap = new HashMap<FromPlacement, HashSet<EObject>>();
		this.locate();
	}
		
	public void update(){
		this.locate();
	}
	
	@Override
	protected void locate(){
		super.locate();
		vVertices = new HashSet<EObject>();
		outerElements = new HashSet<EObject>();
		innerElements = new HashSet<EObject>();
		tbe = new BasicEList<ToPlacement>();
		fbe = new BasicEList<FromPlacement>();
		
		EList<PlacementBoundaryElement> pbes = placement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				frBElementsInternal.addAll(Utility.resolveProxies(((ToPlacement)pbe).getInsideBoundaryElement()));
				outerElements.add(Utility.resolveProxies(((ToPlacement)pbe).getOutsideBoundaryElement()));
				innerElements.addAll(Utility.resolveProxies(((ToPlacement)pbe).getInsideBoundaryElement()));
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				frBElementsExternal.add(Utility.resolveProxies(((FromPlacement)pbe).getInsideBoundaryElement()));
				outerElements.addAll(Utility.resolveProxies(((FromPlacement)pbe).getOutsideBoundaryElement()));
				innerElements.add(Utility.resolveProxies(((FromPlacement)pbe).getInsideBoundaryElement()));
				
				//if we do not replace a fragment we need to keep track of insideBoundaryElements 
				HashSet<EObject> insideBoundaryFromPlacemenent = fromPlacementInsBoundaryMap.get((FromPlacement) pbe);
				insideBoundaryFromPlacemenent = (insideBoundaryFromPlacemenent == null) ? new HashSet<EObject>() : insideBoundaryFromPlacemenent;
				insideBoundaryFromPlacemenent.add(Utility.resolveProxies(((FromPlacement)pbe).getInsideBoundaryElement()));
				fromPlacementInsBoundaryMap.put((FromPlacement) pbe, insideBoundaryFromPlacemenent);
			}
		}
		this.calculatePlElementsInternal();
		frElementsOriginal.addAll(frBElementsExternal);
		frElementsOriginal.addAll(frBElementsInternal);
		frElementsOriginal.addAll(frElementsInternal);
	}
	
	private void calculatePlElementsInternal(){
		for(EObject element : frBElementsInternal){
			this.traversRelation(element);
		}
	}
	
	private void traversRelation(EObject element) {
		if(!vVertices.contains(element) && !frBElementsExternal.contains(element) && !outerElements.contains(element)){
			vVertices.add(element);
			if(!frBElementsInternal.contains(element)){
				frElementsInternal.add(element);
			}
			EList<EObject> references = element.eCrossReferences();
			for(EObject ref : references){
				this.traversRelation(ref);
			}
			EList<EObject> contents = element.eContents();
			for(EObject con : contents){
				this.traversRelation(con);
			}
		}
	}
	
	@Override
	public HashSet<EObject> getInnerFragmentElements() {
		HashSet<EObject> innElements = new HashSet<EObject>();
		for(HashSet<EObject> innerEl : fromPlacementInsBoundaryMap.values()){
			innElements.addAll(innerEl);
		}
		innElements.addAll(innerElements);
		return innElements;
	}
	
	@Override
	public HashSet<EObject> getBElementsExternal() {
		HashSet<EObject> innElements = new HashSet<EObject>();
		for(HashSet<EObject> innerEl : fromPlacementInsBoundaryMap.values()){
			innElements.addAll(innerEl);
		}
		return innElements;
	}

	@Override
	public HashSet<EObject> getOuterFragmentElements() {
		return outerElements;
	}
	
	public EList<ToPlacement> getToPlacementBoundaries(){
		return tbe;
	}
	
	public EList<FromPlacement> getFromPlacementBoundaries(){
		return fbe;
	}

	public PlacementFragment getPlacementFragment() {
		return placement;
	}
	
	public HashMap<FromPlacement, HashSet<EObject>> getFromPlacementInsBoundaryMap(){
		return this.fromPlacementInsBoundaryMap;
	}
	
	public void setFromPlacementInsBoundaryMap(HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementInsBoundaryMap){
		HashMap<FromPlacement, HashSet<EObject>> map = new HashMap<FromPlacement, HashSet<EObject>>();
		for(Map.Entry<FromPlacement, HashSet<ObjectHandle>> entry : fromPlacementInsBoundaryMap.entrySet()){
			FromPlacement key = entry.getKey();
			HashSet<ObjectHandle> value = entry.getValue();
			map.put(key, new HashSet<EObject>(Utility.resolveProxies(new BasicEList<ObjectHandle>(value))));
		}
		this.fromPlacementInsBoundaryMap = map;
	}
}
