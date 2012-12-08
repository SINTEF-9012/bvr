package no.sintef.cvl.engine.converters.common;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cvl.ConfigurableUnit;
import cvl.cvlFactory;
import cvl.cvlPackage;

public class CVLModelNew {
	
	private ResourceSet resSet;

	public CVLModelNew(ResourceSet resSet) {
		this.resSet = resSet;
	}

	public ConfigurableUnit load(File file){
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		//ResourceSet resSet = new ResourceSetImpl();
		//Resource resource = resSet.getResource(URI.createURI("file:///" + file.getAbsolutePath()), true);
		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		ConfigurableUnit cu = (ConfigurableUnit) resource.getContents().get(0);
		return cu;
	}
	
	public ConfigurableUnit creat(){
		cvlPackage.eINSTANCE.eClass();
		cvlFactory factory = cvlFactory.eINSTANCE;
		ConfigurableUnit cu = factory.createConfigurableUnit();
		return cu;
	}
	
	public void writeToFile(File file, ConfigurableUnit cu) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    //Resource resource = resSet.createResource(URI.createURI("file:///" + file.getAbsolutePath()));
	    Resource resource = resSet.createResource(URI.createFileURI(file.getName()));
	    resource.getContents().add(cu);
	    resource.save(Collections.EMPTY_MAP);
	}
}
