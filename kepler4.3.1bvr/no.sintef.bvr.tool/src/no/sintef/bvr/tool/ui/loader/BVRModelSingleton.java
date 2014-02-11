package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.ui.IWorkbenchPart;

public class BVRModelSingleton {
	static Map<File, BVRModel> loaded = new HashMap<File, BVRModel>();
	static Map<BVRModel, File> loadedrev = new HashMap<BVRModel, File>();
	static Map<BVRModel, List<IWorkbenchPart>> views = new HashMap<BVRModel, List<IWorkbenchPart>>();
	
	public static BVRModel getModel(File f, IWorkbenchPart iwp){
		
		if(!loaded.containsKey(f)){
			BVRModel newm = new BVRModel(f);
			loaded.put(f, newm);
			loadedrev.put(newm, f);
			views.put(newm, new ArrayList<IWorkbenchPart>());
		}
		
		BVRModel m = loaded.get(f);
		views.get(m).add(iwp);
		
		return m;
	}

	public static void editorClosed(IWorkbenchPart x) {
		for(Entry<BVRModel, List<IWorkbenchPart>> z : views.entrySet()){
			if(z.getValue().contains(x)){
				z.getValue().remove(x);
				if(z.getValue().size() == 0){
					BVRModel m = z.getKey();
					File f = loadedrev.get(m);
					//System.out.println("Unloading " + m + ", " + f);
					loaded.remove(f);
					loadedrev.remove(m);
				}
			}
		}
	}
}
