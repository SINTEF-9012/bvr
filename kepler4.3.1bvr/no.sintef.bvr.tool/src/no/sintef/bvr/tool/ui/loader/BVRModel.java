package no.sintef.bvr.tool.ui.loader;

import java.io.File;

import bvr.ConfigurableUnit;
import bvr.VSpec;

public class CVLModel {
	private no.sintef.ict.splcatool.CVLModel bvrm;
	private File f;
	private boolean platform = false;
	private String loadFilename;
	private boolean saved = true;

	public CVLModel(File sf) {
		f = sf;
		bvrm = new no.sintef.ict.splcatool.CVLModel(f);
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public CVLModel(File sf, no.sintef.ict.splcatool.CVLModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public CVLModel(File sf, String loadLocation, boolean isPlatform){
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		bvrm = new no.sintef.ict.splcatool.CVLModel(loadFilename, platform);
	}

	public CVLModel() {
		bvrm = new no.sintef.ict.splcatool.CVLModel();
	}
	
	public void reload(){
		bvrm = (!platform) ? new no.sintef.ict.splcatool.CVLModel(f) : new no.sintef.ict.splcatool.CVLModel(loadFilename, platform);
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
		return bvrm;
	}
	
	public void setCVLM(no.sintef.ict.splcatool.CVLModel bvrm){
		this.bvrm = bvrm;
	}

	public void addVSpec(VSpec vSpec) {
		bvrm.getCU().getOwnedVSpec().add(vSpec);
	}

	public ConfigurableUnit getCU() {
		return bvrm.getCU();
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
	
	public boolean isNotSaved(){
		return !saved;
	}
	
	public void markNotSaved(){
		saved = false;
	}

	public void markSaved() {
		saved = true;
	}
}
