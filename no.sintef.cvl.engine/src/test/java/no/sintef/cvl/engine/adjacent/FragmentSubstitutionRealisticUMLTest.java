package no.sintef.cvl.engine.adjacent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFragmentImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.common.EngineUtility;
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.UMLPackage;
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
import cvl.ToPlacement;
import cvl.VariationPoint;

public class FragmentSubstitutionRealisticUMLTest {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder1;
	private FragmentSubstitutionHolder fragmentSubHolder2;

	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/realistic/modelSafetyModule0/SafetyDrive.cor.new.cvl");
		UMLPackage.eINSTANCE.eClass();
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
		fragmentSubHolder2 = new FragmentSubstitutionHolder(fragSubs.get(1));
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("model.uml"), false);
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
		
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);

		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
		adjacentResolver.resolve(fragmentSubHolder1);

		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(true);
		adjacentResolver.resolve(fragmentSubHolder2);
		
		SetUpUtils.writeToFile(baseModel, "model_new.uml");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.uml", "model_new.uml"));
	}
}
