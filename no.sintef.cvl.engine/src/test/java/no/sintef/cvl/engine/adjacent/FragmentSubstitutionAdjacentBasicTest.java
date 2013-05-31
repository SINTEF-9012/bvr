package no.sintef.cvl.engine.adjacent;

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
import no.sintef.cvl.engine.fragment.FragSubHolder;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import no.sintef.cvl.engine.testutils.SetUpUtils;
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

public class FragmentSubstitutionAdjacentBasicTest {

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

	@Before
	public void setUp() throws Exception {
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
		System.out.println(cu.eResource().getResourceSet());
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		System.out.println(cu.eResource().getResourceSet());
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testAdjacentTest1() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
	}
	
	@Test
	public void testAdjacentTest2() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
		
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList1 = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList1.add(fragmentSubHolder1);
		fragmentSubHolderList1.add(fragmentSubHolder3);
		fragmentSubHolderList1.add(fragmentSubHolder2);
		AdjacentFinderImpl adjacenFinder1 = new AdjacentFinderImpl(fragmentSubHolderList1);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap1 = adjacenFinder1.getAdjacentMap();
		
		AdjacentFragment adjacent11 = adjacentMap1.get(fragmentSubHolder1);
		AdjacentFragment adjacent12 = adjacentMap1.get(fragmentSubHolder2);
		AdjacentFragment adjacent13 = adjacentMap1.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent11.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent12.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent11));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent13));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent1.getFragmentHolder()));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent13.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent13.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From21 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To21 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To21);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From31 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To11 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From31.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To11.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To1)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To11)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From21 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To21 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From21);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To2)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To21)));
	}
	
	@Test
	public void testAdjacentTest3() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
		
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList1 = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList1.add(fragmentSubHolder2);
		fragmentSubHolderList1.add(fragmentSubHolder1);
		fragmentSubHolderList1.add(fragmentSubHolder3);
		AdjacentFinderImpl adjacenFinder1 = new AdjacentFinderImpl(fragmentSubHolderList1);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap1 = adjacenFinder1.getAdjacentMap();
		
		AdjacentFragment adjacent11 = adjacentMap1.get(fragmentSubHolder1);
		AdjacentFragment adjacent12 = adjacentMap1.get(fragmentSubHolder2);
		AdjacentFragment adjacent13 = adjacentMap1.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent11.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent12.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent11));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent13));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent1.getFragmentHolder()));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent13.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent13.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From21 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To21 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To21);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From31 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To11 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From31.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To11.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To1)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To11)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From21 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To21 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From21);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To2)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To21)));
	}
	
	@Test
	public void testAdjacentTest4() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
		
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList1 = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList1.add(fragmentSubHolder2);
		fragmentSubHolderList1.add(fragmentSubHolder3);
		fragmentSubHolderList1.add(fragmentSubHolder1);
		AdjacentFinderImpl adjacenFinder1 = new AdjacentFinderImpl(fragmentSubHolderList1);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap1 = adjacenFinder1.getAdjacentMap();
		
		AdjacentFragment adjacent11 = adjacentMap1.get(fragmentSubHolder1);
		AdjacentFragment adjacent12 = adjacentMap1.get(fragmentSubHolder2);
		AdjacentFragment adjacent13 = adjacentMap1.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent11.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent12.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent11));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent13));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent1.getFragmentHolder()));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent13.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent13.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From21 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To21 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To21);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From31 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To11 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From31.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To11.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To1)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To11)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From21 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To21 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From21);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To2)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To21)));
	}
	
	@Test
	public void testAdjacentTest5() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
		
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList1 = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList1.add(fragmentSubHolder3);
		fragmentSubHolderList1.add(fragmentSubHolder1);
		fragmentSubHolderList1.add(fragmentSubHolder2);
		AdjacentFinderImpl adjacenFinder1 = new AdjacentFinderImpl(fragmentSubHolderList1);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap1 = adjacenFinder1.getAdjacentMap();
		
		AdjacentFragment adjacent11 = adjacentMap1.get(fragmentSubHolder1);
		AdjacentFragment adjacent12 = adjacentMap1.get(fragmentSubHolder2);
		AdjacentFragment adjacent13 = adjacentMap1.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent11.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent12.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent11));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent13));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent1.getFragmentHolder()));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent13.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent13.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From21 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To21 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To21);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From31 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To11 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From31.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To11.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To1)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To11)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From21 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To21 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From21);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To2)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To21)));
	}

	@Test
	public void testAdjacentTest6() throws Exception {
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap = adjacenFinder.getAdjacentMap();
		
		AdjacentFragment adjacent1 = adjacentMap.get(fragmentSubHolder1);
		AdjacentFragment adjacent2 = adjacentMap.get(fragmentSubHolder2);
		AdjacentFragment adjacent3 = adjacentMap.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent1.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent1.getAdjacentFragmentsList().get(0).equals(adjacent2));
		Assert.assertTrue("the fragment should be adjacent", adjacent2.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent1));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent2.getAdjacentFragmentsList().contains(adjacent3));
		Assert.assertTrue("the fragment should be adjacent", adjacent3.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent3.getAdjacentFragmentsList().get(0).equals(adjacent2));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From2 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To2 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To2);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From3 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To1 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From3.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To1.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From2, SetUpUtils.reverseMap(adjacentBindings2To1)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From2 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To2 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To2.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From3, SetUpUtils.reverseMap(adjacentBindings3To2)));
		
		
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList1 = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList1.add(fragmentSubHolder3);
		fragmentSubHolderList1.add(fragmentSubHolder2);
		fragmentSubHolderList1.add(fragmentSubHolder1);
		AdjacentFinderImpl adjacenFinder1 = new AdjacentFinderImpl(fragmentSubHolderList1);
		HashMap<FragSubHolder, AdjacentFragment> adjacentMap1 = adjacenFinder1.getAdjacentMap();
		
		AdjacentFragment adjacent11 = adjacentMap1.get(fragmentSubHolder1);
		AdjacentFragment adjacent12 = adjacentMap1.get(fragmentSubHolder2);
		AdjacentFragment adjacent13 = adjacentMap1.get(fragmentSubHolder3);
		Assert.assertTrue("the fragment should be adjacent", adjacent11.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent11.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent12.getAdjacentFragmentsList().size() == 2);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent11));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent12.getAdjacentFragmentsList().contains(adjacent13));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent1.getFragmentHolder()));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", this.getFragmentSubstitutionHolders(adjacent12.getAdjacentFragmentsList()).contains(adjacent13.getFragmentHolder()));
		Assert.assertTrue("the fragment should be adjacent", adjacent13.getAdjacentFragmentsList().size() == 1);
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).equals(adjacent12));
		Assert.assertTrue("the fragment is adjacent to the wrong fragment", adjacent13.getAdjacentFragmentsList().get(0).getFragmentHolder().equals(adjacent2.getFragmentHolder()));
		
		HashMap<FromBinding, ToBinding> adjacentBindings1From21 = adjacent1.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings1To21 = adjacent1.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent1.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent1.getAllAdjacentToBindings().size() == 0);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings1From21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent ToBinding", adjacentBindings1To21);
		
		HashMap<FromBinding, ToBinding> adjacentBindings2From31 = adjacent2.getAdjacentFromBindings(adjacent3);
		HashMap<ToBinding, FromBinding> adjacentBindings2To11 = adjacent2.getAdjacentToBindings(adjacent1);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent2.getAllAdjacentFromBindings().size() == 1);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent2.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent FromBinding", adjacentBindings2From31.size() == 2);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings2To11.size() == 2);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To1)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings1From21, SetUpUtils.reverseMap(adjacentBindings2To11)));
		
		HashMap<FromBinding, ToBinding> adjacentBindings3From21 = adjacent3.getAdjacentFromBindings(adjacent2);
		HashMap<ToBinding, FromBinding> adjacentBindings3To21 = adjacent3.getAdjacentToBindings(adjacent2);
		Assert.assertTrue("the set of adjacent FromBinding-s is wrong", adjacent3.getAllAdjacentFromBindings().size() == 0);
		Assert.assertTrue("the set of adjacent ToBinding-s is wrong", adjacent3.getAllAdjacentToBindings().size() == 1);
		Assert.assertTrue("the fragment should have 2 adjacent ToBinding", adjacentBindings3To21.size() == 2);
		Assert.assertNull("the fragment shoudl to have any adjacent FromBinding", adjacentBindings3From21);
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To2)));
		Assert.assertTrue("wrong set of adjacent bindings", SetUpUtils.compareHashMaps(adjacentBindings2From31, SetUpUtils.reverseMap(adjacentBindings3To21)));
	}
	
	private EList<FragmentSubstitutionHolder> getFragmentSubstitutionHolders(EList<AdjacentFragment> adjacentFragmants){
		EList<FragmentSubstitutionHolder> fragSubHolders = new BasicEList<FragmentSubstitutionHolder>();
		for(AdjacentFragment adjacentFragment : adjacentFragmants){
			fragSubHolders.add((FragmentSubstitutionHolder) adjacentFragment.getFragmentHolder());
		}
		return fragSubHolders;
	}
}
