/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.fragment;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import no.sintef.bvr.engine.fragment.impl.PlacementElementHolder;
import no.sintef.bvr.engine.testutils.SetUpUtils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Sets;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class PlacementElementHolderTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static BVRModel cu;
	private static FragmentSubstitution fragSub;
	private static final String[] BEEXT = new String[] {"5", "17", "16"};
	private static final String[] BEINT = new String[] {"10", "7", "5", "4", "17", "9", "15", "16", "8", "13", "14", "11", "12"};
	private static final String[] EINT = new String[] {"6"};
	private static final String[] INT = new String[] {"10", "7", "5", "4", "17", "15", "9", "8", "16", "13", "14", "11", "12"};
	private static final String[] EXT = new String[] {"null", "3", "20", "2", "1", "0", "19", "18", "21"};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		file = new File("src/test/resources/node6/node.newbvr2.bvr");
		map = SetUpUtils.load(file);
		cu = (BVRModel) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getRealizationModel();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSub = (FragmentSubstitution) vp;
				break;
			}
		}
	}

	private PlacementElementHolder placement;
	private HashSet<String> BElementsExternal;
	private HashSet<String> BElementsInternal;
	private HashSet<String> ElementsInternal;
	private HashSet<String> InnerElements;
	private HashSet<String> OuterElements;

	@Before
	public void setUp() throws Exception {
		Assert.assertNotNull("can not locate a fragment substitution, the test can not be executed", fragSub);
		BElementsExternal = new HashSet<String>(Arrays.asList(BEEXT));
		BElementsInternal = new HashSet<String>(Arrays.asList(BEINT));
		ElementsInternal = new HashSet<String>(Arrays.asList(EINT));
		InnerElements = new HashSet<String>(Arrays.asList(INT));
		OuterElements = new HashSet<String>(Arrays.asList(EXT));
			
		placement = new PlacementElementHolder(fragSub.getPlacement());
	}

	@Test
	public void test() {
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + BElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(BElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + BElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(BElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + ElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(ElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + InnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(InnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SetUpUtils.tearDown(map);
	}

}
