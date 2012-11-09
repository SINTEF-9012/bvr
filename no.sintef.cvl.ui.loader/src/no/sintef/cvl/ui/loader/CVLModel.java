package no.sintef.cvl.ui.loader;

import java.io.File;

public class CVLModel {
	private no.sintef.ict.splcatool.CVLModel cvlm;
	private File f;

	public CVLModel(File f) {
		this.f = f;
		cvlm = new no.sintef.ict.splcatool.CVLModel(f);
	}
	
	String getShortFileName(){
		return f.getName();
	}

	String getLongFileName(){
		return f.getAbsolutePath();
	}
	
	no.sintef.ict.splcatool.CVLModel getCVLM(){
		return cvlm;
	}
}
