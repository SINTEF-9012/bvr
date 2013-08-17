package no.sintef.cvl.engine.common;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;

public class Utility {
	private static CvlFactory factory = CvlFactory.eINSTANCE;

	public static EList<EObject> resolveProxies(EList<? extends EObject> proxyList){
		EList<EObject> resolvedList = new BasicEList<EObject>();
		for(EObject proxy : proxyList){
			EObject resolvedProxy = null;
			if(proxy instanceof ObjectHandle){
				resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
			}else{
				resolvedProxy = proxy;
			}
			if(resolvedProxy != null){
				resolvedList.add(resolvedProxy);
			}
		}
		return resolvedList;
	}
	
	public static EObject resolveProxies(EObject proxy){
		EObject resolvedProxy = null;
		if(proxy instanceof ObjectHandle){
			resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
		}else{
			resolvedProxy = proxy;
		}
		return resolvedProxy;
	}
	
	public static EList<ObjectHandle> getPlacementObjectHandlesByEObjects(PlacementFragment placement, EList<EObject> eObjectList) {
		EList<ObjectHandle> objectHandles = new BasicEList<ObjectHandle>();
		EList<ObjectHandle> objectHandlesAll = placement.getSourceObject();
		for(EObject eObject : eObjectList){
			ObjectHandle oh = getObjectHandle(eObject, objectHandlesAll);
			if(oh == null){
				oh = factory.createObjectHandle();
				oh.setMOFRef(eObject);
				placement.getSourceObject().add(oh);
			}
			objectHandles.add(oh);
		}
		return objectHandles;
	}
	
	public static EList<ObjectHandle> getReplacementObjectHandlesByEObjects(ReplacementFragmentType replacement, EList<EObject> eObjectList) {
		EList<ObjectHandle> objectHandles = new BasicEList<ObjectHandle>();
		EList<ObjectHandle> objectHandlesAll = replacement.getSourceObject();
		for(EObject eObject : eObjectList){
			ObjectHandle oh = getObjectHandle(eObject, objectHandlesAll);
			if(oh == null){
				oh = factory.createObjectHandle();
				oh.setMOFRef(eObject);
				replacement.getSourceObject().add(oh);
			}
			objectHandles.add(oh);
		}
		return objectHandles;
	}
		
	public static ObjectHandle getObjectHandle(EObject eObject, EList<ObjectHandle> objectHandles){
		for(ObjectHandle oh : objectHandles){
			EObject eObjectBuf = oh.getMOFRef();
			if((eObjectBuf == null && eObjectBuf == eObject) || (eObjectBuf !=null && eObjectBuf.equals(eObject))){
				return oh;
			}
		}
		return null;
	}
	
	public static EList<EObject> getListPropertyValue(EObject holder, EStructuralFeature property) throws GeneralCVLEngineException{
		Object propertyValue = holder.eGet(property);
		if(!(propertyValue instanceof EList)){
			throw new GeneralCVLEngineException("property is not the list " + propertyValue);
		}
		@SuppressWarnings("unchecked") EList<EObject> eList = (EList<EObject>) propertyValue;
		return eList;
	}
	
	public static EList<EObject> subtractAugmentList(EList<EObject> elementsOrig, EList<EObject> elementsToRemove, EList<EObject> elementsToAdd){
		EList<EObject> eList = new BasicEList<EObject>(elementsOrig);
		eList.removeAll(elementsToRemove);
		for(EObject eObject : elementsToAdd){
			if(!eList.contains(eObject)){
				eList.add(eObject);
			}
		}
		return eList;
	}
	
	public static <K,V> HashMap<V,K> reverseMap(Map<K,V> map) {
		if(map == null)
			return null;
	    HashMap<V,K> rev = new HashMap<V, K>();
	    for(Map.Entry<K,V> entry : map.entrySet())
	        rev.put(entry.getValue(), entry.getKey());
	    return rev;
	}
	
	public static boolean isDummyToReplacement(ToReplacement toReplacement){
		EList<ObjectHandle> insideBoundaryElements = toReplacement.getInsideBoundaryElement();
		ObjectHandle outsideBoundaryElement = toReplacement.getOutsideBoundaryElement();
		if(insideBoundaryElements.size() == 1 && outsideBoundaryElement.equals(insideBoundaryElements.get(0)) && outsideBoundaryElement.getMOFRef() == null){
			return true;
		}
		return false;
	}

