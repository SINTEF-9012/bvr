package no.sintef.bvr.testutils.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class TestUtils {
	
	public static boolean isEObjectTreesIdentical(EObject srcObject, EObject trgEObject) {
		List<List<EObject>> result = compareEObjectTreesIdentical(srcObject, trgEObject);
		return (result.get(0).isEmpty() && result.get(1).isEmpty()) ? true : false;
	}
	
	public static List<List<EObject>> compareEObjectTreesIdentical(EObject srcObject, EObject trgEObject) {
		EList<EObject> originaElements = new BasicEList<EObject>();
		EList<EObject> createdElements = new BasicEList<EObject>();
		originaElements.add(srcObject);
		createdElements.add(trgEObject);
		
		TreeIterator<EObject> originalTreeElements = srcObject.eAllContents();
		TreeIterator<EObject> createdTreeElements = trgEObject.eAllContents();

		while(originalTreeElements.hasNext())
			originaElements.add(originalTreeElements.next());
		
		while(createdTreeElements.hasNext())
			createdElements.add(createdTreeElements.next());
		
		List<List<EObject>> result = new ArrayList<List<EObject>>();
		
		if(originaElements.size() != createdElements.size()) {
			result.add(originaElements);
			result.add(createdElements);
			return result;
		}
		
		EList<EObject> originalIterator = new BasicEList<EObject>(originaElements);
		for(EObject originalEObject : originalIterator){
			Iterator<EObject> createdIterator = createdElements.iterator();
			while(createdIterator.hasNext()){
				EObject copiedEObject = createdIterator.next();
				if(compareEObject(originalEObject, copiedEObject)){
					createdElements.remove(copiedEObject);
					originaElements.remove(originalEObject);
					break;
				}
			}
		}
		
		result.add(originaElements);
		result.add(createdElements);
		return result;
	}
	
	public static boolean compareEObject(EObject originalEObject, EObject copiedEObject){
		if(!originalEObject.eClass().equals(copiedEObject.eClass()))
			return false;
		EList<EReference> originalReferences = originalEObject.eClass().getEAllReferences();
		EList<EReference> copiedReferences = copiedEObject.eClass().getEAllReferences();
		if(originalReferences.size() != copiedReferences.size())
			return false;
		for(EReference reference : originalReferences){
			if(copiedReferences.indexOf(reference) < 0)
				return false;
		}
		EList<EAttribute> originalAttributes = originalEObject.eClass().getEAllAttributes();
		EList<EAttribute> copiedAttributes = copiedEObject.eClass().getEAllAttributes();
		if(originalAttributes.size() != copiedAttributes.size())
			return false;
		for(EAttribute attribute : originalAttributes){
			if(copiedAttributes.indexOf(attribute) < 0)
				return false;
			Object originalValue = originalEObject.eGet(attribute);
			Object copiedValue = copiedEObject.eGet(attribute);
			if(originalValue != null && !originalValue.equals(copiedValue)){
				return false;
			}else if(originalValue == null && copiedValue != null){
				return false;
			}
		}
		
		return true;
	}
}