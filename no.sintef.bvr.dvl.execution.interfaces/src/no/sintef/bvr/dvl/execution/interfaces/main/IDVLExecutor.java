package no.sintef.bvr.dvl.execution.interfaces.main;

import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;

public interface IDVLExecutor {

	public String[] getOperators(String product) throws PlannerError;
	
	public void deriveProduct(String[] operators) throws RealisationError;
}
