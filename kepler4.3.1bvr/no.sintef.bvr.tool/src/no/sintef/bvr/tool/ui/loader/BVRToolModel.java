package no.sintef.bvr.tool.ui.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.VSpec;
import bvr.VSpecResolution;

public class BVRToolModel {
	protected no.sintef.ict.splcatool.SPLCABVRModel bvrm;
	protected File f;
	protected boolean platform = false;
	protected String loadFilename;
	protected boolean saved = true;
	protected List<VSpec> minimizedVSpec;
	protected List<VSpecResolution> minimizedVSpecResolution;

	public BVRToolModel(File sf) {
		f = sf;
		bvrm = new no.sintef.ict.splcatool.SPLCABVRModel(f);
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public BVRToolModel(File sf, no.sintef.ict.splcatool.SPLCABVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath(); 
	}
	
	public BVRToolModel(File sf, String loadLocation, boolean isPlatform){
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		bvrm = new no.sintef.ict.splcatool.SPLCABVRModel(loadFilename, platform);
	}

	public BVRToolModel() {
		bvrm = new no.sintef.ict.splcatool.SPLCABVRModel();
	}
	
	public void reload(){
		bvrm = (!platform) ? new no.sintef.ict.splcatool.SPLCABVRModel(f) : new no.sintef.ict.splcatool.SPLCABVRModel(loadFilename, platform);
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
	
	public no.sintef.ict.splcatool.SPLCABVRModel getBVRM(){
		return bvrm;
	}
	
	public void setBVRM(no.sintef.ict.splcatool.SPLCABVRModel bvrm){
		this.bvrm = bvrm;
	}

	public void addVSpec(VSpec vSpec) {
		bvrm.getRootBVRModel().setVariabilityModel((CompoundNode) vSpec);
	}

	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
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
	
	public void addChoice(VSpec parentVSpec) {
		throw new UnexpectedException("Are you using default implementation?!");
	};
	
	public void minimaizeVSpec(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void maximizeVSpec(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public boolean isVSpecMinimized(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void minimaizeVSpecResolution(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void maximizeVSpecResolution(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
}
