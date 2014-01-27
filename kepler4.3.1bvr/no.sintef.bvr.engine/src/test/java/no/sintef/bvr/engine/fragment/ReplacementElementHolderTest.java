package no.sintef.bvr.engine.fragment;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import no.sintef.bvr.engine.fragment.impl.ReplacementElementHolder;
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

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class ReplacementElementHolderTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static ConfigurableUnit cu;
	private static FragmentSubstitution fragSub;
	private static final String[] BEEXT = new String[] {"r17", "r16", "r5"};
	private static final String[] BEINT = new String[] {"r17", "r6", "r16", "r15", "r7", "r8", "r14", "r9", "r13", "r4", "r5", "r41"};
	private static final String[] EINT = new String[] {};
	private static final String[] INT = new String[] {"r17", "r6", "r16", "r15", "r7", "r8", "r14", "r9", "r13", "r4", "r5", "r41"};
	private static final String[] EXT = new String[] {"r19", "r18", "r1", "r2", "r20", "r3", "null", "r0"};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		file = new File("src/test/resources/node6/node.new.bvr");
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

	private ReplacementElementHolder replacement;
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
		ElementsInternal = new HashSet<String>(Arrays.asList(EINT));
		InnerElements = new HashSet<String>(Arrays.asList(INT));
		OuterElements = new HashSet<String>(Arrays.asList(EXT));
			
		replacement = new ReplacementElementHolder(fragSub.getReplacement());
	}

	@Test
	public void test() {
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(replacement.getBElementsExternal(), "name");
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + BElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(BElementsExternal, BElementsExternalExp).isEmpty());
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(replacement.getBElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + BElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(BElementsInternal, BElementsInternalExp).isEmpty());
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(replacement.getElementsInternal(), "name");
		Assert.assertTrue("Incorrect set of interanal elements expected->" + ElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(ElementsInternal, ElementsInternalExp).isEmpty());
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(replacement.getInnerNeighboringElements(), "name");
		Assert.assertTrue("Incorrect set of InnerElements expected->" + InnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(InnerElements, InnerElementsExp).isEmpty());
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(replacement.getOuterNeighboringElements(), "name");
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
