package no.sintef.cvl.engine.operation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFragmentImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.common.Utility;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
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
import com.google.common.collect.Sets.SetView;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.VariationPoint;

public class FragmentSubstitutionAdjacentTest {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder1;
	private FragmentSubstitutionHolder fragmentSubHolder2;
	private FragmentSubstitutionHolder fragmentSubHolder3;
	private BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList;
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
		//nodePackage.eINSTANCE.eClass();
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/nodeAdjacent/exp1/node.new.cvl");
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
			}
		}
		
		Assert.assertTrue("can not locate a fragment substitution, the test can not be executed", fragSubs.size() == 3);
		fragmentSubHolder1 = new FragmentSubstitutionHolder(fragSubs.get(2));
		fragmentSubHolder2 = new FragmentSubstitutionHolder(fragSubs.get(1));
		fragmentSubHolder3 = new FragmentSubstitutionHolder(fragSubs.get(0));
		fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
		fragmentSubHolderList.add(fragmentSubHolder2);
		fragmentSubHolderList.add(fragmentSubHolder3);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testAdjacentTrue() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		
		EList<EObject> outsideBoundaryElementsOld1 = this.getOutsideBoundaryElementsFragment(fragmentSubHolder1);
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
		adjacentResolver.resolve(fragmentSubHolder1);
		
		EList<EObject> outsideBoundaryElementsNew1 = this.getOutsideBoundaryElementsFragment(fragmentSubHolder1);
		Assert.assertTrue("Incorrect set of the outsideBoundary elements, expected -> " +outsideBoundaryElementsOld1 + " actual ->" + outsideBoundaryElementsNew1, SetUpUtils.compareLists(outsideBoundaryElementsOld1, outsideBoundaryElementsNew1));
		
		HashSet<EObject> innerElements = fragmentSubHolder1.getPlacement().getInnerFragmentElements();
		EList<String> innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(p1) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(p1), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder1);
		
		EList<EObject> outsideBoundaryElementToPlacement2 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder2);
		//the difference should be empty, but there is outside reference to root element with name null
		SetView<EObject> diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement2), innerElements);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(true);
		adjacentResolver.resolve(fragmentSubHolder2);
		
		innerElements = fragmentSubHolder2.getPlacement().getInnerFragmentElements();
		innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(p2) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(p2), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder2);
		
		EList<EObject> outsideBoundaryElementFromPlacement1 = this.getOutsideBoundaryElemenetsFromPlacements(fragmentSubHolder1);
		Assert.assertTrue("fromPlacement has not been updated for adjacent fs", Sets.difference(new HashSet<EObject>(outsideBoundaryElementFromPlacement1), innerElements).isEmpty());
		
		outsideBoundaryElementToPlacement2 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder2);
		EList<String> outsideBoundaryElementToPlacement2Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement2), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementToPlacement2Names + " expected ->" + Arrays.asList(new String[]{"r4", "r5", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement2Names, Arrays.asList(new String[]{"r4", "r5", "null"})));
		HashSet<EObject> innerElements1 = fragmentSubHolder1.getPlacement().getInnerFragmentElements();
		diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement2), innerElements1);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		EList<EObject> outsideBoundaryElementToPlacement3 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder3);
		outsideBoundaryElementToPlacement3 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder3);
		EList<String> outsideBoundaryElementToPlacement3Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement3), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementToPlacement3Names + " expected ->" + Arrays.asList(new String[]{"r7", "r9", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement3Names, Arrays.asList(new String[]{"r7", "r9", "null"})));
		//the difference should be empty, but there is outside reference to root element with name null
		diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement3), innerElements);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		
		FragmentSubOperation fso3 = new FragmentSubOperation(fragmentSubHolder3);
		fso3.execute(true);
		adjacentResolver.resolve(fragmentSubHolder3);
		
		innerElements = fragmentSubHolder3.getPlacement().getInnerFragmentElements();
		innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(p3) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(p3), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder3);
		
		EList<EObject> outsideBoundaryElementFromPlacement2 = this.getOutsideBoundaryElemenetsFromPlacements(fragmentSubHolder2);
		Assert.assertTrue("fromPlacement has not been updated for adjacent fs", Sets.difference(new HashSet<EObject>(outsideBoundaryElementFromPlacement2), innerElements).isEmpty());
		
		HashSet<EObject> innerElements2 = fragmentSubHolder2.getPlacement().getInnerFragmentElements();
		outsideBoundaryElementToPlacement3 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder3);
		outsideBoundaryElementToPlacement3Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement3), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementToPlacement3Names + " expected ->" + Arrays.asList(new String[]{"r7", "r9", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement3Names, Arrays.asList(new String[]{"r7", "r9", "null"})));
		//the difference should be empty, but there is outside reference to root element with name null
		diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement3), innerElements2);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		HashSet<EObject> elements = this.fecthContent();
		for(EObject object : elements){
			Assert.assertNotNull("object has not resource " + object, object.eResource());
			Assert.assertTrue("wrong recourse " + object + " " + object.eResource(), baseModel.equals(object.eResource()));
		}
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentFalse() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		
		EList<EObject> outsideBoundaryElementsOld1 = this.getOutsideBoundaryElementsFragment(fragmentSubHolder1);
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(false);
		adjacentResolver.resolve(fragmentSubHolder1);
		
		EList<EObject> outsideBoundaryElementsNew1 = this.getOutsideBoundaryElementsFragment(fragmentSubHolder1);
		Assert.assertTrue("Incorrect set of the outsideBoundary elements, expected -> " +outsideBoundaryElementsOld1 + " actual ->" + outsideBoundaryElementsNew1, SetUpUtils.compareLists(outsideBoundaryElementsOld1, outsideBoundaryElementsNew1));
		
		EList<EObject> insideBoundaryElements = this.getInsideBoundaryElementsFragment(fragmentSubHolder1);
		EList<String> insideBoundaryElementsNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(insideBoundaryElements), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + insideBoundaryElementsNames + " expected ->" + Arrays.asList(new String[]{"1", "2", "3", "4", "5", "r1", "r2", "r3", "r4", "r5"}), SetUpUtils.compareStringLists(insideBoundaryElementsNames, Arrays.asList(new String[]{"1", "2", "3", "4", "5", "r1", "r2", "r3", "r4", "r5"})));
		
		HashSet<EObject> innerElements = fragmentSubHolder1.getPlacement().getInnerFragmentElements();
		EList<String> innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(SetUpUtils.concatArrays(p1, p1orig)) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(SetUpUtils.concatArrays(p1, p1orig)), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder1);
		
		EList<EObject> outsideBoundaryElementToPlacement2 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder2);
		//the difference should be empty, but there is outside reference to root element with name null
		SetView<EObject> diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement2), innerElements);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(false);
		adjacentResolver.resolve(fragmentSubHolder2);
		
		insideBoundaryElements = this.getInsideBoundaryElementsFragment(fragmentSubHolder2);
		insideBoundaryElementsNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(insideBoundaryElements), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + insideBoundaryElementsNames + " expected ->" + Arrays.asList(new String[]{"6", "7", "8", "9", "10", "r6", "r7", "r8", "r9", "r10"}), SetUpUtils.compareStringLists(insideBoundaryElementsNames, Arrays.asList(new String[]{"6", "7", "8", "9", "10", "r6", "r7", "r8", "r9", "r10"})));
		
		innerElements = fragmentSubHolder2.getPlacement().getInnerFragmentElements();
		innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(SetUpUtils.concatArrays(p2, p2orig)) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(SetUpUtils.concatArrays(p2, p2orig)), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder2);
		
		EList<EObject> outsideBoundaryElementsFragment = this.getOutsideBoundaryElementsFragment(fragmentSubHolder2);
		EList<String> outsideBoundaryElementsFragmentNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementsFragment), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementsFragmentNames + " expected ->" + Arrays.asList(new String[]{"4", "5", "r4", "r5", "11", "12", "13", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementsFragmentNames, Arrays.asList(new String[]{"4", "5", "r4", "r5", "11", "12", "13", "null"})));
				
		EList<EObject> outsideBoundaryElementToPlacement21 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder2);
		EList<String> outsideBoundaryElementToPlacement21Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement21), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementToPlacement21Names + " expected ->" + Arrays.asList(new String[]{"4", "5", "r4", "r5", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement21Names, Arrays.asList(new String[]{"4", "5", "r4", "r5", "null"})));
		
		EList<EObject> outsideBoundaryElementFromPlacement1 = this.getOutsideBoundaryElemenetsFromPlacements(fragmentSubHolder1);
		EList<String> outsideBoundaryElementFromPlacement1Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementFromPlacement1), "name");
		Assert.assertTrue("Incorrect set of referenced elements", SetUpUtils.compareStringLists(outsideBoundaryElementFromPlacement1Names, Arrays.asList(new String[]{"10", "8", "6", "r10", "r8", "r6"})));
		Assert.assertTrue("fromPlacement has not been updated for adjacent fs", Sets.difference(new HashSet<EObject>(outsideBoundaryElementFromPlacement1), innerElements).isEmpty());
		
		EList<EObject> outsideBoundaryElementToPlacement3 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder3);
		EList<String> outsideBoundaryElementToPlacement3Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement3), "name");
		Assert.assertTrue("Incorrect set of referenced elements", SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement3Names, Arrays.asList(new String[]{"7", "9", "r7", "r9", "null"})));
		//the difference should be empty, but there is outside reference to root element with name null
		diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement3), innerElements);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		
		FragmentSubOperation fso3 = new FragmentSubOperation(fragmentSubHolder3);
		fso3.execute(false);
		adjacentResolver.resolve(fragmentSubHolder3);
		
		insideBoundaryElements = this.getInsideBoundaryElementsFragment(fragmentSubHolder3);
		insideBoundaryElementsNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(insideBoundaryElements), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + insideBoundaryElementsNames + " expected ->" + Arrays.asList(new String[]{"11", "12", "13", "r11", "r12", "r13"}), SetUpUtils.compareStringLists(insideBoundaryElementsNames, Arrays.asList(new String[]{"11", "12", "13", "r11", "r12", "r13"})));
		
		innerElements = fragmentSubHolder3.getPlacement().getInnerFragmentElements();
		innerElementNames = SetUpUtils.getPropertiesValuesList(innerElements, "name");
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(SetUpUtils.concatArrays(p3, p3orig)) + " actual ->" + innerElementNames, SetUpUtils.compareStringLists(Arrays.asList(SetUpUtils.concatArrays(p3, p3orig)), innerElementNames));
		this.checkInsideBoundaryElements(fragmentSubHolder3);
		
		EList<EObject> outsideBoundaryElementFromPlacement2 = this.getOutsideBoundaryElemenetsFromPlacements(fragmentSubHolder2);
		EList<String> outsideBoundaryElementFromPlacement2Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementFromPlacement2), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementFromPlacement2Names + " expected ->" + Arrays.asList(new String[]{"11", "12", "13", "r11", "r12", "r13"}), SetUpUtils.compareStringLists(outsideBoundaryElementFromPlacement2Names, Arrays.asList(new String[]{"11", "12", "13", "r11", "r12", "r13"})));
		Assert.assertTrue("fromPlacement has not been updated for adjacent fs", Sets.difference(new HashSet<EObject>(outsideBoundaryElementFromPlacement2), innerElements).isEmpty());
		
		HashSet<EObject> innerElements2 = fragmentSubHolder2.getPlacement().getInnerFragmentElements();
		outsideBoundaryElementToPlacement3 = this.getOutsideBoundaryElemenetsToPlacements(fragmentSubHolder3);
		outsideBoundaryElementToPlacement3Names = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementToPlacement3), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementToPlacement3Names + " expected ->" + Arrays.asList(new String[]{"7", "9", "r7", "r8", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementToPlacement3Names, Arrays.asList(new String[]{"7", "9", "r7", "r9", "null"})));
		//the difference should be empty, but there is outside reference to root element with name null
		diff = Sets.difference(new HashSet<EObject>(outsideBoundaryElementToPlacement3), innerElements2);
		Assert.assertTrue("toPlacement has not been updated for adjacent fs", diff.size() == 1 && SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(diff), "name").get(0).equals("null"));
		
		outsideBoundaryElementsFragment = this.getOutsideBoundaryElementsFragment(fragmentSubHolder2);
		outsideBoundaryElementsFragmentNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementsFragment), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementsFragmentNames + " expected ->" + Arrays.asList(new String[]{"4", "5", "r4", "r5", "11", "12", "13", "r11", "r12", "r13", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementsFragmentNames, Arrays.asList(new String[]{"4", "5", "r4", "r5", "11", "12", "13", "r11", "r12", "r13", "null"})));
		
		outsideBoundaryElementsFragment = this.getOutsideBoundaryElementsFragment(fragmentSubHolder3);
		outsideBoundaryElementsFragmentNames = SetUpUtils.getPropertiesValuesList(new HashSet<EObject>(outsideBoundaryElementsFragment), "name");
		Assert.assertTrue("Incorrect set of referenced elements actual -> " + outsideBoundaryElementsFragmentNames + " expected ->" + Arrays.asList(new String[]{"7", "9", "r7", "r9", "14", "null"}), SetUpUtils.compareStringLists(outsideBoundaryElementsFragmentNames, Arrays.asList(new String[]{"7", "9", "r7", "r9", "14", "null"})));
		
		HashSet<EObject> elements = this.fecthContent();
		for(EObject object : elements){
			Assert.assertNotNull("object has not resource " + object, object.eResource());
			Assert.assertTrue("wrong recourse " + object + " " + object.eResource(), baseModel.equals(object.eResource()));
		}
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}
	
	@Test
	public void testAdjacentFalsePlacement() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(false);
		adjacentResolver.resolve(fragmentSubHolder1);
				
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(false);
		adjacentResolver.resolve(fragmentSubHolder2);
		
		FragmentSubOperation fso3 = new FragmentSubOperation(fragmentSubHolder3);
		fso3.execute(false);
		adjacentResolver.resolve(fragmentSubHolder3);
		
		PlacementElementHolder placement1 = fragmentSubHolder1.getPlacement();
		PlacementElementHolder placement2 = fragmentSubHolder2.getPlacement();
		PlacementElementHolder placement3 = fragmentSubHolder3.getPlacement();
		
		HashSet<EObject> bElementsInternal = placement1.getBElementsInternal();
		HashSet<EObject> bElementsExternal = placement1.getBElementsExternal();
		HashSet<EObject> innerFragmentElements = placement1.getInnerFragmentElements();
		HashSet<EObject> outerFragmentElements = placement1.getOuterFragmentElements();
		HashSet<EObject> elementsInternal = placement1.getElementsInternal();
		
		EList<String> bElementsInternalNames = SetUpUtils.getPropertiesValuesList(bElementsInternal, "name");
		EList<String> bElementsExternalNames = SetUpUtils.getPropertiesValuesList(bElementsExternal, "name");
		EList<String> innerFragmentElementsNames = SetUpUtils.getPropertiesValuesList(innerFragmentElements, "name");
		EList<String> outerFragmentElementsNames = SetUpUtils.getPropertiesValuesList(outerFragmentElements, "name");
		EList<String> elementsInternalNames = SetUpUtils.getPropertiesValuesList(elementsInternal, "name");
		
		String[] bElementsInternalNamesExp = new String[]{"1", "2", "3", "4", "5", "r1", "r2", "r3", "r4", "r5"};
		String[] bElementsExternalNamesExp = new String[]{"4", "5", "r4", "r5"};
		String[] innerFragmentElementsNamesExp = new String[]{"1", "2", "3", "4", "5", "r1", "r2", "r3", "r4", "r5"};
		String[] outerFragmentElementsNamesExp = new String[]{"0", "00", "6", "8", "10", "null", "r6", "r8", "r10"};
		String[] elementsInternalNamesExp = new String[]{"1", "2", "3", "4", "5", "r1", "r2", "r3", "r4", "r5"};
		
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(bElementsInternalNamesExp) + " actual ->" + bElementsInternalNames, SetUpUtils.compareStringLists(Arrays.asList(bElementsInternalNamesExp), bElementsInternalNames));
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(bElementsExternalNamesExp) + " actual ->" + bElementsExternalNames, SetUpUtils.compareStringLists(Arrays.asList(bElementsExternalNamesExp), bElementsExternalNames));
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(innerFragmentElementsNamesExp) + " actual ->" + innerFragmentElementsNames, SetUpUtils.compareStringLists(Arrays.asList(innerFragmentElementsNamesExp), innerFragmentElementsNames));
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(outerFragmentElementsNamesExp) + " actual ->" + outerFragmentElementsNames, SetUpUtils.compareStringLists(Arrays.asList(outerFragmentElementsNamesExp), outerFragmentElementsNames));
		Assert.assertTrue("Incorrect substitution: expected ->" + Arrays.asList(elementsInternalNamesExp) + " actual ->" + elementsInternalNames, SetUpUtils.compareStringLists(Arrays.asList(elementsInternalNamesExp), elementsInternalNames));
		
		HashSet<EObject> elements = this.fecthContent();
		for(EObject object : elements){
			Assert.assertNotNull("object has not resource " + object, object.eResource());
			Assert.assertTrue("wrong recourse " + object + " " + object.eResource(), baseModel.equals(object.eResource()));
		}
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}
	
	private EList<EObject> getOutsideBoundaryElemenetsToPlacements(FragmentSubstitutionHolder fragmentHolder){
		EList<ToBinding> toBindings = fragmentHolder.getToBindings();
		HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryMap = fragmentHolder.getToPlacementOutsideBoundaryElementMap();
		EList<EObject> list = new BasicEList<EObject>();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			HashSet<ObjectHandle> outsideBoundaryElements = outsideBoundaryMap.get(toPlacement);
			list.addAll(SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(outsideBoundaryElements)));
		}
		return list;
	}
	
	private EList<EObject> getOutsideBoundaryElemenetsFromPlacements(FragmentSubstitutionHolder fragmentHolder){
		EList<FromBinding> fromBindings = fragmentHolder.getFromBinding();
		EList<EObject> list = new BasicEList<EObject>();
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			list.addAll(SetUpUtils.resolveObjectHandles(fromPlacement.getOutsideBoundaryElement()));
		}
		return list;
	}
	
	private void checkInsideBoundaryElements(FragmentSubstitutionHolder fragmentSubHolder){
		EList<ToBinding> toBindings = fragmentSubHolder.getToBindings();
		EList<FromBinding> fromBindings = fragmentSubHolder.getFromBinding();
		HashSet<EObject> innerElements = fragmentSubHolder.getPlacement().getInnerFragmentElements();
		for(ToBinding toBinding : toBindings){
			ToPlacement toPlacement = toBinding.getToPlacement();
			EList<EObject> insideBoundaryElements = SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(this.getInsideBoundaryElements(toPlacement)));
			for(EObject insideBoundaryElement : insideBoundaryElements){
				if(!innerElements.contains(insideBoundaryElement)){
					Assert.fail("insideBoundaryElement reference of a toPlacement points to an incorect element: " + insideBoundaryElement);
				}
			}
		}
		
		for(FromBinding fromBinding : fromBindings){
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			EList<EObject> insideBoundaryElements = SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(this.getInsideBoundaryElements(fromPlacement)));
			for(EObject insideBoundaryElement : insideBoundaryElements){
				if(!innerElements.contains(insideBoundaryElement)){
					Assert.fail("insideBoundaryElement reference of a toPlacement points to an incorect element: " + insideBoundaryElement);
				}
			}
		}		
	}
	
	private HashSet<EObject> fecthContent(){
		HashSet<EObject> set = new HashSet<EObject>();
		TreeIterator<EObject> iterator = baseModel.getAllContents();
		while(iterator.hasNext()){
			EObject eObject = iterator.next();
			set.add(eObject);
			set.addAll(eObject.eCrossReferences());
		}
		return set;
	}
	
	private EList<EObject> getOutsideBoundaryElementsFragment(FragmentSubstitutionHolder fragmentSubHolder){
		EList<EObject> list = new BasicEList<EObject>();
		EList<ToBinding> toBindings = fragmentSubHolder.getToBindings();
		HashMap<ToPlacement, HashSet<ObjectHandle>> outsideBoundaryMap = fragmentSubHolder.getToPlacementOutsideBoundaryElementMap();
		for(ToBinding toBinding : toBindings){
			HashSet<ObjectHandle> outsideBoundaryElements = outsideBoundaryMap.get(toBinding.getToPlacement());
			list.addAll(SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(outsideBoundaryElements)));
		}
		EList<FromBinding> fromBindings = fragmentSubHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			HashSet<ObjectHandle> elements = this.getOutsideBoundaryElements(fromBinding.getFromPlacement());
			list.addAll(SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(elements)));
		}
		return list;
	}
	
	private EList<EObject> getInsideBoundaryElementsFragment(FragmentSubstitutionHolder fragmentSubHolder){
		EList<EObject> list = new BasicEList<EObject>();
		HashMap<FromPlacement, HashSet<ObjectHandle>> insideBoundaryMap = fragmentSubHolder.getFromPlacementInsideBoundaryElementMap();
		EList<ToBinding> toBindings = fragmentSubHolder.getToBindings();
		for(ToBinding toBinding : toBindings){
			EList<ObjectHandle> insideBoundary = toBinding.getToPlacement().getInsideBoundaryElement();
			list.addAll(SetUpUtils.resolveObjectHandles(insideBoundary));
		}
		EList<FromBinding> fromBindings = fragmentSubHolder.getFromBinding();
		for(FromBinding fromBinding : fromBindings){
			HashSet<ObjectHandle> insideBoundary = insideBoundaryMap.get(fromBinding.getFromPlacement());
			list.addAll(SetUpUtils.resolveObjectHandles(new BasicEList<ObjectHandle>(insideBoundary)));
		}
		return list;
	}
	
	private HashSet<ObjectHandle> getInsideBoundaryElements(PlacementBoundaryElement plcBElement){
		HashSet<ObjectHandle> insideBoundaryElements = new HashSet<ObjectHandle>();
		if(plcBElement instanceof ToPlacement){
			insideBoundaryElements.addAll(((ToPlacement) plcBElement).getInsideBoundaryElement());
		}
		if(plcBElement instanceof FromPlacement){
			insideBoundaryElements.add(((FromPlacement) plcBElement).getInsideBoundaryElement());
		}
		return insideBoundaryElements;
	}
	
	private HashSet<ObjectHandle> getOutsideBoundaryElements(PlacementBoundaryElement plcBElement){
		HashSet<ObjectHandle> insideBoundaryElements = new HashSet<ObjectHandle>();
		if(plcBElement instanceof ToPlacement){
			insideBoundaryElements.add(((ToPlacement) plcBElement).getOutsideBoundaryElement());
		}
		if(plcBElement instanceof FromPlacement){
			insideBoundaryElements.addAll(((FromPlacement) plcBElement).getOutsideBoundaryElement());
		}
		return insideBoundaryElements;
	}
}
