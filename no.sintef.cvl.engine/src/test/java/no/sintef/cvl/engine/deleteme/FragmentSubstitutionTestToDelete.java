package no.sintef.cvl.engine.deleteme;

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
import no.sintef.cvl.engine.common.SubstitutionContext;
import no.sintef.cvl.engine.common.EngineUtility;
import no.sintef.cvl.engine.fragment.FragSubHolder;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.logging.Logger;
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

public class FragmentSubstitutionTestToDelete {

	private File file;
	private HashMap<String, Object> map;
	private ConfigurableUnit cu;
	private EList<FragmentSubstitution> fragSubs;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder1;
	private FragmentSubstitutionHolder fragmentSubHolder2;
	private FragmentSubstitutionHolder fragmentSubHolder3;
	private Resource libModel;
	private static final String[] o = new String[] {"0", "00"};
	private static final String[] o1 = new String[] {"14"};
	private static final String[] p1 = new String[] {"r1", "r2", "r3", "r4", "r5"};
	private static final String[] p2 = new String[] {"r6", "r7", "r8", "r9", "r10"};
	private static final String[] p3 = new String[] {"r11", "r12", "r13"};
	private static final String[] p1orig = new String[] {"1", "2", "3", "4", "5"};
	private static final String[] p2orig = new String[] {"6", "7", "8", "9", "10"};
	private static final String[] p3orig = new String[] {"11", "12", "13"};
	private EList<EObject> visited = new BasicEList<EObject>();
	private EObject toRemove;

	@Before
	public void setUp() throws Exception {
		fragSubs = new BasicEList<FragmentSubstitution>();
		file = new File("src/test/resources/nodeWorkingCopy/realistic/modelSafetyModule0/SafetyDrive.cor.new.cvl");
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
		libModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("model.uml"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
		Assert.assertNotNull("lib model is not found, the test cases can not be executed", libModel);
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
		//System.out.println(fragmentSubHolder1.getPlacement().getElements());
		//System.out.println(fragmentSubHolder2.getPlacement().getOuterFragmentElements());
		
		AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
		AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
		//this.fecthContent1();
		//fecthContent();
		
		AdjacentFragment adj1 = adjacenFinder.getAdjacentMap().get(fragmentSubHolder1);
		AdjacentFragment adj2 = adjacenFinder.getAdjacentMap().get(fragmentSubHolder2);
		
		FragmentSubOperation fso1 = new FragmentSubOperation(fragmentSubHolder1);
		fso1.execute(true);
		adjacentResolver.resolve(fragmentSubHolder1);

		FragmentSubOperation fso2 = new FragmentSubOperation(fragmentSubHolder2);
		fso2.execute(true);
		adjacentResolver.resolve(fragmentSubHolder2);
		
		SetUpUtils.writeToFile(baseModel, "model_new.uml");
	}
	
	private HashSet<EObject> resolveCollection(Collection<Setting> set){
		System.out.println("****** resolveCollection");
		HashSet<EObject> resolved = new HashSet<EObject>();
		for(Setting eObject: set){
			resolved.add(eObject.getEObject());
			System.out.println(eObject.getEObject().eResource());
		}
		return resolved;
	}
	
	private void cleanBinding(){
		for(FragmentSubstitution fragSub : fragSubs){
			EList<ObjectHandle> sourceObjects = fragSub.getSourceObject();
			for(Iterator<ObjectHandle> iterator = sourceObjects.iterator(); iterator.hasNext();){
				ObjectHandle objectHandle = iterator.next();
				EObject eObject = objectHandle.getMOFRef();
				if(eObject != null){
					EStructuralFeature property = eObject.eClass().getEStructuralFeature("name");
					if(property != null){
						String name = (String) eObject.eGet(property);
						if(name.equals("sm")){
							System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
							//EcoreUtil.remove(objectHandle);
							iterator.remove();
						}
					}
				}
			}
		}
	}
	
	private void fecthBinding(){
		for(FragmentSubstitution fragSub : fragSubs){
			EList<ObjectHandle> sourceObjects = fragSub.getSourceObject();
			System.out.println("0000000000000000000000000000000000000000000000");
			for(Iterator<ObjectHandle> iterator = sourceObjects.iterator(); iterator.hasNext();){
				ObjectHandle objectHandle = iterator.next();
				EObject eObject = objectHandle.getMOFRef();
				System.out.println(eObject);
				/*if(eObject != null){
					System.out.println(eObject.eContents());
					System.out.println(eObject.eCrossReferences());
				}*/
			}
		}
	}
	
	private void fecthContent(){
		TreeIterator<EObject> iterator = baseModel.getAllContents();
		while(iterator.hasNext()){
			EObject eObject = iterator.next();
			System.out.println("**************************************");
			//System.out.println(eObject.eResource());
			EList<EObject> crossReferences = eObject.eCrossReferences();
			EList<EObject> contents = eObject.eContents();
			System.out.println(crossReferences);
			System.out.println(contents);
		}
	}
	
	private void fecthContent1(){
		visited = new BasicEList<EObject>();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		EList<EObject> cont = baseModel.getContents();
		for(EObject eObject : cont){
			//System.out.println(eObject);
			this.traverse(eObject);
		}
	}
	
	private void traverse(EObject eObject){
		EStructuralFeature property = eObject.eClass().getEStructuralFeature("name");
		if(property != null){
			String name = (String) eObject.eGet(property);
			if(name != null && name.equals("sm")){
				System.out.println(eObject);
				System.out.println(eObject.eContainer());
				System.out.println(EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource()));
				if(eObject.eContainer() == null && EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource()).size() == 0){
					toRemove = eObject;
				}
			}
		}
		visited.add(eObject);
		EList<EObject> crossReferences = eObject.eCrossReferences();
		for(EObject crossEObject : crossReferences){
			if(!visited.contains(crossEObject))
				traverse(crossEObject);
		}
		EList<EObject> contents = eObject.eContents();
		for(EObject contEObject : contents){
			if(!visited.contains(contEObject))
				traverse(contEObject);
		}
	}	
}
