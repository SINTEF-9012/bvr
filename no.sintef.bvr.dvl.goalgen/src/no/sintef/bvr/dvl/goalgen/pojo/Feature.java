package no.sintef.bvr.dvl.goalgen.pojo;

import no.sintef.bvr.dvl.goalgen.interfaces.pojo.IFeature;

public class Feature implements IFeature {
	
	private boolean is_positive;
	private String name;

	public Feature(String _name, boolean _is_positive) {
		is_positive = _is_positive;
		name = _name;
	}

	public boolean isPositive() {
		return is_positive;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String to_print = (is_positive) ? name + ": +" : name + ": -";
		return to_print + "\n";
	}
}
