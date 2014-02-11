package org.bangbangbang.cvl.system.vspec.custom.relation;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bangbangbang.cvl.VPackageable;
import org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationFactory;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class RelationHolder {
	private static RelationHolder self;
	private static Map<URI, CVLReference> models;

	private RelationHolder() {

	}

	private static void init() {
		self = new RelationHolder();
		models = new HashMap<URI, CVLReference>();
	}

	public static void load(URI key, IPath filepath) {
		if (self == null) {
			init();
		}

		// Initialize the model
		RelationPackage.eINSTANCE.eClass();

		// Register the XMI resource factory for the .sim extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(
				URI.createURI(filepath.toPortableString()), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		models.put(key, (CVLReference) resource.getContents().get(0));
	}

	public static void createEmpty(URI key, VPackageable vp) {
		if (self == null) {
			init();
		}
		models.put(key, RelationFactory.eINSTANCE.createCVLReference());
		models.get(key).setCvl(vp);
	}

	public static void save(URI key, IPath filepath) {
		if (self == null) {
			init();
		}
		// Register the XMI resource factory for the .sim extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		Resource resource = resSet.createResource(URI.createURI(filepath
				.toPortableString()));
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(models.get(key));

		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static CVLReference getModel(URI key) {
		if (self == null) {
			init();
		}
		return models.get(key);
	}
}
