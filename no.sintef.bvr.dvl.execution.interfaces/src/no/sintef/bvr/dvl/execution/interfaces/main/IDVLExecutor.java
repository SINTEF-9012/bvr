package no.sintef.bvr.dvl.execution.interfaces.main;

import java.util.List;

import no.sintef.bvr.dvl.execution.interfaces.errors.ConfigError;
import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;
import no.sintef.dvl.realisation.core.interfaces.errors.OperatorNotLocatedException;

import org.eclipse.core.resources.IFile;

public interface IDVLExecutor {

	public List<String> getOperators(IFile realisation) throws PlannerError, ConfigError;

	public void deriveProduct(String product_name, List<String> operators) throws RealisationError, ConfigError, OperatorNotLocatedException;
}
