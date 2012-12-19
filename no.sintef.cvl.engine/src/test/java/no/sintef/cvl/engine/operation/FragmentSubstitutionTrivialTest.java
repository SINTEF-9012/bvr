package no.sintef.cvl.engine.operation;

import java.io.File;
import java.util.HashMap;

import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import no.sintef.cvl.engine.testutils.SetUpUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;

public class FragmentSubstitutionTrivialTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static ConfigurableUnit cu;
	private static FragmentSubstitution fragSub;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder;

	@Before
	public void setUp() throws Exception {
		file = new File("src/test/resources/node9-7/node.new.cvl");
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
	public void testSingleSubstitutiontTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSingleSubstitutionFalse() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod2.node", "base_new.node"));
	}
	
	@Test
	public void testSeveralSubstitutionsReplaceTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSeveralSubstitutionsReplaceTrueFalse() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}

	@Test
	public void testSeveralSubstitutionsReplaceFalseTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod2.node", "base_new.node"));
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
}
