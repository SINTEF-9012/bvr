package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BVRModelSingleton {
	static Map<File, BVRModel> loaded = new HashMap<File, BVRModel>();
	
	public static BVRModel getModel(File f){
		BVRModel m;
		if(loaded.containsKey(f)){
			m = loaded.get(f);
		}else{
			m = new BVRModel(f);
			loaded.put(f, m);
		}
		
		return m;
	}
}
