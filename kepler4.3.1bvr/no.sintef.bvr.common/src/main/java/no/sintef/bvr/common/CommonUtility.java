package no.sintef.bvr.common;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectEList;

import com.google.common.base.Throwables;

import bvr.BvrFactory;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public final class CommonUtility {
	
	public static String getStackTraceAsString(Throwable throwable){
		return Throwables.getStackTraceAsString(throwable);
	}
	
	public static final int DERIVED = 0x1;
	public static final int TRANSIENT = 0x2;
	public static final int MASK = 0x1FF; //9 bits are required to encode all properties
	/* 000000000 - ok, 000000001-derived, 000000010 - transient, 000000011 -derived and transient etc*/
	public static int isDerived(EStructuralFeature property){
		int value = 0x0 & MASK;
		/*The value of a derived feature is computed from other
		features, so it doesn't represent any additional object
		state. Framework classes, such as EcoreUtil.Copier,
		that copy model objects will not attempt to copy such
		features. The generated code is unaffected by the value
		of the derived flag. Derived features are typically also
		marked volatile and transient.*/
		int drvd = (property.isDerived()) ? MASK & DERIVED : value;
	
		/*Transient features are used to declare (modeled) data
		whose lifetime never spans application invocations and
		therefore doesn't need to be persisted. The (default XMI)
		serializer will not save features that are declared to be
		transient.*/
		int trnsnt = (property.isTransient()) ? MASK & TRANSIENT : value;
		
		value = drvd | trnsnt;
		return value;
	}
	
	public static int unMask(int value, int umaskValue){
		return value & umaskValue;
	}
	
	public static ObjectHandle testObjectHandle(PlacementFragment placement, EObject eObject){
		EList<ObjectHandle> objectHandles = placement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		placement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
	
	public static ObjectHandle testObjectHandle(ReplacementFragmentType replacement, EObject eObject){
		EList<ObjectHandle> objectHandles = replacement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		replacement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
	
	public static String removeExtension(String s) {

	    String separator = System.getProperty("file.separator");
	    String filename;

	    // Remove the path upto the filename.
	    int lastSeparatorIndex = s.lastIndexOf(separator);
	    if (lastSeparatorIndex == -1) {
	        filename = s;
	    } else {
	        filename = s.substring(lastSeparatorIndex + 1);
	    }

	    // Remove the extension.
	    int extensionIndex = filename.lastIndexOf(".");
	    if (extensionIndex == -1)
	        return filename;

	    return filename.substring(0, extensionIndex);
	}
	
	public static EList<EObject> getReferencedEObjects(EObject eObject){
		EList<EObject> eObjects = new BasicEList<EObject>();
		EList<EReference> references = eObject.eClass().getEAllReferences();
		for(EReference reference : references){
			if(isDerived(reference) != 0)
				continue;
			Object targetObject = eObject.eGet(reference);
			if(targetObject instanceof EObject){
				EObject targetEObject = (EObject) targetObject;
				eObjects.add(targetEObject);
			}else if(targetObject instanceof BasicEList){
				EList<EObject> eEObjects =  (BasicEList<EObject>) targetObject;
				eObjects.addAll(eEObjects);
			}else if(targetObject != null){
				throw new UnsupportedOperationException("an element referenced by " + reference + " is neither EObject nor BasicEList: " + targetObject);
			}
		}
		return eObjects;
	}
	
	public static EList<EObject> getReferencedEObjects(EObject source, EList<EReference> references){
		EList<EObject> eObjects = new BasicEList<EObject>();
		for(EReference reference : references){
			if(isDerived(reference) == 0){
				Object value = source.eGet(reference);
				if(value instanceof EObject){
					eObjects.add((EObject) value);
				}else if (value instanceof EObjectEList){
					eObjects.addAll((EList<? extends EObject>) value);
				}else if(value != null){
					throw new UnsupportedOperationException("reference " + reference + " does not point to EObject nor EObjectList :" + value);
				}
			}
		}
		return eObjects;
	}
}
