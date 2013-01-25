package no.sintef.cvl.engine.converters.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.ToPlacement;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class PlacementElementHolder {
	
	private EList<ToPlacement> tbe;
	private EList<FromPlacement> fbe;
	private EList<EObject> fpobes;
	private HashSet<EObject> plElements;
	private HashSet<EObject> plElementsOriginal;
	private HashSet<EObject> plBElementsInternal; 
	private HashSet<EObject> plBElementsExternal;
	private HashSet<EObject> plBElementsExternalLink;
	private HashSet<EObject> plBElementsExternalCont;
	private HashSet<EObject> plElementsInternal;
	private HashSet<EObject> plBElementsExternalWCopy;
	private HashMap<FromPlacement, EObject> fPlInsideMap;
	private PlacementFragment placement;
	private EList<Object> vertexes;
	private HashMap<EObject, HashSet<EObject>> insideBoundaryOutsideBoundariesMap;
	
	public PlacementElementHolder(PlacementFragment pf) {
		insideBoundaryOutsideBoundariesMap = new HashMap<EObject, HashSet<EObject>>();
		vertexes = new BasicEList<Object>();
		placement = pf;
		tbe = new BasicEList<ToPlacement>();
		fbe = new BasicEList<FromPlacement>();
		fpobes = new BasicEList<EObject>();
		plElements = new HashSet<EObject>();
		plBElementsInternal = new HashSet<EObject>();
		plBElementsExternal = new HashSet<EObject>();
		plBElementsExternalLink = new HashSet<EObject>();
		plBElementsExternalCont = new HashSet<EObject>();
		plElementsInternal = new HashSet<EObject>();
		fPlInsideMap = new HashMap<FromPlacement, EObject>();
		this.locate(pf);
		plElementsOriginal = new HashSet<EObject>(plElements);
		this.calculatePlElementsInternal();
		plBElementsExternalWCopy = new HashSet<EObject>(plBElementsExternal);
		new HashSet<EObject>(plElementsInternal);
		this.findInsideBoundaryElements();
		this.printStat();
	}
	
	private void printStat() {
		System.out.println("************************************");
		System.out.println("Fragment placement :" + placement);
		System.out.println("Elements " + this.getElements());
		System.out.println("Internal boundary elements " + this.getBElementsInternal());
		System.out.println("External boundary elements " + this.getBElementsExternal());
		System.out.println("Internal elements " + this.getElementsInternal());
		System.out.println("Map(FromPlacement, insideBoundaryElement): " + this.getInsideBoundaryMapForPlacement());
	}

	public HashMap<FromPlacement, EObject> getInsideBoundaryMapForPlacement(){
		return this.fPlInsideMap;
	}
	
	public HashSet<EObject> getElements(){
		return this.plElementsOriginal;
	}
	
	public HashSet<EObject> getBElementsInternal(){
		return this.plBElementsInternal;
	}
	
	public HashSet<EObject> getBElementsExternal(){
		return this.plBElementsExternal;
	}
	
	public HashSet<EObject> getElementsInternal(){
		return this.plElementsInternal;
	}
	
	private EObject getInsideBoundaryElementFromPlacement(FromPlacement fp){
		Set<EObject> outsideBoundaryElements = new HashSet<EObject>(Utility.resolveProxies(fp.getOutsideBoundaryElement()));
		HashMap<EObject, HashSet<EObject>> outsideInsideBoundaryMap = new HashMap<EObject, HashSet<EObject>>();
		HashMap<EObject, EObject> outsideInsideBoundaryParentMap = new HashMap<EObject, EObject>();
		for(EObject outsideBoundaryElement : outsideBoundaryElements){
			Collection<Setting> referencers = EcoreUtil.UsageCrossReferencer.find(outsideBoundaryElement, outsideBoundaryElement.eResource());
			HashSet<EObject> ref = new HashSet<EObject>();
			Iterator<Setting> iterator = referencers.iterator();
			while(iterator.hasNext()){
				ref.add(iterator.next().getEObject());
			}
			HashSet<EObject> insideBoundaryElements = new HashSet<EObject>(Sets.intersection(ref, plElements));
			outsideInsideBoundaryMap.put(outsideBoundaryElement, insideBoundaryElements);
			
			EObject outsideBoundaryParent = outsideBoundaryElement.eContainer();
			outsideBoundaryParent = (plElements.contains(outsideBoundaryParent)) ? outsideBoundaryParent : null;
			outsideInsideBoundaryParentMap.put(outsideBoundaryElement, outsideBoundaryParent);
		}
		
		Collection<EObject> insideElementSetParent = outsideInsideBoundaryParentMap.values();
		Iterator<EObject> iter = insideElementSetParent.iterator();
		HashSet<EObject> insideBoundaryElementsParent = new HashSet<EObject>();
		insideBoundaryElementsParent.add(iter.next());
		while(iter.hasNext()){
			HashSet<EObject> set = new HashSet<EObject>();
			set.add(iter.next());
			insideBoundaryElementsParent = new HashSet<EObject>(Sets.intersection(insideBoundaryElementsParent, set));
		}
		EObject insideBoundaryElementParent = (insideBoundaryElementsParent.size() == 1) ? insideBoundaryElementsParent.iterator().next() : null;
		
		Collection<HashSet<EObject>> insideElementSet = outsideInsideBoundaryMap.values();
		Iterator<HashSet<EObject>> iterator = insideElementSet.iterator();
		HashSet<EObject> insideBoundaryElements = iterator.next();
		while(iterator.hasNext()){
			insideBoundaryElements = new HashSet<EObject>(Sets.intersection(insideBoundaryElements, iterator.next()));
		}
		
		if(insideBoundaryElements.size() > 1){
			System.out.println("found more than one suitable insideBoundaryElement for fromPlacement");
			/*System.out.println(insideBoundaryElements);
			insideBoundaryElements = this.chooseInsideBoundaryElement(insideBoundaryElements, outsideBoundaryElements);
			if(insideBoundaryElements.size() > 1 || insideBoundaryElements.size() == 0){
				System.out.println("!!!!WARNING: can not choose insideBoundaryElement for fromPlacement in CrossReferences" + insideBoundaryElements);
			}*/
		}
		
		EObject insideBoundaryElement = (insideBoundaryElements.size() >= 1) ? insideBoundaryElements.iterator().next() : null;
		
		if(insideBoundaryElement != null && insideBoundaryElementParent != null){
			HashSet<EObject> outsideBoundaryElementsSet = this.insideBoundaryOutsideBoundariesMap.get(insideBoundaryElement);
			outsideBoundaryElementsSet = (outsideBoundaryElementsSet == null) ? new HashSet<EObject>() : outsideBoundaryElementsSet;
			if(Sets.symmetricDifference(outsideBoundaryElementsSet, outsideBoundaryElements).isEmpty()){
				return insideBoundaryElementParent;
			}
			this.insideBoundaryOutsideBoundariesMap.put(insideBoundaryElement, new HashSet<EObject>(outsideBoundaryElements));
			return insideBoundaryElement;
		}
		
		if(insideBoundaryElement != null){
			return insideBoundaryElement;
		}
		
		if(insideBoundaryElementParent != null){
			return insideBoundaryElementParent;
		}
				
		return null;
	}
	
	private HashSet<EObject> chooseInsideBoundaryElement(HashSet<EObject> insideBoundaryElements, Set<EObject> outsideBoundaryElements) {
		HashSet<EObject> insideBoundaryElementsNew = new HashSet<EObject>();
		for(EObject insideBoundaryElement : insideBoundaryElements){
			EList<EObject> refs = insideBoundaryElement.eCrossReferences();
			SetView<EObject> outsideElements = Sets.difference(new HashSet<EObject>(refs), plElements);
			if(Sets.symmetricDifference(outsideElements, outsideBoundaryElements).isEmpty()){
				insideBoundaryElementsNew.add(insideBoundaryElement);
			}
		}
		return insideBoundaryElementsNew;
	}

	public void findInsideBoundaryElements(){
		for(FromPlacement fp : this.fbe){
			EObject insideBoundaryElement = this.getInsideBoundaryElementFromPlacement(fp);
			this.fPlInsideMap.put(fp, insideBoundaryElement);
			if(insideBoundaryElement == null){
				System.out.println("WARNING: can not fine insideBoundaryElement for " + fp);
			}
		}
	}
	
	private EList<EObject> getAllReferencedElementsLinks(EObject pbee){
		EList<EObject> refs = pbee.eCrossReferences();
		HashSet<EObject> elementsSet = new HashSet<EObject>();
		elementsSet.addAll(refs);
		EList<EObject> elements = new BasicEList<EObject>();
		elements.addAll(elementsSet);
		return elements;
	}

	private EList<EObject> getAllReferencedElementsCont(EObject pbee){
		EList<EObject> conts = pbee.eContents();
		HashSet<EObject> elementsSet = new HashSet<EObject>();
		elementsSet.addAll(conts);
		EList<EObject> elements = new BasicEList<EObject>();
		elements.addAll(elementsSet);
		return elements;
	}
	
	private void locate(PlacementFragment pf){
		EList<PlacementBoundaryElement> pbes = pf.getBoundaryElement();
		HashSet<EObject> obes = new HashSet<EObject>();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				obes.add(Utility.resolveProxies(((ToPlacement)pbe).getOutsideBoundaryElement()));
				//fpobes.add(((ToPlacement)pbe).getOutsideBoundaryElement());
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				obes.addAll(Utility.resolveProxies(((FromPlacement) pbe).getOutsideBoundaryElement()));
				//fpobes.addAll(((FromPlacement) pbe).getOutsideBoundaryElement());
			}
		}
		fpobes.addAll(obes);
		this.calculatePlBElementsInternal();
		EList<EObject> list = new BasicEList<EObject>();
		list.addAll(plBElementsInternal);
		this.findAllElements(list);
	}
		
	private void calculatePlElementsInternal(){
		HashSet<EObject> pbes = new HashSet<EObject>(plBElementsInternal);
		pbes.addAll(plBElementsExternal);
		plElementsInternal.addAll(Sets.difference(plElementsOriginal, pbes));
	}
	
	private void calculatePlBElementsInternal(){
		for(ToPlacement tp : tbe){
			EList<EObject> ibes = tp.getInsideBoundaryElement();
			plBElementsInternal.addAll(ibes);
		}
	}

	private void findAllElements(EList<EObject> arrayList) {
		for(EObject o : arrayList){
			vertexes.clear();
			this.traversRelation(o);
		}
		
	}

	private void traversRelation(EObject o) {
		if(fpobes.indexOf(o) < 0 && vertexes.indexOf(o) < 0){
			plElements.add(o);
			vertexes.add(o);
			EList<EObject> references = o.eCrossReferences();
			for(EObject ref : references){
				//this.addPlBElementsExternal(o, ref);
				this.addPlBElementsExternalLink(o, ref);
				this.traversRelation(ref);
			}
			EList<EObject> contents = o.eContents();
			for(EObject con : contents){
				//this.addPlBElementsExternal(o, con);
				this.addPlBElementsExternalCont(o, con);
				this.traversRelation(con);
			}	
		}
	}
	
	/*private void addPlBElementsExternal(EObject o, EObject ref){
		if(fpobes.indexOf(ref) >= 0){
			plBElementsExternal.add(o);
		}
	}*/
	
	private void addPlBElementsExternalLink(EObject o, EObject ref){
		if(fpobes.indexOf(ref) >= 0){
			plBElementsExternal.add(o);
			plBElementsExternalLink.add(o);
		}
	}
	
	private void addPlBElementsExternalCont(EObject o, EObject ref){
		if(fpobes.indexOf(ref) >= 0){
			plBElementsExternal.add(o);
			plBElementsExternalCont.add(o);
		}
	}
}
