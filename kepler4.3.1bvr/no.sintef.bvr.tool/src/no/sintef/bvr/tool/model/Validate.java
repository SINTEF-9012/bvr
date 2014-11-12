package no.sintef.bvr.tool.model;

import java.util.List;

import bvr.Constraint;
import bvr.VSpecResolution;

public interface Validate {
	
	void validate(BVRToolModel toolModel, VSpecResolution vsr);
	List<String> getConstraintValidationResultMessage(Constraint constraint);
	List<Constraint> getInvalidConstraints();
}
