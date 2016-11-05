package no.sintef.bvr.dvl.goalgen.interfaces.main;

import java.io.IOException;
import java.util.List;


import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IProduct;
import bvr.BVRModel;

public interface IGoalGenerator {

	
	public void generate();
	
	public List<IProduct> getProducts(BVRModel model);
	
	public void writeProducts(List<IProduct> products) throws IOException;
}
