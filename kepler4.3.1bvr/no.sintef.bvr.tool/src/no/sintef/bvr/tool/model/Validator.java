package no.sintef.bvr.tool.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import bvr.Constraint;
import bvr.VSpecResolution;

public class Validator implements Validate {
	 
	private List<Constraint> invalidConstraints;
	private HashMap<Constraint, List<String>> results;
	
	public Validator() {
		invalidConstraints = new ArrayList<Constraint>();
		results = new HashMap<Constraint, List<String>>();
	}

	@Override
	public void validate(BVRToolModel toolModel, VSpecResolution vsr) {
		throw new UnimplementedBVRException("not implemented yet");
	}

	@Override
	public List<String> getConstraintValidationResultMessage(Constraint constraint) {
		return results.get(constraint);
	}

	@Override
	public List<Constraint> getInvalidConstraints() {
		return invalidConstraints;
	}

}
