package no.sintef.ict.splcatool;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.VSpec;

public class CVLModel {
	protected ConfigurableUnit cu;
	//protected VSpec c;

	public void writeToFile(String filename) throws IOException {
/*		EPackage.Registry.INSTANCE.put(cvlPackage.eNS_URI, cvlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("cvl", cvlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
*/
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.createResource(URI.createURI("file:///" + filename));
	    resource.getContents().add(cu);
	    resource.save(Collections.EMPTY_MAP);
	}
}
