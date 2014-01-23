package no.sintef.bvr.engine.operation;

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.fragment.impl.PlacementElementHolder;
import no.sintef.bvr.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.bvr.engine.operation.impl.FragmentSubOperation;
import no.sintef.bvr.engine.testutils.SetUpUtils;
import node.NodePackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class FragmentSubstitutionContainment1Test {

	private static File file;
	private static HashMap<String, Object> map;
	private static ConfigurableUnit cu;
	private static FragmentSubstitution fragSub;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder;

	@Before
	public void setUp() throws Exception {
		file = new File("src/test/resources/nodeContainment1/node.new.bvr");
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSub = (FragmentSubstitution) vp;
				break;
			}
		}
		
		Assert.assertNotNull("can not locate a fragment substitution, the test can not be executed", fragSub);
		fragmentSubHolder = new FragmentSubstitutionHolder(fragSub);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testSingleSubstitutiontContainmentTrue() throws Exception {
		// (a) A-)-->B (A belongs to placement, while B is outside boundary element)
		// (b) rA<>-)-->rB (B belongs to replacement, while rb is outside boundary element)
		// if we bind (a) to (b) than B should be replaced correctly
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSingleSubstitutiontContainmentFalse() throws Exception {
		// (a) A-)-->B (A belongs to placement, while B is outside boundary element)
		// (b) rA<>-)-->rB (B belongs to replacement, while rb is outside boundary element)
		// if we bind (a) to (b) than B should be replaced correctly
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}
	
	@Test
	public void testSingleSubstitutiontContainmentFalseTrue() throws Exception {
		// (a) A-)-->B (A belongs to placement, while B is outside boundary element)
		// (b) rA<>-)-->rB (B belongs to replacement, while rb is outside boundary element)
		// if we bind (a) to (b) than B should be replaced correctly
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		//basically the same is prod0.node
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSingleSubstitutiontContainmentTrueFalse() throws Exception {
		// (a) A-)-->B (A belongs to placement, while B is outside boundary element)
		// (b) rA<>-)-->rB (B belongs to replacement, while rb is outside boundary element)
		// if we bind (a) to (b) than B should be replaced correctly
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod3.node", "base_new.node"));
	}
}
