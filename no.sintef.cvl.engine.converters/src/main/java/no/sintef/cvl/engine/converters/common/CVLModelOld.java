package no.sintef.cvl.engine.converters.common;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import no.sintef.dsl.node.nodePackage;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ProxyCrossReferencer;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.variabilitymodeling.cvl.CVLModel;
import org.variabilitymodeling.cvl.CvlPackage;

import ari.ariPackage;

public class CVLModelOld {
	
	
	private ResourceSet resSet;

	public CVLModelOld(ResourceSet resSet) {
		this.resSet = resSet;
	}

	public CVLModel load(File file) throws IOException{
		CvlPackage.eINSTANCE.eClass();
		//nodePackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		CVLModel cv = (CVLModel) resource.getContents().get(0);
		//this.checkCross(resSet);
		return cv;
	}
	
	private void checkCross(ResourceSet resourceSet){
		int counter = 0;
		Map map = ProxyCrossReferencer.find(resourceSet);
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
