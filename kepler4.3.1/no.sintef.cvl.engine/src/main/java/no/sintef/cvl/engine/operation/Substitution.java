package no.sintef.cvl.engine.operation;

import no.sintef.cvl.engine.error.BasicCVLEngineException;

public interface Substitution extends Operation{

	public void execute(boolean replace) throws BasicCVLEngineException;
}
