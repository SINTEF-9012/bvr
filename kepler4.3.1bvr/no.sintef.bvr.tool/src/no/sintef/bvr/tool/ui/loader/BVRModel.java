package no.sintef.bvr.tool.ui.loader;

import java.io.File;

import bvr.ConfigurableUnit;
import bvr.VSpec;

public class BVRModel {
	protected no.sintef.ict.splcatool.BVRModel bvrm;
	protected File f;
	protected boolean platform = false;
	protected String loadFilename;
	protected boolean saved = true;

	public BVRModel(File sf) {
		f = sf;
		bvrm = new no.sintef.ict.splcatool.BVRModel(f);
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public BVRModel(File sf, no.sintef.ict.splcatool.BVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public BVRModel(File sf, String loadLocation, boolean isPlatform){
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		bvrm = new no.sintef.ict.splcatool.BVRModel(loadFilename, platform);
	}

	public BVRModel() {
		bvrm = new no.sintef.ict.splcatool.BVRModel();
	}
	
	public void reload(){
		bvrm = (!platform) ? new no.sintef.ict.splcatool.BVRModel(f) : new no.sintef.ict.splcatool.BVRModel(loadFilename, platform);
	}
	
	public void dispose() {
		f = null;
		bvrm = null;
		saved = false;
		loadFilename = "";
		platform = false;
	}

	String getShortFileName(){
		if(f == null) return "unnamed model";
		return f.getName();
	}

	String getLongFileName(){
		if(f == null) return "unnamed model";
		return f.getAbsolutePath();
	}
	
	public no.sintef.ict.splcatool.BVRModel getBVRM(){
		return bvrm;
	}
	
	public void setBVRM(no.sintef.ict.splcatool.BVRModel bvrm){
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
