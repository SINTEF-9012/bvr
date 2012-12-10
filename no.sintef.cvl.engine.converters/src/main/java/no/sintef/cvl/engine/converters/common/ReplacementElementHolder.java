package no.sintef.cvl.engine.converters.common;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
	
	
	public ReplacementElementHolder(ReplacementFragment rf) {
		this.replacement = rf;
		this.tre = new BasicEList<ToReplacement>();
		this.fre = new BasicEList<FromReplacement>();
		this.frobes =  new BasicEList<EObject>();
		this.rlElements = new HashSet<EObject>();
		this.rlBElementsInternal = new HashSet<EObject>();
		this.rlBElementsExternal = new HashSet<EObject>();
		this.rlElementsInternal = new HashSet<EObject>();
		this.tRlOtsideMap = new HashMap<ToReplacement, EObject>();
		this.locate();
		this.rlElementsOriginal = new HashSet<EObject>(rlElements);
		this.frobesOriginal = new BasicEList<EObject>(this.frobes);
		this.findOutsideBoundaryElementsReplacement();
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
		Set<EObject> ibesSet = new HashSet<EObject>(tr.getInsideBoundaryElement());
		for(EObject obe : this.frobes){
			HashSet<EObject> refs = this.getAllReferences(obe);
			Set<Set<EObject>> powerSet = Sets.powerSet(refs);
			if(powerSet.contains(ibesSet)){
				this.frobes.remove(obe);
				return obe;
			}
		}
		return null;
	}
	
	private HashSet<EObject> getAllReferences(EObject obj){
		HashSet<EObject> refs = new HashSet<EObject>();
		refs.addAll(obj.eCrossReferences());
		refs.addAll(obj.eContents());
		return refs;
	}
	
	private void locate() {
		EList<ReplacementBoundaryElement> rbes = this.replacement.getBoundaryElement();
		for(ReplacementBoundaryElement rbe : rbes){
			if(rbe instanceof ToReplacement){
				this.tre.add((ToReplacement) rbe);
				this.rlBElementsInternal.addAll(((ToReplacement) rbe).getInsideBoundaryElement());
			}
			if(rbe instanceof FromReplacement){
				this.fre.add((FromReplacement) rbe);
				this.rlBElementsExternal.add(((FromReplacement) rbe).getInsideBoundaryElement());
				this.frobes.addAll(((FromReplacement) rbe).getOutsideBoundaryElement());
			}
		}
		this.findInsideElements();
		this.calculateInternalElements();
		this.findAllOusideBoundaryElements();
	}


	private void findAllOusideBoundaryElements(){
		//have not found method that can return inwards references to an object, i believe it is possible to find...,
		//but so far do that
		Resource r = this.tre.get(0).getInsideBoundaryElement().get(0).eResource();
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
		for(EObject o : internalBEl){
			this.traversRelation(o);
		}
	}
	
	private void traversRelation(EObject o) {
		if(this.frobes.indexOf(o) < 0){
			this.rlElements.add(o);
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
