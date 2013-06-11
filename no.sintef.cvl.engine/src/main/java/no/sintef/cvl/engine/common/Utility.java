package no.sintef.cvl.engine.common;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.error.UnexpectedOperationFailure;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.FromPlacement;
import cvl.ObjectHandle;
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
	
	public static EList<ObjectHandle> getObjectHandlesByEObjects(FragmentSubstitution fragSub, EList<EObject> eObjectList) {
		EList<ObjectHandle> objectHandles = new BasicEList<ObjectHandle>();
		EList<ObjectHandle> objectHandlesAll = fragSub.getSourceObject();
		for(EObject eObject : eObjectList){
			ObjectHandle oh = getObjectHandle(eObject, objectHandlesAll);
			if(oh == null){
				oh = factory.createObjectHandle();
				oh.setMOFRef(eObject);
				fragSub.getSourceObject().add(oh);
			}
			objectHandles.add(oh);
		}
		return objectHandles;
	}
	
	private static ObjectHandle getObjectHandle(EObject eObject, EList<ObjectHandle> objectHandles){
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
	
	public static void writeToFile(Resource resource, String name) throws IOException{
		resource.setURI(URI.createFileURI(name));
		resource.save(Collections.EMPTY_MAP);
	}
}
