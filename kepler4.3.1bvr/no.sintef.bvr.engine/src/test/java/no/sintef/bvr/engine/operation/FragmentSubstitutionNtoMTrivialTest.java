package no.sintef.bvr.engine.operation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import no.sintef.bvr.engine.adjacent.AdjacentFragment;
import no.sintef.bvr.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.bvr.engine.adjacent.impl.AdjacentFragmentImpl;
import no.sintef.bvr.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.operation.impl.FragmentSubOperation;
import no.sintef.bvr.engine.testutils.SetUpUtils;
import node.NodePackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.ObjectHandle;
import bvr.ToBinding;
import bvr.VariationPoint;

public class FragmentSubstitutionNtoMTrivialTest {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder1;


	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/nodeNtoM/exp1/node.new.bvr");
		//nodePackage.eINSTANCE.eClass();
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
			}
		}
		
		Assert.assertTrue("can not locate a fragment substitution, the test can not be executed", fragSubs.size() > 0);
		fragmentSubHolder1 = new FragmentSubstitutionHolder(fragSubs.get(0));
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}	
	
	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testSingleSubstitution() throws Exception {
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
				
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		
	}
	
	@Test
	public void testSingleSubstitutionFalse() throws Exception {
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
				
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(false);
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		
	}
	
	@Test
	public void testSubstitutionFalseTrue() throws Exception {
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
				
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(false);
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		
		fso1.execute(true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSubstitutionTrueTrue() throws Exception {
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
				
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		
		fso1.execute(true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSubstitutionFalseFalse() throws Exception {
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
				
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(false);
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		
		fso1.execute(false);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod2.node", "base_new.node"));
	}
}
