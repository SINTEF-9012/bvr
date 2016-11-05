package no.sintef.bvr.dvl.goalgen.interfaces.pojo;

import java.util.List;


public interface IProduct {

	public void addFeature(IFeature feature);
	
	public String getName();
	
	public List<IFeature> getFeatures();
}
