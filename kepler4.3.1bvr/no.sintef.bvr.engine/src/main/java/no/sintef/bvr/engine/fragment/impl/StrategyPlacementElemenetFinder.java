package no.sintef.bvr.engine.fragment.impl;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.FromPlacement;
import bvr.PlacementBoundaryElement;
import bvr.ToPlacement;
import no.sintef.bvr.common.engine.error.GeneralBVREngineException;
import no.sintef.bvr.engine.common.HolderDataElement;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.fragment.AbstractElementFinder;
import no.sintef.bvr.engine.fragment.PlacementElementFinderStrategy;

public class StrategyPlacementElemenetFinder extends AbstractElementFinder
		implements PlacementElementFinderStrategy {

	private HolderDataElement elementsHolder;
	
	public StrategyPlacementElemenetFinder(){
		elementsHolder = new HolderDataElement();
	}
	
	@Override
	public HolderDataElement locatePlacementElements(
			EList<PlacementBoundaryElement> pbes,
			HashMap<FromPlacement, HashSet<EObject>> fromPlacementInsBoundaryMap,
			HashMap<ToPlacement, HashSet<EObject>> toPlacementOutBoundaryMap) {
		flush();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				ToPlacement toPlacement = (ToPlacement)pbe;
				HashSet<EObject> insideBoundaryElements = EngineUtility.clearSet(new HashSet<EObject>(EngineUtility.resolveProxies(toPlacement.getInsideBoundaryElement())));
				elementsHolder.addBoundaryElementInternal(insideBoundaryElements);
				EObject outsideBoundaryElement = EngineUtility.resolveProxies(toPlacement.getOutsideBoundaryElement());
				if(outsideBoundaryElement != null){
					HashSet<EObject> outsideElements = testOutsideBoundaryElement(outsideBoundaryElement, insideBoundaryElements);
					elementsHolder.addOuterInsideReferenceElements(outsideElements);
					elementsHolder.addOuterNeighboringElement(outsideElements);
				}
				elementsHolder.addInnerNeighboringElement(EngineUtility.resolveProxies(toPlacement.getInsideBoundaryElement()));
				
				HashSet<EObject> outsideBoundaryElements = EngineUtility.clearSet(toPlacementOutBoundaryMap.get(toPlacement));
				if(outsideBoundaryElements == null)
					throw new GeneralBVREngineException("failed to locate given toPlacement in the map");
				
				HashSet<EObject> outsideElements = testOutsideBoundaryElements(outsideBoundaryElements, insideBoundaryElements);
				elementsHolder.addOuterInsideReferenceElements(outsideElements);
				elementsHolder.addOuterNeighboringElement(outsideElements);
			}
			if(pbe instanceof FromPlacement){
				FromPlacement fromPlacement = (FromPlacement) pbe;
				EList<EObject> outsideBoundaryElements = EngineUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement());
				EObject insideBoundaryElement = EngineUtility.resolveProxies(fromPlacement.getInsideBoundaryElement());
				if(outsideBoundaryElements.size() != 0){
					elementsHolder.addOuterNeighboringElement(outsideBoundaryElements);
					elementsHolder.addOuterOutsideReferenceElement(outsideBoundaryElements);
				}
				
				if(insideBoundaryElement != null)
					elementsHolder.addInnerNeighboringElement(insideBoundaryElement);
				
				
				HashSet<EObject> insideBoundaryElements = EngineUtility.clearSet(fromPlacementInsBoundaryMap.get(fromPlacement));
				if(insideBoundaryElements == null)
					throw new GeneralBVREngineException("failed to locate given fromPlacement in the map");
				
				if(outsideBoundaryElements.size() != 0)
					elementsHolder.addBoundaryElementExternal(insideBoundaryElements);
				
				elementsHolder.addInnerNeighboringElement(insideBoundaryElements);
			}
		}
		
		EList<EObject> elements = new BasicEList<EObject>();
		elements = calculateInnerElements(new BasicEList<EObject>(elementsHolder.getOuterInsideReferenceElements()),
				new BasicEList<EObject>(elementsHolder.getOuterOutsideReferenceElements()),
				new BasicEList<EObject>(elementsHolder.getInnerNeighboringElements()), new BasicEList<EObject>());
		elementsHolder.addInnerFragmentElements(elements);
		HashSet<EObject> boundaryElements = new HashSet<EObject>();
		boundaryElements.addAll(elementsHolder.getBoundaryElementsExternal());
		boundaryElements.addAll(elementsHolder.getBoundaryElementsInternal());
		SetView<EObject> innerElements = Sets.symmetricDifference(elementsHolder.getInnerFragmentElements(), boundaryElements);
		elementsHolder.addInnerElement(innerElements);
		
		return elementsHolder;
	}

	private HashSet<EObject> testOutsideBoundaryElement(EObject outsideBoundaryElement, HashSet<EObject> insideBoundaryElements){
		HashSet<EObject> elements = new HashSet<EObject>();
		EList<EObject> allRefs = no.sintef.bvr.common.CommonUtility.getReferencedEObjects(outsideBoundaryElement);		
		if(!Sets.intersection(new HashSet<EObject>(allRefs), insideBoundaryElements).isEmpty()){
			elements.add(outsideBoundaryElement);
		}
		return elements;
	}
	
	private HashSet<EObject> testOutsideBoundaryElements(HashSet<EObject> outsideBoudaryElements, HashSet<EObject> insideBoundaryElements){
		HashSet<EObject> elements = new HashSet<EObject>();
		for(EObject outsideBoundaryElement : outsideBoudaryElements){
			EList<EObject> allRefs = no.sintef.bvr.common.CommonUtility.getReferencedEObjects(outsideBoundaryElement);
			if(!Sets.intersection(new HashSet<EObject>(allRefs), insideBoundaryElements).isEmpty()){
				elements.add(outsideBoundaryElement);
			}
		}
		return elements;
	}
	
	@Override
	public void flush() {
		elementsHolder = new HolderDataElement();
	}

}
