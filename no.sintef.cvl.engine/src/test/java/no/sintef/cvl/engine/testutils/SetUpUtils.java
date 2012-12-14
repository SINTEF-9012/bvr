package no.sintef.cvl.engine.testutils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import cvl.cvlPackage;


public class SetUpUtils {

	public static HashMap<String, Object> load(File file){
		String path = file.getAbsolutePath();
		path = path.replaceAll(file.getName(), "");
		String wsdir = System.getProperty("user.dir");
		System.setProperty( "user.dir", path);
		cvlPackage.eINSTANCE.eClass();
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
	
	public static void writeToFile(Resource resource, String name) throws IOException{
		resource.setURI(URI.createFileURI(name));
		resource.save(Collections.EMPTY_MAP);
	}
	
	public static boolean isIdentical(String original, String created){
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
	

	
}
