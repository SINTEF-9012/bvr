package no.sintef.cvl.engine.operation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.testutils.SetUpUtils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;

public class FragmentSubstitutionTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static ConfigurableUnit cu;
	private static FragmentSubstitution fragSub;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		file = new File("src/test/resources/node6/node.new.cvl");
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSub = (FragmentSubstitution) vp;
				break;
			}
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SetUpUtils.tearDown(map);
	}

	private ReplacementElementHolder replacement;
	private PlacementElementHolder placement;
	private Resource baseModel;

	@Before
	public void setUp() throws Exception {
		Assert.assertNotNull("can not locate a fragment substitution, the test can not be executed", fragSub);
		placement = new PlacementElementHolder(fragSub);
		replacement = new ReplacementElementHolder(fragSub);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
		
		EList<EObject> contents = baseModel.getContents().get(0).eContents();
		EObject object = contents.get(0);
		EObject object1 = contents.get(1);
		EStructuralFeature st = object.eClass().getEStructuralFeature("name");
		Object value = object.eGet(object.eClass().getEStructuralFeature("name"));
		object1.eSet(st, value);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			SetUpUtils.writeToFile(baseModel, "base_new.node");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(SetUpUtils.isIdentical("prod0.node", "prod0.node"));
		System.out.println(SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}

}
