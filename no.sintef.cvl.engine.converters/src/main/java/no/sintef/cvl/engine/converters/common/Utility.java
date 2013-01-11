package no.sintef.cvl.engine.converters.common;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FragmentSubstitution;
import cvl.ObjectHandle;
import cvl.cvlFactory;

public class Utility {
	private static cvlFactory factory = cvlFactory.eINSTANCE;

	public static EList<EObject> resolveProxies(EList<? extends EObject> proxyList){
		EList<EObject> resolvedList = new BasicEList<EObject>();
		for(EObject proxy : proxyList){
			EObject resolvedProxy = null;
			if(proxy instanceof ObjectHandle){
				resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
			}else{
				resolvedProxy = proxy;
			}
			resolvedList.add(resolvedProxy);
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
	
	public static EList<ObjectHandle> getObjectHandlesByEObjects(FragmentSubstitution fragSub, EList<EObject> eObjectList){
		EList<ObjectHandle> objectHandles = new BasicEList<ObjectHandle>();
		EList<ObjectHandle> objectHandlesAll = fragSub.getSourceObject();
		for(EObject eObject : eObjectList){
			ObjectHandle oh = getObjectHandle(eObject, objectHandlesAll);
			if(oh == null){
				oh = factory.createObjectHandle();
				oh.setMOFRef(eObject);
			}
			objectHandles.add(oh);
		}
		return objectHandles;
	}
	
	private static ObjectHandle getObjectHandle(EObject eObject, EList<ObjectHandle> objectHandles){
		for(ObjectHandle oh : objectHandles){
			if(oh.getMOFRef().equals(eObject)){
				return oh;
			}
		}
		return null;
	}
}
