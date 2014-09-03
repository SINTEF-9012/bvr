package no.sintef.bvr.tool.ui.loader;

import java.io.File;

import bvr.ConfigurableUnit;

public class BVREmptyModel extends BVRModel {

		
	public BVREmptyModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel();
		loadFilename = sf.getAbsolutePath();
		saved = false;
	}

	@Override
	public no.sintef.ict.splcatool.SPLCABVRModel getBVRM() {
		return bvrm;
	}

	@Override
	public ConfigurableUnit getCU() {
		return bvrm.getCU();
	}
	
	public void setCU(ConfigurableUnit cu){
		((BVRInnerModel) bvrm).setCU(cu);
	}

	@Override
	public File getFile() {
		return f;
	}
	
	private class BVRInnerModel extends no.sintef.ict.splcatool.SPLCABVRModel {
		
		public void setCU(ConfigurableUnit _cu){
			cu =_cu;
		}

	}
}
