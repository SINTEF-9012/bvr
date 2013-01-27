package no.sintef.cvl.engine.deleteme;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFragmentImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import no.sintef.cvl.engine.testutils.SetUpUtils;
import no.sintef.dsl.node.nodePackage;

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
import com.google.common.collect.Sets;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.ObjectHandle;
import cvl.ToBinding;
import cvl.VariationPoint;

public class FragmentSubstitutionTestToDelete {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder1;
	private FragmentSubstitutionHolder fragmentSubHolder2;
	private FragmentSubstitutionHolder fragmentSubHolder3;
	private static final String[] o = new String[] {"0", "00"};
	private static final String[] o1 = new String[] {"14"};
	private static final String[] p1 = new String[] {"r1", "r2", "r3", "r4", "r5"};
	private static final String[] p2 = new String[] {"r6", "r7", "r8", "r9", "r10"};
	private static final String[] p3 = new String[] {"r11", "r12", "r13"};
	private static final String[] p1orig = new String[] {"1", "2", "3", "4", "5"};
	private static final String[] p2orig = new String[] {"6", "7", "8", "9", "10"};
	private static final String[] p3orig = new String[] {"11", "12", "13"};

	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/nodeWorkingCopy/adjacent/exp2/node.new.cvl");
		nodePackage.eINSTANCE.eClass();
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
			}
		}
		
		Assert.assertTrue("can not locate a fragment substitution, the test can not be executed", fragSubs.size() > 0);
		fragmentSubHolder1 = new FragmentSubstitutionHolder(fragSubs.get(2));
		fragmentSubHolder2 = new FragmentSubstitutionHolder(fragSubs.get(1));
		fragmentSubHolder3 = new FragmentSubstitutionHolder(fragSubs.get(0));
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}	
	
	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
		
	@Test
	public void testSingleSubstitution() throws Exception {
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		
		HashSet<String> Elements = new HashSet<String>(Arrays.asList(p2orig));
		HashSet<String> ElementsInternal = new HashSet<String>(Arrays.asList(new String[]{}));
		HashSet<String> BElementsInternal = new HashSet<String>(Arrays.asList(p2orig));
		HashSet<String> BElementsExternal = new HashSet<String>(Arrays.asList(new String[]{"9", "7"}));
		HashSet<String> InnerElements = new HashSet<String>(Arrays.asList(p2orig));
		HashSet<String> OuterElements = new HashSet<String>(Arrays.asList(new String[]{"null", "5", "4", "11", "12", "13"}));
		
		HashSet<String> ElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getElements(), "name");
		HashSet<String> ElementsInternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getElementsInternal(), "name");
		HashSet<String> BElementsInternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getBElementsInternal(), "name");
		HashSet<String> BElementsExternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getBElementsExternal(), "name");
		HashSet<String> InnerElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getInnerFragmentElements(), "name");
		HashSet<String> OuterElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getOuterFragmentElements(), "name");
		
		Assert.assertTrue("Incorrect set of elements in the placement expected->" + Elements + " actual->" + ElementsExp, Sets.symmetricDifference(Elements, ElementsExp).isEmpty());
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + BElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(BElementsExternal, BElementsExternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + BElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(BElementsInternal, BElementsInternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of interanal elements expected->" + ElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(ElementsInternal, ElementsInternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of InnerElements expected->" + InnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(InnerElements, InnerElementsExp).isEmpty());
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());		
		
		fso2.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");

		Elements = new HashSet<String>(Arrays.asList(SetUpUtils.concatArrays(p2, p2orig)));
		ElementsInternal = new HashSet<String>(Arrays.asList(new String[]{}));
		BElementsInternal = new HashSet<String>(Arrays.asList(SetUpUtils.concatArrays(p2, p2orig)));
		BElementsExternal = new HashSet<String>(Arrays.asList(new String[]{"7","9","r9"}));
		InnerElements = new HashSet<String>(Arrays.asList(SetUpUtils.concatArrays(p2, p2orig)));
		OuterElements = new HashSet<String>(Arrays.asList(new String[]{"null", "5", "13", "4", "11", "12"}));
		
		ElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getElements(), "name");
		ElementsInternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getElementsInternal(), "name");
		BElementsInternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getBElementsInternal(), "name");
		BElementsExternalExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getBElementsExternal(), "name");
		InnerElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getInnerFragmentElements(), "name");
		OuterElementsExp = SetUpUtils.getPropertiesValues(fragmentSubHolder2.getPlacement().getOuterFragmentElements(), "name");
		
		Assert.assertTrue("Incorrect set of elements in the placement expected->" + Elements + " actual->" + ElementsExp, Sets.symmetricDifference(Elements, ElementsExp).isEmpty());
		Assert.assertTrue("Incorrect set of external boundary elements expected->" + BElementsExternal + " actual->" + BElementsExternalExp, Sets.symmetricDifference(BElementsExternal, BElementsExternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of interanal boundary elements expected->" + BElementsInternal + " actual->" + BElementsInternalExp, Sets.symmetricDifference(BElementsInternal, BElementsInternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of interanal elements expected->" + ElementsInternal + " actual->" + ElementsInternalExp, Sets.symmetricDifference(ElementsInternal, ElementsInternalExp).isEmpty());
		Assert.assertTrue("Incorrect set of InnerElements expected->" + InnerElements + " actual->" + InnerElementsExp, Sets.symmetricDifference(InnerElements, InnerElementsExp).isEmpty());
		Assert.assertTrue("Incorrect set of OuterElements expected->" + OuterElements + " actual->" + OuterElementsExp, Sets.symmetricDifference(OuterElements, OuterElementsExp).isEmpty());
		
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod4.node", "base_new.node"));
	}
	
	private EList<EObject> resolveObjectHandles(EList<ObjectHandle> objectHandles){
		EList<EObject> list = new BasicEList<EObject>();
		for(ObjectHandle oh : objectHandles){
			list.add(oh.getMOFRef());
		}
		return list;
	}
	
	private EObject resolveObjectHandles(ObjectHandle objectHandles){
		return objectHandles.getMOFRef();
	}

}