	public static boolean isDummyFromPlacement(FromPlacement fromPlacement) {
		ObjectHandle insideBoundaryElement = fromPlacement.getInsideBoundaryElement();
		EList<ObjectHandle> outsideBoundaryelements = fromPlacement.getOutsideBoundaryElement();
		if(outsideBoundaryelements.size() == 1 && insideBoundaryElement.equals(outsideBoundaryelements.get(0)) && insideBoundaryElement.getMOFRef() == null){
			return true;
		}
		return false;
	}
	
	public static HashSet<EObject> clearSet(HashSet<EObject> set){
		if(set.contains(null)){
			set.remove(null);
		}
		return set;
	}
	
	public static void setProperty(EList<EObject> original, EList<EObject> toRemove, EList<EObject> toAdd){
		for(EObject eObject : toRemove){
			original.remove(eObject);
		}
		original.addAll(toAdd);
	}
	
	public static EList<HashMap> caluclateReplacementPlacementIntersections(EList<FragmentSubstitution> fragSubs){
		HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> mapReplcmPlacm = new HashMap<ReplacementFragmentType, HashSet<PlacementFragment>>();
		HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> mapPlcmReplcm = new HashMap<PlacementFragment, HashSet<ReplacementFragmentType>>();
		HashSet<ReplacementFragmentType> replacements = new HashSet<ReplacementFragmentType>();
		HashSet<PlacementFragment> placements = new HashSet<PlacementFragment>();
		for(FragmentSubstitution fs : fragSubs){
			placements.add(fs.getPlacement());
			replacements.add(fs.getReplacement());
		}
		for(ReplacementFragmentType replacement : replacements){
			for(PlacementFragment placement : placements){
				if(testPlacementIntersection(replacement, placement) == CNTND){
					HashSet<PlacementFragment> plcmntList = mapReplcmPlacm.get(replacement);
					if(plcmntList == null){
						plcmntList = new HashSet<PlacementFragment>();
						plcmntList.add(placement);
						mapReplcmPlacm.put(replacement, plcmntList);
					}else{
						plcmntList.add(placement);
					}
					
					HashSet<ReplacementFragmentType> replcmList = mapPlcmReplcm.get(placement);
					if(replcmList == null){
						replcmList = new HashSet<ReplacementFragmentType>();
						replcmList.add(replacement);
						mapPlcmReplcm.put(placement, replcmList);
					}else{
						replcmList.add(replacement);
					}
				}
			}
		}
		EList<HashMap> maps = new BasicEList<HashMap>();
		maps.add(mapReplcmPlacm);
		maps.add(mapPlcmReplcm);
		return maps;
	}
	
	static final int NOT_CNTND = 0; //a placement is not contained in the replacement
	static final int CNTND = 1; // a placement is contained in the replacement
	static final int P_CNTND = 2; // a placement is not fully contained in the replacement
	public static int testPlacementIntersection(ReplacementFragmentType replcnt, PlacementFragment plcnt){
		ReplacementElementHolder replcntHolder;
		PlacementElementHolder plcntHolder;
		try {
			replcntHolder = new ReplacementElementHolder(replcnt);
			plcntHolder = new PlacementElementHolder(plcnt);
		} catch (BasicCVLEngineException e) {
			return NOT_CNTND;
		}
		HashSet<EObject> plcntElements = plcntHolder.getElements();
		HashSet<EObject> replntElements = replcntHolder.getElements();
		SetView<EObject> difference = Sets.difference(plcntElements, replntElements);
		if(difference.isEmpty()){
			return CNTND;
		}
		difference = Sets.difference(plcntElements, difference);
		if(!difference.isEmpty())
			return P_CNTND;
		return NOT_CNTND;
	}
	
	//DEPRICATED
	public static void setProperty(EObject targetEObject, EStructuralFeature feature, EList<EObject> values){
		targetEObject.eSet(feature, values);
	}
	
	public static void setProperty(EObject targetEObject, EStructuralFeature feature, Object value){
		targetEObject.eSet(feature, value);
	}
}
