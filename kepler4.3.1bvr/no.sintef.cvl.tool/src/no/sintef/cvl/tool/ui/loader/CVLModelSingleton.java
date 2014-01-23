package no.sintef.cvl.tool.ui.loader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CVLModelSingleton {
	static Map<File, CVLModel> loaded = new HashMap<File, CVLModel>();
	
	public static CVLModel getModel(File f){
		CVLModel m;
		if(loaded.containsKey(f)){
			m = loaded.get(f);
		}else{
			m = new CVLModel(f);
			loaded.put(f, m);
		}
		
		return m;
	}
}
