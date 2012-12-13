package no.sintef.cvl.engine.fragment;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.PlacementBoundaryElement;
import cvl.ToPlacement;
import cvl.VariationPoint;
import cvl.cvlPackage;

public class PlacementElementHolder {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		File file = new File("src/test/resources/node6/node.new.cvl");
		String path = file.getAbsolutePath();
		path = path.replaceAll(file.getName(), "");
		System.setProperty( "user.dir", path);
		cvlPackage.eINSTANCE.eClass();
		//nodePackage.eINSTANCE.eClass();
		ResourceSetImpl resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		ConfigurableUnit cu = (ConfigurableUnit) resource.getContents().get(0);
		System.out.println(cu);
		
		FragmentSubstitution fragSub = null;
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSub = (FragmentSubstitution) vp;
				break;
			}
		}
		System.out.println(fragSub);
		
		List<EObject> tbe = new BasicEList<EObject>();
		EList<PlacementBoundaryElement> pbes = fragSub.getPlacement().getPlacementBoundaryElement();
		for(PlacementBoundaryElement pbe : pbes){
			if(pbe instanceof ToPlacement){
				tbe.add((ToPlacement)pbe);
				//System.out.println(frBElementsInternal);
				EList<EObject> l = ((ToPlacement)pbe).getInsideBoundaryElement();
				System.out.println(l);
				HashSet<EObject> hs = new HashSet<EObject>();
				System.out.println("??????????????????????????????????");
				System.out.println(l);
				System.out.println(l.get(0));
				hs.add(l.get(0));
				//frBElementsInternal.add(l.get(0));
				System.out.println("************************");
			}
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
