/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.adjacent;

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.engine.common.SubstitutionEngine;
import no.sintef.bvr.engine.testutils.SetUpUtils;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class FragmentSubstitutionAdjacentTwins2EngineInterfaceTest {

	private File file;
	private HashMap<String, Object> map;
	private BVRModel cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private EList<FragmentSubstitution> fragmentSubHolderList;
	private FragmentSubstitution fragmentSubHolder1;
	private FragmentSubstitution fragmentSubHolder2;
	private FragmentSubstitution fragmentSubHolder3;
	private FragmentSubstitution fragmentSubHolder4;
	private FragmentSubstitution fragmentSubHolder5;

	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/adjacentTwins2/adjtwinsbvr2.bvr");
		map = SetUpUtils.load(file);
		cu = (BVRModel) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getRealizationModel();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
			}
		}
		
		Assert.assertTrue("can not locate a fragment substitution, the test can not be executed", fragSubs.size() == 5);
		fragmentSubHolder1 = fragSubs.get(2);
		fragmentSubHolder2 = fragSubs.get(1);
		fragmentSubHolder3 = fragSubs.get(0);
		fragmentSubHolder4 = fragSubs.get(3);
		fragmentSubHolder5 = fragSubs.get(4);
		fragmentSubHolderList = new BasicEList<FragmentSubstitution>();
		fragmentSubHolderList.add(fragmentSubHolder1);
		fragmentSubHolderList.add(fragmentSubHolder2);
		fragmentSubHolderList.add(fragmentSubHolder3);
		fragmentSubHolderList.add(fragmentSubHolder4);
		fragmentSubHolderList.add(fragmentSubHolder5);
		SubstitutionEngine.eINSTANCE.init(fragmentSubHolderList);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testAdjacentDifferentOrder() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder1() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder2() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder3() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder4() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
				
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder5() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder6() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder7() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder8() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
			
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder9() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
				
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder10() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder11() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
				
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder12() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder13() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
				
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentDifferentOrder14() throws Exception {
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder5, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder1, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder4, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder2, true);
		SubstitutionEngine.eINSTANCE.subsitute(fragmentSubHolder3, true);
				
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("expected.node", "base_new.node"));
	}
}
