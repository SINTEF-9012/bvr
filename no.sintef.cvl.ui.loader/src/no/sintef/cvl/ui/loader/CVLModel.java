package no.sintef.cvl.ui.loader;

import java.io.File;

import cvl.VSpec;

public class CVLModel {
	private no.sintef.ict.splcatool.CVLModel cvlm;
	private File f;

	public CVLModel(File f) {
		this.f = f;
		cvlm = new no.sintef.ict.splcatool.CVLModel(f);
	}
	
	public CVLModel(File sf, no.sintef.ict.splcatool.CVLModel x) {
		cvlm = x;
		f = sf;
	}

	public CVLModel() {
		cvlm = new no.sintef.ict.splcatool.CVLModel();
	}

	String getShortFileName(){
		if(f == null) return "unnamed model";
		return f.getName();
	}

	String getLongFileName(){
		if(f == null) return "unnamed model";
		return f.getAbsolutePath();
	}
	
	no.sintef.ict.splcatool.CVLModel getCVLM(){
		return cvlm;
	}

	public void setVSpec(VSpec vSpec) {
		cvlm.getCU().getOwnedVSpec().remove(0);
		cvlm.getCU().getOwnedVSpec().add(vSpec);
	}
}
