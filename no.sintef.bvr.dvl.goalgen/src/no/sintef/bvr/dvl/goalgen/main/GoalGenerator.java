package no.sintef.bvr.dvl.goalgen.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import bvr.BVRModel;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import no.sintef.bvr.dvl.goalgen.interfaces.main.IGoalGenerator;
import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IFeature;
import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IProduct;
import no.sintef.bvr.dvl.goalgen.pojo.Feature;
import no.sintef.bvr.dvl.goalgen.pojo.Product;

public class GoalGenerator implements IGoalGenerator {
	
	private String file_path;
	private String folder_path;
	private String extension = "resolution";
	
	public GoalGenerator(String _path, String _folder_path) {
		file_path = _path;
		folder_path = _folder_path;
	}

	@Override
	public List<IProduct> getProducts(BVRModel model) {
		List<IProduct> products = new ArrayList<IProduct>();
		EList<CompoundResolution> resolutions = model.getResolutionModels();
		List<VSpec> vspecs = flattenVSpecModel(model);
		
		int index = 0;
		for(CompoundResolution resolution : resolutions) {
			String name = resolution.getName();
			name = (name != null && !name.equals("")) ? name : "product" + index;
			IProduct product = new Product(name);
			List<VSpecResolution> vspecres = flattenResolutionModel(resolution);
			Map<VSpec, Boolean> resolved_map = new HashMap<VSpec, Boolean>();
			for(VSpec vspec : vspecs)
				resolved_map.put(vspec, false);
			
			for(VSpecResolution res : vspecres) {
				boolean isPositive = (res instanceof PosResolution) ? true : false;
				resolved_map.put(res.getResolvedVSpec(), isPositive);
			}
			
			Set<VSpec> keys = resolved_map.keySet();
			for(VSpec key : keys) {
				IFeature feature = new Feature(key.getName(), resolved_map.get(key));
				product.addFeature(feature);
			}
			products.add(product);
			index++;
		}
		return products;
	}

	@Override
	public void writeProducts(List<IProduct> products) throws IOException {
		
		for(IProduct product : products) {
			String goal_full_path = folder_path + product.getName() + "." + extension;
			File file = new File(goal_full_path);
			String content = product.toString();
			if(file.exists()) file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		}
		
	}
	
	private List<VSpec> flattenVSpecModel(BVRModel model) {
		List<VSpec> list = new ArrayList<VSpec>();
		CompoundNode root = model.getVariabilityModel();
		parseVSpecModel(root, list);
		return list;
	}
	
	private void parseVSpecModel(CompoundNode node, List<VSpec> vspec) {
		vspec.add((VSpec) node);
		
		EList<VNode> members = node.getMember();
		for(VNode member : members) {
			if(member instanceof Choice)
				parseVSpecModel((CompoundNode) member, vspec);
		}
	}
	
	private List<VSpecResolution> flattenResolutionModel(CompoundResolution resolution) {
		List<VSpecResolution> list = new ArrayList<VSpecResolution>();
		parseResolutonModel(resolution, list);
		return list;
	}
	
	private void parseResolutonModel(VSpecResolution resolution, List<VSpecResolution> list) {
		list.add(resolution);
		
		if(resolution instanceof CompoundResolution) {
			EList<VSpecResolution> resolutions = ((CompoundResolution) resolution).getMembers();
			for(VSpecResolution res : resolutions) {
				if(res instanceof PosResolution || res instanceof NegResolution)
					parseResolutonModel(res, list);
			}
		}
	}

	@Override
	public void generate() {
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("bvr", new XMIResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file_path, true), true);
		
		BVRModel model = (BVRModel) resource.getContents().get(0);
		
		try {
			writeProducts(getProducts(model));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
