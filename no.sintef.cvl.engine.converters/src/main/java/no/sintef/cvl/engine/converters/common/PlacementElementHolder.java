package no.sintef.cvl.engine.converters.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.ToPlacement;

import com.google.common.collect.Sets;

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
	
	public PlacementElementHolder(PlacementFragment pf) {
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
		Set<EObject> outsideBoundaryElements = new HashSet<EObject>(fp.getOutsideBoundaryElement());
		/*for(EObject pbee : plBElementsExternalWCopy){
			Set<EObject> refs = new HashSet<EObject>(this.getAllReferencedElements(pbee));
			Set<Set<EObject>> powerSetRefs = Sets.powerSet(refs);
			if(powerSetRefs.contains(outsideBoundaryElements)){
				plBElementsExternalWCopy.remove(pbee);
				return pbee;
			}
		}*/
		for(EObject pbee : plBElementsExternalLink){
		Set<EObject> refs = new HashSet<EObject>(this.getAllReferencedElementsLinks(pbee));
		Set<Set<EObject>> powerSetRefs = Sets.powerSet(refs);
			if(powerSetRefs.contains(outsideBoundaryElements)){
				plBElementsExternalLink.remove(pbee);
				return pbee;
			}
		}
		for(EObject pbee : plBElementsExternalCont){
		Set<EObject> refs = new HashSet<EObject>(this.getAllReferencedElementsCont(pbee));
		Set<Set<EObject>> powerSetRefs = Sets.powerSet(refs);
			if(powerSetRefs.contains(outsideBoundaryElements)){
				plBElementsExternalCont.remove(pbee);
				return pbee;
			}
		}	
		return null;
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
	
	/*private EList<EObject> getAllReferencedElements(EObject pbee){
		EList<EObject> refs = pbee.eCrossReferences();
		EList<EObject> conts = pbee.eContents();
		HashSet<EObject> elementsSet = new HashSet<EObject>();
		elementsSet.addAll(refs);
		elementsSet.addAll(conts);
		EList<EObject> elements = new BasicEList<EObject>();
		elements.addAll(elementsSet);
		return elements;
	}*/
	
	private void locate(PlacementFragment pf){
		EList<PlacementBoundaryElement> pbes = pf.getBoundaryElement();
		HashSet<EObject> obes = new HashSet<EObject>();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				obes.add(((ToPlacement)pbe).getOutsideBoundaryElement());
				//fpobes.add(((ToPlacement)pbe).getOutsideBoundaryElement());
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				obes.addAll(((FromPlacement) pbe).getOutsideBoundaryElement());
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
