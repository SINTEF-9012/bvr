package no.sintef.bvr.tool.ui.loader;

import java.io.File;

import no.sintef.ict.splcatool.SPLCABVRModel;

public class BVRSimpleToolModel extends BVRToolModel {

	public BVRSimpleToolModel(File file, SPLCABVRModel bvrm) {
		super(file, bvrm);
	}

	public BVRSimpleToolModel(File file, String platformPath, boolean platform) {
		super(file, platformPath, platform);
	}

	public BVRSimpleToolModel(File f) {
		super(f);
	}

}
