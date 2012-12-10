package no.sintef.cvl.engine.converters.common;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ProxyCrossReferencer;
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
		this.checkCross(resSet);
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
	
	private void checkCross(ResourceSet resourceSet){
		int counter = 0;
		Map map = ProxyCrossReferencer.find(resourceSet);
		System.out.println(map);
		for (Iterator i = map.entrySet().iterator(); i.hasNext();){
			Map.Entry entry = (Map.Entry)i.next();
			EObject proxyEObject = (EObject)entry.getKey();
			System.out.println("" + ++counter + ". " + EcoreUtil.getURI(proxyEObject));
			System.out.println(proxyEObject);
			//System.out.println(EcoreUtil.resolve(proxyEObject, resourceSet));
			EObject obj = EcoreUtil.resolve(proxyEObject, resourceSet);
			System.out.println(obj);
			System.out.println(((InternalEObject) obj).eProxyURI());
			System.out.println("Is prox: " + proxyEObject.eIsProxy());
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(proxyEObject);
			System.out.println(diagnostic.getSeverity() == Diagnostic.OK);
		}
	}
}
