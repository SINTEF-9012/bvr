package no.sintef.cvl.engine.operation;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import no.sintef.cvl.engine.testutils.SetUpUtils;
import node.NodePackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Sets;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;

public class FragmentSubstitutionPElementHolderTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static ConfigurableUnit cu;
	private static FragmentSubstitution fragSub;
	private static final String[] BEEXT = new String[] {"5", "17", "16"}; //can be 16? check it later
	private static final String[] BEINT = new String[] {"10", "7", "5", "4", "17", "9", "15", "16", "8", "13", "14", "11", "12"};
	private static final String[] EINT = new String[] {"6"};
	private static final String[] INT = new String[] {"10", "7", "5", "4", "17", "15", "9", "8", "16", "13", "14", "11", "12"};
	private static final String[] EXT = new String[] {"null", "3", "20", "2", "1", "0", "19", "18", "21"};
	
	private static final String[] RBEEXT = new String[] {"r17", "r16", "r5"};
	private static final String[] RBEINT = new String[] {"r17", "r6", "r16", "r15", "r7", "r8", "r14", "r9", "r13", "r4", "r5", "r41"};
	private static final String[] REINT = new String[] {};
	private static final String[] RINT = new String[] {"r17", "r6", "r16", "r15", "r7", "r8", "r14", "r9", "r13", "r4", "r5", "r41"};
	private static final String[] REXT = new String[] {"r19", "r18", "r1", "r2", "r20", "r3", "null", "r0"};

	private HashSet<String> BElementsExternal;
	private HashSet<String> BElementsInternal;
	private HashSet<String> ElementsInternal;
	private HashSet<String> InnerElements;
	private HashSet<String> OuterElements;
	private HashSet<String> RBElementsExternal;
	private HashSet<String> RBElementsInternal;
	private HashSet<String> RElementsInternal;
	private HashSet<String> RInnerElements;
	private HashSet<String> ROuterElements;
	private FragmentSubstitutionHolder fragmentSubHolder;
	private Resource baseModel;
	private HashSet<String> RBElementsExternalBuf;
	private HashSet<String> RBElementsInternalBuf;
	private HashSet<String> RElementsInternalBuf;
	private HashSet<String> RInnerElementsBuf;
	private HashSet<String> ROuterElementsBuf;

	@Before
	public void setUp() throws Exception {
		//nodePackage.eINSTANCE.eClass();
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
		
		Assert.assertNotNull("can not locate a fragment substitution, the test can not be executed", fragSub);
		BElementsExternal = new HashSet<String>(Arrays.asList(BEEXT));
		BElementsInternal = new HashSet<String>(Arrays.asList(BEINT));
		ElementsInternal = new HashSet<String>(Arrays.asList(EINT));
		InnerElements = new HashSet<String>(Arrays.asList(INT));
		OuterElements = new HashSet<String>(Arrays.asList(EXT));
		
		RBElementsExternal = new HashSet<String>(Arrays.asList(RBEEXT));
		RBElementsInternal = new HashSet<String>(Arrays.asList(RBEINT));
		RElementsInternal = new HashSet<String>(Arrays.asList(REINT));
		RInnerElements = new HashSet<String>(Arrays.asList(RINT));
		ROuterElements = new HashSet<String>(Arrays.asList(REXT));
		
		RBElementsExternalBuf = new HashSet<String>(RBElementsExternal);
		RBElementsInternalBuf = new HashSet<String>(RBElementsInternal);
		RElementsInternalBuf = new HashSet<String>(RElementsInternal);
		RInnerElementsBuf = new HashSet<String>(RInnerElements);
		ROuterElementsBuf = new HashSet<String>(ROuterElements);
		
		fragmentSubHolder = new FragmentSubstitutionHolder(fragSub);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@Test
	public void testFragmentSubstitutionPlacementTrue() throws Exception{
		PlacementElementHolder placement = fragmentSubHolder.getPlacement();
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testFragmentSubstitutionPlacementFalse() throws Exception{
		PlacementElementHolder placement = fragmentSubHolder.getPlacement();
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		RBElementsExternal.addAll(BElementsExternal);
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		RBElementsInternal.addAll(BElementsInternal);
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		RElementsInternal.addAll(ElementsInternal);
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		RInnerElements.addAll(InnerElements);
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}
	
	@Test
	public void testFragmentSubstitutionPlacementFalseTrue() throws Exception{
		PlacementElementHolder placement = fragmentSubHolder.getPlacement();
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		RBElementsExternal.addAll(BElementsExternal);
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		RBElementsInternal.addAll(BElementsInternal);
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		RElementsInternal.addAll(ElementsInternal);
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		RInnerElements.addAll(InnerElements);
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternalBuf + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternalBuf, BElementsExternalExp).isEmpty());
		BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternalBuf + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternalBuf, BElementsInternalExp).isEmpty());
		ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternalBuf + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternalBuf, ElementsInternalExp).isEmpty());
		InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElementsBuf + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElementsBuf, InnerElementsExp).isEmpty());
		OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testFragmentSubstitutionPlacementTrueTrue() throws Exception{
		PlacementElementHolder placement = fragmentSubHolder.getPlacement();
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}

	@Test
	public void testFragmentSubstitutionPlacementFalseFalse() throws Exception{
		PlacementElementHolder placement = fragmentSubHolder.getPlacement();
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		RBElementsExternal.addAll(BElementsExternal);
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + RBElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(RBElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getBElementsInternal(), "name");
		RBElementsInternal.addAll(BElementsInternal);
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + RBElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(RBElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(placement.getElementsInternal(), "name");
		RElementsInternal.addAll(ElementsInternal);
		Assert.assertTrue("Incorrect set of interanal elements expected->" + RElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(RElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(placement.getInnerNeighboringElements(), "name");
		RInnerElements.addAll(InnerElements);
		Assert.assertTrue("Incorrect set of InnerElements expected->" + RInnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(RInnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
		
		
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		EList<String> BElementsExternalL = SetUpUtils.getPropertiesValuesList(placement.getBElementsExternal(), "name");
		EList<String> BElementsExternalE = new BasicEList<String>();
		BElementsExternalE.addAll(BElementsExternal);
		BElementsExternalE.addAll(RBElementsExternalBuf);
		BElementsExternalE.addAll(RBElementsExternalBuf);
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + BElementsExternalE + " actual->" + BElementsExternalL, SetUpUtils.compareStringLists(BElementsExternalL, BElementsExternalE));
		
		EList<String> BElementsInternalL = SetUpUtils.getPropertiesValuesList(placement.getBElementsInternal(), "name");
		EList<String> BElementsInternalE = new BasicEList<String>();
		BElementsInternalE.addAll(BElementsInternal);
		BElementsInternalE.addAll(RBElementsInternalBuf);
		BElementsInternalE.addAll(RBElementsInternalBuf);
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + BElementsInternalE + " actual->" + BElementsInternalL, SetUpUtils.compareStringLists(BElementsInternalE, BElementsInternalL));
		
		EList<String> ElementsInternalL = SetUpUtils.getPropertiesValuesList(placement.getElementsInternal(), "name");
		EList<String> ElementsInternalE = new BasicEList<String>();
		ElementsInternalE.addAll(ElementsInternal);
		ElementsInternalE.addAll(RElementsInternalBuf);
		ElementsInternalE.addAll(RElementsInternalBuf);
		Assert.assertTrue("Incorrect set of interanal elements expected->" + ElementsInternalE + " actual->" + ElementsInternalL, SetUpUtils.compareStringLists(ElementsInternalE, ElementsInternalL));
		
		EList<String> InnerElementsL = SetUpUtils.getPropertiesValuesList(placement.getInnerNeighboringElements(), "name");
		EList<String> InnerElementsE = new BasicEList<String>();
		InnerElementsE.addAll(InnerElements);
		InnerElementsE.addAll(RInnerElementsBuf);
		InnerElementsE.addAll(RInnerElementsBuf);
		Assert.assertTrue("Incorrect set of InnerElements expected->" + InnerElementsE + " actual->" + InnerElementsL, SetUpUtils.compareStringLists(InnerElementsE, InnerElementsL));
		
		OuterElementsExp = SetUpUtils.getPropertiesValues(placement.getOuterNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod3.node", "base_new.node"));
	}
	
	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
}
