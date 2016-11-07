package no.sintef.bvr.dvl.execution.interfaces.main;

import java.util.List;





import org.eclipse.core.resources.IFile;

import no.sintef.bvr.dvl.execution.interfaces.errors.ConfigError;
import no.sintef.bvr.dvl.execution.interfaces.errors.PlannerError;
import no.sintef.bvr.dvl.execution.interfaces.errors.RealisationError;

public interface IDVLExecutor {

	public List<String> getOperators(IFile realisation) throws PlannerError, ConfigError;
	
	public void deriveProduct(String product_name, List<String> operators) throws RealisationError, ConfigError;
}
