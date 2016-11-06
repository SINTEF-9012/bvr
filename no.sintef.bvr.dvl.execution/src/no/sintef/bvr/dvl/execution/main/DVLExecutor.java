package no.sintef.bvr.dvl.execution.main;

import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;
import no.sintef.bvr.dvl.execution.interfaces.main.IDVLExecutor;

public class DVLExecutor implements IDVLExecutor {
	
	private String config_path;
	
	public DVLExecutor(String _config_path) {
		config_path = _config_path;
	}

	@Override
	public String[] getOperators(String product) throws PlannerError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deriveProduct(String[] operators) throws RealisationError {
		// TODO Auto-generated method stub

	}

}
