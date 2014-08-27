package no.sintef.bvr.engine.deleteme;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import no.sintef.bvr.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.bvr.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.operation.impl.FragmentSubOperation;
import no.sintef.bvr.engine.testutils.SetUpUtils;
import node.NodePackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Assert;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class FragmentSubstitutionAdjacentEst {
	//@Before
	public void setUp() throws Exception {
		NodePackage.eINSTANCE.eClass();
	}

	//@After
	public void tearDown() throws Exception {
		//SetUpUtils.tearDown(map);
	}
	
	//@Test
	public void testAdjacentTrue() throws Exception {
		int maxExp = 1;
		EList<Long> finderTime = new BasicEList<Long>();
		EList<Long> pureSubTime = new BasicEList<Long>();
		EList<Long> pureResTime = new BasicEList<Long>();
		EList<Long> overSingSubTime = new BasicEList<Long>();
		EList<Long> overSubTime = new BasicEList<Long>();
		
		File dir = new File("src/test/resources/estimate/size/exp7/");
		String path = dir.getAbsolutePath();
		String wsdir = System.getProperty("user.dir");
		System.setProperty( "user.dir", path);
		
		String bvr_file_name = "node_new_elem_300.bvr";
		String base_file_name = "base_elem_300.node";
		for(int j=0; j<maxExp; j++){
			BasicEList<FragmentSubstitution> fragSubs = new BasicEList<FragmentSubstitution>();
			File file = new File(bvr_file_name);
			HashMap<String, Object> map = SetUpUtils.loadSimple(file);
			BVRModel cu = (BVRModel) ((Resource) map.get("resource")).getContents().get(0);
			EList<VariationPoint> vps = cu.getRealizationModel();
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
			
			Resource baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI(base_file_name), true);
			Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
			
			
			EList<FragmentSubstitutionHolder> fragmentSubHolderList = new BasicEList<FragmentSubstitutionHolder>();
			for(FragmentSubstitution fs : fragSubs){
				fragmentSubHolderList.add(new FragmentSubstitutionHolder(fs));
			}
			//System.out.println(fragSubs.size());
			long t1finder = (new Date()).getTime();
			AdjacentFinderImpl adjacenFinder = new AdjacentFinderImpl(fragmentSubHolderList);
			long t2finder = (new Date()).getTime();
			finderTime.add(t2finder-t1finder);
			
			AdjacentResolverImpl adjacentResolver = new AdjacentResolverImpl(adjacenFinder);
			
			long t1overal = (new Date()).getTime();
			for(FragmentSubstitutionHolder fsh : fragmentSubHolderList){
				long t1subst = (new Date()).getTime();
				FragmentSubOperation fso = new FragmentSubOperation(fsh);
				fso.execute(true);
				long t2subst = (new Date()).getTime();
				pureSubTime.add(t2subst-t1subst);
				adjacentResolver.resolve(fsh);
				long t3subst = (new Date()).getTime();
				pureResTime.add(t3subst-t2subst);
				overSingSubTime.add(t3subst - t1subst);
				System.out.println(fsh.getFragment().getName());
				break;
			}
			long t2overal = (new Date()).getTime();
			overSubTime.add(t2overal-t1overal);
						
			SetUpUtils.writeToFile(baseModel, "base_new.node");
		}
		printOut("Finder:", finderTime);
		printOut("One pure substitution:", pureSubTime);
		printOut("One pure resolution:", pureResTime);
		printOut("Overal single substitution:", overSingSubTime);
		printOut("Overal substitutions:", overSubTime);
		
		System.setProperty( "user.dir", wsdir);
	}

	private void printOut(String string, EList<Long> list) {
		System.out.println("");
		System.out.print(string + " ");
		for(Long value : list){
			System.out.print(value +";");
		}
		
		
	}
	
}
