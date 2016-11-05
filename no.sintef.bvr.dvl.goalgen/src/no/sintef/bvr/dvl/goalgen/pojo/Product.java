package no.sintef.bvr.dvl.goalgen.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IFeature;
import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IProduct;

public class Product implements IProduct {

	private String name;
	private List<IFeature> features;

	public Product(String _name) {
		name = _name;
		features = new ArrayList<IFeature>();
	}
	
	@Override
	public void addFeature(IFeature feature) {
		features.add(feature);
	}
	
	public List<IFeature> getFeatures() {
		return features;
	}
	
	public String getName() {
		return name;
	}
	

	@Override
	public String toString() {
		String str = new String();
		for(IFeature f : features)
			str+= f.toString();
		return str;
	}
}
