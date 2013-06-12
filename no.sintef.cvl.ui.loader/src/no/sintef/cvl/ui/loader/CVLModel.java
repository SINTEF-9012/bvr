package no.sintef.cvl.ui.loader;

import java.io.File;

import cvl.ConfigurableUnit;
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
	
	public no.sintef.ict.splcatool.CVLModel getCVLM(){
		return cvlm;
	}

	public void addVSpec(VSpec vSpec) {
		cvlm.getCU().getOwnedVSpec().add(vSpec);
	}

	public ConfigurableUnit getCU() {
		return cvlm.getCU();
	}
	
	public void setFile(File f){
		this.f = f;
	}

	public File getFile() {
		return f;
	}
}
