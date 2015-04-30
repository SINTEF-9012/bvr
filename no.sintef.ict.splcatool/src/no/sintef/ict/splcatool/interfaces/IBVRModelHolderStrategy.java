package no.sintef.ict.splcatool.interfaces;

import bvr.BVRModel;

public interface IBVRModelHolderStrategy {

	public BVRModel getBVRModel();
	
	public void setBVRModel(BVRModel model);
}
