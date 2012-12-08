package no.sintef.cvl.engine.converters.common;

import java.util.ArrayList;
import java.util.HashSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.FromPlacement;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.PlacementFragment;
import org.variabilitymodeling.cvl.ToPlacement;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class PlacementElementHolder {
	
	private EList<ToPlacement> tbe;
	private EList<FromPlacement> fbe;
	private EList<EObject> fpobes;
	private HashSet<EObject> plElements;
	private HashSet<EObject> plElementsOriginal;
	private HashSet<EObject> plBElementsInternal; 
	private HashSet<EObject> plBElementsExternal;
	private HashSet<EObject> plElementsInternal;
	
	public PlacementElementHolder(PlacementFragment pf) {
		tbe = new BasicEList<ToPlacement>();
		fbe = new BasicEList<FromPlacement>();
		fpobes = new BasicEList<EObject>();
		plElements = new HashSet<EObject>();
		plBElementsInternal = new HashSet<EObject>();
		plBElementsExternal = new HashSet<EObject>();
		plElementsInternal = new HashSet<EObject>();
		this.locate(pf);
		plElementsOriginal = new HashSet<EObject>(plElements);
		this.calculatePlElementsInternal();	
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
	
	private void locate(PlacementFragment pf){
		EList<PlacementBoundaryElement> pbes = pf.getBoundaryElement();
		System.out.println(pbes);
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
			}
			if(pbe instanceof FromPlacement){
				fbe.add((FromPlacement) pbe);
				fpobes.addAll(((FromPlacement) pbe).getOutsideBoundaryElement());
			}
		}
		this.calculatePlBElementsInternal();
		this.findAllElements(Lists.newArrayList(plBElementsInternal.iterator()));
	}
		
	private void calculatePlElementsInternal(){
		HashSet<EObject> pbes = new HashSet<EObject>(plBElementsInternal);
		pbes.addAll(plBElementsExternal);
		plElementsInternal.addAll(Sets.difference(plElementsOriginal, pbes));
	}
	
	private void calculatePlBElementsInternal(){
		for(ToPlacement tp : tbe){
			EList<EObject> ibes = tp.getInsideBoundaryElement();
			System.out.println(ibes);
			plBElementsInternal.addAll(ibes);
		}
	}

	private void findAllElements(ArrayList<EObject> arrayList) {
		for(EObject o : arrayList){
			this.traversRelation(o);
		}
		
	}

	private void traversRelation(EObject o) {
		if(fpobes.indexOf(o) < 0){
			plElements.add(o);
			EList<EObject> references = o.eCrossReferences();
			for(EObject ref : references){
				this.addPlBElementsExternal(o, ref);
				this.traversRelation(ref);
			}
			EList<EObject> contents = o.eContents();
			for(EObject con : contents){
				this.addPlBElementsExternal(o, con);
				this.traversRelation(con);
			}	
		}
	}
	
	private void addPlBElementsExternal(EObject o, EObject ref){
		if(fpobes.indexOf(ref) >= 0){
			plBElementsExternal.add(o);
		}
	}
}
