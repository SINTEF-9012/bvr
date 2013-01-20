package no.sintef.cvl.engine.deleteme;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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

	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/nodeWorkingCopy/adjacent/exp1/node.new.cvl");
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
		BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
		fragmentSubHolderList.add(fragmentSubHolder2);
		fragmentSubHolderList.add(fragmentSubHolder3);
		
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
		adjacentResolver.resolve(fragmentSubHolder1);
		
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(true);
		adjacentResolver.resolve(fragmentSubHolder2);
				
		FragmentSubOperation fso3 = new FragmentSubOperation(fragmentSubHolder3);
		fso3.execute(true);
		adjacentResolver.resolve(fragmentSubHolder3);
						
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		
		
		/*BasicEList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		fragmentSubHolderList.add(fragmentSubHolder1);
		fragmentSubHolderList.add(fragmentSubHolder2);
		
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		ArrayList<AdjacentFragment> adjacentFragments = Lists.newArrayList(adjacenFinder.getAdjacentMap().values());
		//System.out.println(adjacentFragments.get(0).getAdjacentFragments());
		//System.out.println(adjacentFragments.get(1).getAdjacentFragments());
		
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
				
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(true);
		ToBinding toBinding = fragmentSubHolder2.getToBindings().get(1);
		//System.out.println(this.resolveObjectHandles(toBinding.getToPlacement().getOutsideBoundaryElement()));
		System.out.println(this.resolveObjectHandles(toBinding.getToPlacement().getInsideBoundaryElement()));
		//System.out.println(fragmentSubHolder2.getPlacement().getInnerFragmentElements());
		//System.out.println(fragmentSubHolder2.getPlacement().getOuterFragmentElements());
		
		adjacentResolver.resolve(fragmentSubHolder2);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
		FromBinding fromBinding = fragmentSubHolder1.getFromBinding().get(0);
		System.out.println(this.resolveObjectHandles(fromBinding.getFromPlacement().getOutsideBoundaryElement()));
		//System.out.println(this.resolveObjectHandles(fromBinding.getFromPlacement().getInsideBoundaryElement()));
		//System.out.println(fragmentSubHolder1.getPlacement().getInnerFragmentElements());
		//System.out.println(fragmentSubHolder1.getPlacement().getOuterFragmentElements());
		
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		//Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		//fso.execute(true);
		//SetUpUtils.writeToFile(baseModel, "base_new.node");
		//Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));*/
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
