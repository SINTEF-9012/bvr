package no.sintef.bvr.tool.model;

import java.io.File;

import bvr.BVRModel;


public class BVREmptyModel extends BVRToolModel {

		
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
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}
	
	public void setBVRModel(BVRModel bvrModel){
		((BVRInnerModel) bvrm).setBVRModel(bvrModel);
	}

	@Override
	public File getFile() {
		return f;
	}
	
	private class BVRInnerModel extends no.sintef.ict.splcatool.SPLCABVRModel {
		
		public void setBVRModel(BVRModel _model){
			model =_model;
		}

	}
}
