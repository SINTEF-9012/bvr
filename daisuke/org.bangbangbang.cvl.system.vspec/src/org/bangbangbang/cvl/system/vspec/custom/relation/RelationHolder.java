package org.bangbangbang.cvl.system.vspec.custom.relation;

import java.io.IOException;
import java.util.Collections;
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
	public static RelationHolder self;
	public static CVLReference model;

	private RelationHolder() {
		self = new RelationHolder();
	}

	public static void load(IPath filepath) {
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
		model = (CVLReference) resource.getContents().get(0);
	}

	public static void createEmpty(VPackageable vp) {
		model = RelationFactory.eINSTANCE.createCVLReference();
		model.setCvl(vp);
	}

	public static void save(IPath filepath) {
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
		resource.getContents().add(model);

		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
