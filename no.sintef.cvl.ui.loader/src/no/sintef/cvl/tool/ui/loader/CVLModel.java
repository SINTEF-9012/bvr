package no.sintef.cvl.tool.ui.loader;

import java.io.File;

import cvl.ConfigurableUnit;
import cvl.VSpec;

public class CVLModel {
	private no.sintef.ict.splcatool.CVLModel cvlm;
	private File f;
	private boolean platform = false;
	private String loadFilename;

	public CVLModel(File sf) {
		f = sf;
		cvlm = new no.sintef.ict.splcatool.CVLModel(f);
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public CVLModel(File sf, no.sintef.ict.splcatool.CVLModel x) {
		cvlm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public CVLModel(File sf, String loadLocation, boolean isPlatform){
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		cvlm = new no.sintef.ict.splcatool.CVLModel(loadFilename, platform);
	}

	public CVLModel() {
		cvlm = new no.sintef.ict.splcatool.CVLModel();
	}
	
	public void reload(){
		cvlm = (!platform) ? new no.sintef.ict.splcatool.CVLModel(f) : new no.sintef.ict.splcatool.CVLModel(loadFilename, platform);
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
	
	public void setCVLM(no.sintef.ict.splcatool.CVLModel cvlm){
		this.cvlm = cvlm;
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
	
	public void setPlatform(boolean isPlatform){
		platform = isPlatform;
	}
	
	public void setLoadFilename(String loadName){		
		loadFilename = loadName;
	}
}
