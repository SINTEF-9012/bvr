package no.sintef.cvl.engine.deleteme;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
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

public class FragmentSubstitutionAdjacentEst {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;

	@Before
	public void setUp() throws Exception {
		nodePackage.eINSTANCE.eClass();
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/estimate/size/exp4/node_new_adjfrag_5.cvl");
		//file = new File("src/test/resources/estimate/size/exp2/node_new_binding_5000.cvl");
		//file = new File("src/test/resources/estimate/size/exp3/node_new_adjbinding_1.cvl");
		//file = new File("src/test/resources/estimate/size/exp1/node_new_1000.cvl");
		//file = new File("src/test/resources/nodeAdjacent/exp1mod/node_new_9.cvl");
		//file = new File("src/test/resources/nodeAdjacent/exp1adjless/node_new_10.cvl");
		//file = new File("src/test/resources/estimate/boundarySize/exp1/node_new_binding_1000.cvl");
		map = SetUpUtils.load(file);
		cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getOwnedVariationPoint();
		int i = 0;
		int max = 512;
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSubs.add((FragmentSubstitution) vp);
				i++;
				if(i == max)
					break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testAdjacentTrue() throws Exception {
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_adjfrag_5.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_adjbinding_1.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_binding_5000.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_binding_1000.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_1000.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_9.node"), true);
		//baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base_10.node"), true);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
		
		
		EList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
		for(FragmentSubstitution fs : fragSubs){
			fragmentSubHolderList.add(new FragmentSubstitutionHolder(fs));
		}
		System.out.println(fragSubs.size());
		System.out.println((new Date()).toString());
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		System.out.println((new Date()).toString());
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		
		for(FragmentSubstitutionHolder fsh : fragmentSubHolderList){
			//System.out.println(fsh.getFragment().getName());
			//System.out.println(adjacenFinder.getAdjacentMap().get(fsh).getAdjacentFragments());
			//System.out.println(adjacenFinder.getAdjacentMap().get(fsh).getAllAdjacentFromBindings());
			//System.out.println(adjacenFinder.getAdjacentMap().get(fsh).getAllAdjacentToBindings());
			FragmentSubOperation fso = new FragmentSubOperation(fsh);
			fso.execute(true);
			adjacentResolver.resolve(fsh);
		}
		System.out.println((new Date()).toString());
					
		SetUpUtils.writeToFile(baseModel, "base_new.node");
	}
	
}
