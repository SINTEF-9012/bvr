package no.sintef.cvl.engine.todelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;


import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import node.NodePackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;
import cvl.cvlPackage;

public class RunExp {

	/**
	 * @param args
	 * @throws BasicCVLEngineException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws BasicCVLEngineException, IOException {
		NodePackage.eINSTANCE.eClass();
		int maxExp = 1;
		EList<Long> finderTime = new BasicEList<Long>();
		EList<Long> pureSubTime = new BasicEList<Long>();
		EList<Long> pureResTime = new BasicEList<Long>();
		EList<Long> overSingSubTime = new BasicEList<Long>();
		EList<Long> overSubTime = new BasicEList<Long>();
		
		//File dir = new File("src/test/resources/estimate/size/exp7/");
		//String path = dir.getAbsolutePath();
		//String wsdir = System.getProperty("user.dir");
		//System.setProperty( "user.dir", path);
		
		//String cvl_file_name = "node_new_elem_300.cvl";
		//String base_file_name = "base_elem_300.node";
		String cvl_file_name = args[0];
		String base_file_name = args[1];
		for(int j=0; j<maxExp; j++){
			BasicEList<FragmentSubstitution> fragSubs = new BasicEList<FragmentSubstitution>();
			File file = new File(cvl_file_name);
			HashMap<String, Object> map = loadSimple(file);
			ConfigurableUnit cu = (ConfigurableUnit) ((Resource) map.get("resource")).getContents().get(0);
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
			
			Resource baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI(base_file_name), true);
			if(baseModel == null){
				System.out.println("base model is not found, the test cases can not be executed");
				return;
			}
			
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
						
			writeToFile(baseModel, "base_new.node");
		}
		
		String file_name = cvl_file_name.replace(".cvl", "");
		File file = new File("results/" + file_name + ".txt");
		if(!file.exists()){
			file.createNewFile();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		
		printOut("Finder:", finderTime, bw);
		printOut("One pure substitution:", pureSubTime, bw);
		printOut("One pure resolution:", pureResTime, bw);
		printOut("Overal single substitution:", overSingSubTime, bw);
		printOut("Overal substitutions:", overSubTime, bw);
		
		bw.append("\n");
		bw.close();
		
		//System.setProperty( "user.dir", wsdir);
	}
	
	private static void printOut(String string, EList<Long> list, BufferedWriter bw) throws IOException {
		String line = "";
		line = string + " ";
		for(Long value : list){
			line+=value +";";
		}
		line+="\n";
		bw.append(line);
	}
	
	private static HashMap<String, Object> loadSimple(File file){
		cvlPackage.eINSTANCE.eClass();
		ResourceSetImpl resSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(URI.createFileURI(file.getName()), true);
		HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("wsdir", wsdir);
		map.put("resSet", resSet);
		map.put("resource", resource);
		return map;
	}
	
	private static void writeToFile(Resource resource, String name) throws IOException{
		resource.setURI(URI.createFileURI(name));
		resource.save(Collections.EMPTY_MAP);
	}

}
