package no.sintef.cvl.engine.testutils;

import java.io.File;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
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
	
}
