package no.sintef.cvl.engine.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;
import cvl.cvlPackage;

public class RunEngine {

	
	public void execute(URI uri, URI base){
		UMLPackage.eINSTANCE.eClass();
		
		ConfigurableUnit cu = loadCVL(uri);
		
		List<FragmentSubstitution> fragSubs = new BasicEList<FragmentSubstitution>(); 
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
			}
		}
		
		FragmentSubstitutionHolder fragmentSubHolder1;
		FragmentSubstitutionHolder fragmentSubHolder2;
		try {
			fragmentSubHolder1 = new FragmentSubstitutionHolder(fragSubs.get(0));
			fragmentSubHolder2 = new FragmentSubstitutionHolder(fragSubs.get(1));
		} catch (BasicCVLEngineException e) {
			e.printStackTrace();
			return;
		}
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
		fragmentSubHolderList.add(fragmentSubHolder2);
		System.out.println(fragmentSubHolder1.getPlacement().getElements());
		System.out.println(fragmentSubHolder2.getPlacement().getOuterFragmentElements());
		
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		System.out.println(adjacenFinder.getAdjacentMap());
		
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		try {
			fso1.execute(true);
			adjacentResolver.resolve(fragmentSubHolder1);
		} catch (BasicCVLEngineException e1) {
			e1.printStackTrace();
			return;
		}
		
		Resource baseModel = cu.eResource().getResourceSet().getResource(base, false);
		if(baseModel == null){
			System.out.println("can not get a base model by uri " + base);
			return;
		}
		
		try {
			Utility.writeToFile(baseModel, "model_new.uml");
		} catch (IOException e) {
			System.out.println("failed to write a file");
			e.printStackTrace();
		}
	}
	
	private ConfigurableUnit loadCVL(URI uri) {
		cvlPackage.eINSTANCE.eClass();
		ResourceSet resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(uri, true);
		ConfigurableUnit cu = (ConfigurableUnit) resource.getContents().get(0);
		return cu;
	}
}
