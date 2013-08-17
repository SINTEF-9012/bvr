package no.sintef.cvl.common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Throwables;

import cvl.CvlFactory;
import cvl.ObjectHandle;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

public final class Utility {
	
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
		ObjectHandle objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
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
		ObjectHandle objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		replacement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
}
