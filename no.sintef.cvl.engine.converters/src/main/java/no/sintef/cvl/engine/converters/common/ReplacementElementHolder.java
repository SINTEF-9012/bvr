package no.sintef.cvl.engine.converters.common;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.variabilitymodeling.cvl.FromReplacement;
import org.variabilitymodeling.cvl.ReplacementBoundaryElement;
import org.variabilitymodeling.cvl.ReplacementFragment;
import org.variabilitymodeling.cvl.ToReplacement;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class ReplacementElementHolder {
	
	private ReplacementFragment replacement;
	private EList<ToReplacement> tre;
	private EList<FromReplacement> fre;
	private EList<EObject> frobes;
	private EList<EObject> frobesOriginal;
	private HashSet<EObject> rlElements;
	private HashSet<EObject> rlElementsOriginal;
	private HashSet<EObject> rlBElementsInternal; 
	private HashSet<EObject> rlBElementsExternal;
	private HashSet<EObject> rlElementsInternal;
	private HashMap<ToReplacement, EObject> tRlOtsideMap;
	private HashMap<EObject, HashSet<EObject>> outsideBoundaryInsideBoundariesMap;
	private EList<Object> vertexes;
	
	public ReplacementElementHolder(ReplacementFragment rf) {
		this.vertexes = new BasicEList<Object>();
		this.replacement = rf;
		this.tre = new BasicEList<ToReplacement>();
		this.fre = new BasicEList<FromReplacement>();
		this.frobes =  new BasicEList<EObject>();
		this.rlElements = new HashSet<EObject>();
		this.rlBElementsInternal = new HashSet<EObject>();
		this.rlBElementsExternal = new HashSet<EObject>();
		this.rlElementsInternal = new HashSet<EObject>();
		this.tRlOtsideMap = new HashMap<ToReplacement, EObject>();
		this.outsideBoundaryInsideBoundariesMap = new HashMap<EObject, HashSet<EObject>>();
		this.locate();
		this.rlElementsOriginal = new HashSet<EObject>(rlElements);
		this.frobesOriginal = new BasicEList<EObject>(this.frobes);
		this.findOutsideBoundaryElementsReplacement();
		this.printStat();
	}

	private void printStat() {
		System.out.println("************************************");
		System.out.println("Replacements fragment :" + replacement);
		System.out.println("Elements " + this.getElements());
		System.out.println("Internal boundary elements " + this.getBElementsInternal());
		System.out.println("External boundary elements " + this.getBElementsExternal());
		System.out.println("Internal elements " + this.getElementsInternal());
		System.out.println("Map(ToReplacement, outsideBoundaryElement): " + this.getOutsideBoundaryElementMap());
	}
	
	public HashSet<EObject> getElements(){
		return this.rlElementsOriginal;
	}
	
	public HashSet<EObject> getBElementsInternal(){
		return this.rlBElementsInternal;
	}
	
	public HashSet<EObject> getBElementsExternal(){
		return this.rlBElementsExternal;
	}
	
	public HashSet<EObject> getElementsInternal(){
		return this.rlElementsInternal;
	}
	
	public EList<EObject> getOutsideBoundaryElements(){
		return this.frobesOriginal;
	}
	
	public HashMap<ToReplacement, EObject> getOutsideBoundaryElementMap(){
		return this.tRlOtsideMap;
	}
	
	private void findOutsideBoundaryElementsReplacement(){
		for(ToReplacement tr : this.tre){
			EObject outsideBoundaryElement = this.getOutsideBoundaryElement(tr);
			this.tRlOtsideMap.put(tr, outsideBoundaryElement);
			if(outsideBoundaryElement == null){
				System.out.println("WARNING: can not find outsideBoundaryElement for " + tr);
			}
		}
	}
	
	private EObject getOutsideBoundaryElement(ToReplacement tr){
		Set<EObject> ibesSet = new HashSet<EObject>(Utility.resolveProxies(tr.getInsideBoundaryElement()));
		HashMap<EObject, HashSet<EObject>> linkingOutsideMap = new HashMap<EObject, HashSet<EObject>>();
		HashMap<EObject, EObject> parentOutsidMap = new HashMap<EObject, EObject>();
		
		for(EObject object : ibesSet){
			EObject parentElement = (rlElements.contains(object.eContainer())) ? null : object.eContainer();
			parentOutsidMap.put(object, parentElement);
			Collection<Setting> referencers = EcoreUtil.UsageCrossReferencer.find(object, object.eResource());
			HashSet<EObject> ref = new HashSet<EObject>();
			Iterator<Setting> iterator = referencers.iterator();
			while(iterator.hasNext()){
				ref.add(iterator.next().getEObject());
			}
			SetView<EObject> outsideBoundaryElements = Sets.difference(ref, rlElements);
			linkingOutsideMap.put(object, new HashSet<EObject>(outsideBoundaryElements));
		}
		Collection<HashSet<EObject>> linkingValues = linkingOutsideMap.values();
		Iterator<HashSet<EObject>> iterator = linkingValues.iterator();
		HashSet<EObject> outsideBoundaryElements = iterator.next();
		while(iterator.hasNext()){
			outsideBoundaryElements = new HashSet<EObject>(Sets.intersection(outsideBoundaryElements, iterator.next()));
		}
		if(outsideBoundaryElements.size() > 1){
			System.out.println("Found more the one outsideBoudnaryElement, " + outsideBoundaryElements);
			outsideBoundaryElements = this.chooseOutsideBoundaryElement(outsideBoundaryElements, ibesSet);
			if(outsideBoundaryElements.size() > 1 || outsideBoundaryElements.size() == 0){
				System.out.println("!!!!WARNING: can not choose outsideBoundaryElement for the toReplacement in CrossReferences " + outsideBoundaryElements);
			}
		}
		
		EObject outsideBoundaryElement = (outsideBoundaryElements.size() >= 1) ? outsideBoundaryElements.iterator().next() : null;
		
		Collection<EObject> parentValues = parentOutsidMap.values();
		Iterator<EObject> iter = parentValues.iterator();
		HashSet<EObject> outsideBoundaryElementsParent = new HashSet<EObject>();
		outsideBoundaryElementsParent.add(iter.next());
		while(iter.hasNext()){
			HashSet<EObject> set = new HashSet<EObject>();
			set.add(iter.next());
			outsideBoundaryElementsParent = new HashSet<EObject>(Sets.intersection(outsideBoundaryElementsParent, set));
		}
		
		EObject outsideBoundaryElementParent = (outsideBoundaryElementsParent.size() == 1) ? outsideBoundaryElementsParent.iterator().next() : null;
		
		if(outsideBoundaryElement != null && outsideBoundaryElementParent != null){
			HashSet<EObject> insideBoundaryElements = this.outsideBoundaryInsideBoundariesMap.get(outsideBoundaryElement);
			insideBoundaryElements = (insideBoundaryElements == null) ? new HashSet<EObject>() : insideBoundaryElements;
			if(Sets.symmetricDifference(insideBoundaryElements, ibesSet).isEmpty()){
				return outsideBoundaryElementParent;
			}
			this.outsideBoundaryInsideBoundariesMap.put(outsideBoundaryElement, new HashSet<EObject>(ibesSet));
			return outsideBoundaryElement;
		}
		
		if(outsideBoundaryElement != null){
			return outsideBoundaryElement;
		}
		
		if(outsideBoundaryElementParent != null){
			return outsideBoundaryElementParent;
		}
		
		return null;
	}
	
	private HashSet<EObject> chooseOutsideBoundaryElement(HashSet<EObject> outsideBoundaryElements, Set<EObject> ibesSet) {
		HashSet<EObject> outsideBoundaryElementsNew = new HashSet<EObject>();
		for(EObject outsideBoundaryElement : outsideBoundaryElements){
			EList<EObject> referenced = outsideBoundaryElement.eCrossReferences();
			SetView<EObject> insideBoundaryElements = Sets.intersection(new HashSet<EObject>(referenced), this.rlElements);
			if(Sets.symmetricDifference(ibesSet, insideBoundaryElements).isEmpty()){
				outsideBoundaryElementsNew.add(outsideBoundaryElement);
			}
		}
		return outsideBoundaryElementsNew;
	}

	private void locate() {
		EList<ReplacementBoundaryElement> rbes = this.replacement.getBoundaryElement();
		for(ReplacementBoundaryElement rbe : rbes){
			if(rbe instanceof ToReplacement){
				this.tre.add((ToReplacement) rbe);
				this.rlBElementsInternal.addAll(Utility.resolveProxies(((ToReplacement) rbe).getInsideBoundaryElement()));
			}
			if(rbe instanceof FromReplacement){
				this.fre.add((FromReplacement) rbe);
				this.rlBElementsExternal.add(Utility.resolveProxies(((FromReplacement) rbe).getInsideBoundaryElement()));
				this.frobes.addAll(Utility.resolveProxies(((FromReplacement) rbe).getOutsideBoundaryElement()));
			}
		}
		this.findInsideElements();
		this.calculateInternalElements();
		//this.findAllOusideBoundaryElements();
	}


	private void findAllOusideBoundaryElements(){
		Resource r = Utility.resolveProxies(this.tre.get(0).getInsideBoundaryElement()).get(0).eResource();
		TreeIterator<EObject> conts = r.getAllContents();
		EList<EObject> intElements = new BasicEList<EObject>();
		intElements.addAll(this.rlElements);
		while(conts.hasNext()){
			EObject o = conts.next();
			if(this.isReferenceInsideElement(o) && intElements.indexOf(o) < 0){
				this.frobes.add(o);
			}
		}
	}
	
	private boolean isReferenceInsideElement(EObject o){
		HashSet<EObject> references = new HashSet<EObject>(o.eCrossReferences());
		if(!Sets.intersection(references, this.rlElements).isEmpty()){
			return true;
		}
		HashSet<EObject> contents = new HashSet<EObject>(o.eContents());
		if(!Sets.intersection(contents, this.rlElements).isEmpty()){
			return true;
		}
		return false;
	}
	
	private void calculateInternalElements() {
		SetView<EObject> d = Sets.difference(this.rlElements, this.rlBElementsExternal);
		SetView<EObject> d1 = Sets.difference(d, this.rlBElementsInternal);
		this.rlElementsInternal.addAll(d1);
	}


	private void findInsideElements() {
		this.rlElements.addAll(this.rlBElementsInternal);
		this.rlElements.addAll(this.rlBElementsExternal);
		HashSet<EObject> internalBEl = new HashSet<EObject>(this.rlElements);
		this.vertexes.clear();
		for(EObject o : internalBEl){
			this.traversRelation(o);
		}
	}
	
	private void traversRelation(EObject o) {
		if(this.frobes.indexOf(o) < 0 && this.vertexes.indexOf(o) < 0){
			this.rlElements.add(o);
			this.vertexes.add(o);
			EList<EObject> references = o.eCrossReferences();
			for(EObject ref : references){
				this.traversRelation(ref);
			}
			EList<EObject> contents = o.eContents();
			for(EObject con : contents){
				this.traversRelation(con);
			}	
		}
	}

}
