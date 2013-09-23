package no.sintef.cvl.engine.testutils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import node.NodePackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Sets;

import cvl.CvlPackage;
import cvl.ObjectHandle;


public class SetUpUtils {

	public static HashMap<String, Object> loadSimple(File file){
		CvlPackage.eINSTANCE.eClass();
		ResourceSetImpl resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("wsdir", wsdir);
		map.put("resSet", resSet);
		map.put("resource", resource);
		return map;
	}
	
	public static HashMap<String, Object> load(File file){
		String path = file.getAbsolutePath();
		path = path.replaceAll(file.getName(), "");
		String wsdir = System.getProperty("user.dir");
		System.setProperty( "user.dir", path);
		CvlPackage.eINSTANCE.eClass();
		ResourceSetImpl resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("wsdir", wsdir);
		map.put("resSet", resSet);
		map.put("resource", resource);
		return map;
	}
	
	public static void tearDown(HashMap<String, Object> map){
		System.setProperty( "user.dir", (String) map.get("wsdir"));
	}
	
	public static HashSet<String> getPropertiesValues(HashSet<EObject> set, String name){
		HashSet<String> props = new HashSet<String>();
		for(EObject obj : set){
			String value = (String) obj.eGet(obj.eClass().getEStructuralFeature(name));
			props.add((value == null) ? "null" : value);
		}
		return props;
	}
	
	public static EList<String> getPropertiesValuesList(HashSet<EObject> set, String name){
		EList<String> props = new BasicEList<String>();
		for(EObject obj : set){
			String value = (String) obj.eGet(obj.eClass().getEStructuralFeature(name));
			props.add((value == null) ? "null" : value);
		}
		return props;
	}
	
	public static <K,V> boolean compareHashMaps(HashMap<K,V> map1, HashMap<K,V> map2){
		if(map1.size() != map2.size()){
			return false;
		}
		for(Map.Entry<K, V> entry : map1.entrySet()){
			K key1 = entry.getKey();
			V value1 = entry.getValue();
			V value2 = map2.get(key1);
			if(!value1.equals(value2)){
				return false;
			}
		}
		return true;
	}
	
	public static <K,V> HashMap<V,K> reverseMap(Map<K,V> map) {
		if(map == null)
			return null;
	    HashMap<V,K> rev = new HashMap<V, K>();
	    for(Map.Entry<K,V> entry : map.entrySet())
	        rev.put(entry.getValue(), entry.getKey());
	    return rev;
	}
	
	public static boolean compareLists(List<EObject> list1, List<EObject> list2){
		HashSet<EObject> set1 = new HashSet<EObject>(list1);
		HashSet<EObject> set2 = new HashSet<EObject>(list2);
		return Sets.symmetricDifference(set1, set2).isEmpty();
	}
	
	public static boolean compareStringLists(List<String> list1, List<String> list2){
		if(list1.size() != list2.size()){
			return false;
		}
		EList<String> listBuf = new BasicEList<String>(list2);
		list1.containsAll(listBuf);
		for(Object element : list1){
			listBuf.remove(element);
		}
		if(listBuf.size() != 0){
			return false;
		}
		return true;
	}
	
	public static void writeToFile(Resource resource, String name) throws IOException{
		resource.setURI(URI.createFileURI(name));
		resource.save(Collections.EMPTY_MAP);
	}
	
	public static boolean isIdenticalEMFCompare(String original, String created){
		File originalFile = new File(original);
		File createdFile = new File(created);
		ResourceSetImpl resSet = new ResourceSetImpl();
		ResourceSetImpl resSet1 = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resSet.getResource(URI.createFileURI(originalFile.getName()), true);
		resSet1.getResource(URI.createFileURI(createdFile.getName()), true);

		IComparisonScope scope = EMFCompare.createDefaultScope(resSet, resSet1);
		Comparison result = EMFCompare.builder().build().compare(scope);
		Iterator<Diff> it = result.getDifferences().iterator();
		return (it.hasNext()) ? false : true;
	}
	
	public static EList<EObject> resolveObjectHandles(EList<ObjectHandle> objectHandles){
		EList<EObject> list = new BasicEList<EObject>();
		for(ObjectHandle oh : objectHandles){
			list.add(oh.getMOFRef());
		}
		return list;
	}
	
	public static EObject resolveObjectHandles(ObjectHandle objectHandles){
		return objectHandles.getMOFRef();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] concatArrays(T[] array1, T[] array2) {
	    final int array1len = array1.length;
	    final int array2len = array2.length;
	    final T[] result = (T[]) java.lang.reflect.Array.newInstance(array1.getClass().getComponentType(), array1len + array2len);
	    System.arraycopy(array1, 0, result, 0, array1len);
	    System.arraycopy(array2, 0, result, array1len, array2len);
	    return result;
	}
	
	public static boolean isIdentical(String original, String created){
		File originalFile = new File(original);
		File createdFile = new File(created);
		ResourceSetImpl resSet = new ResourceSetImpl();
		//ResourceSetImpl resSet1 = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource originalResource = resSet.getResource(URI.createFileURI(originalFile.getAbsolutePath()), true);
		//Resource createdResource = resSet1.getResource(URI.createFileURI(createdFile.getAbsolutePath()), true);
		Resource createdResource = resSet.getResource(URI.createFileURI(createdFile.getAbsolutePath()), true);
		
		EList<EObject> originaElements = new BasicEList<EObject>();
		EList<EObject> createdElements = new BasicEList<EObject>();
		TreeIterator<EObject> originalTreeElements = originalResource.getAllContents();
		TreeIterator<EObject> createdTreeElements = createdResource.getAllContents();

		while(originalTreeElements.hasNext())
			originaElements.add(originalTreeElements.next());
		
		while(createdTreeElements.hasNext())
			createdElements.add(createdTreeElements.next());
		
		if(originaElements.size() != createdElements.size())
			return false;
		
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

		if(!originaElements.isEmpty() || !createdElements.isEmpty())
			return false;
		return true;
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
