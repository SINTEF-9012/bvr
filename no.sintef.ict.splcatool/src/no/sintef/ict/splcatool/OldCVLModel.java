package no.sintef.ict.splcatool;

import java.io.File;

import oldcvl.VariabilitySpecification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cvl.CVSpec;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentSpecification;
import cvl.cvlFactory;


public class OldCVLModel {
	private oldcvl.CVLModel m;
	private ConfigurableUnit cu;

	public OldCVLModel(File f) {
		oldcvl.CvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI("file:///" + f.getAbsolutePath()), true);
		m = (oldcvl.CVLModel)resource.getContents().get(0);
	}

	public CVLModel getNewCVL() {
		CVLModel newm = new CVLModel();
		cu = newm.getCU();
		
		convert(cu, m);
		
		return newm;
	}

	private void convert(ConfigurableUnit cu, oldcvl.CVLModel m) {
		cu.setName(m.getName());
		
		CVSpec x = cvlFactory.eINSTANCE.createCVSpec();
		cu.getOwnedVSpec().add(x);
		
		convertVSpec(x, (oldcvl.CompositeVariability)m.getVariabilitySpecification());
	}

	private void convertVSpec(CVSpec vspec, oldcvl.CompositeVariability oldvspec) {
		vspec.setName(oldvspec.getName());
		
		for(EObject vs : oldvspec.eContents()){
			System.out.println(vs.getClass());
			if(vs instanceof oldcvl.impl.CompositeVariabilityImpl){
				CVSpec x = cvlFactory.eINSTANCE.createCVSpec();
				vspec.getChild().add(x);
				convertVSpec(x, (oldcvl.CompositeVariability)vs);
			}else if(vs instanceof oldcvl.PlacementFragment){
				PlacementFragment x = cvlFactory.eINSTANCE.createPlacementFragment();
				x.setName(((oldcvl.PlacementFragment) vs).getName());
				cu.getOwnedVariationPoint().add(x);
			}else if(vs instanceof oldcvl.ReplacementFragment){
				//ReplacementFragmentSpecification x = cvlFactory.eINSTANCE.createReplacementFragmentType();
				//cu.getOwnedVariationPoint().add(x);
			}else if(vs instanceof oldcvl.FragmentSubstitution){
				FragmentSubstitution x = cvlFactory.eINSTANCE.createFragmentSubstitution();
				x.setName(((oldcvl.FragmentSubstitution) vs).getName());
				cu.getOwnedVariationPoint().add(x);
			}
		}
	}

}
