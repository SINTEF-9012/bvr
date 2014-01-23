package no.sintef.bvr.engine.operation;

import no.sintef.bvr.engine.error.BasicCVLEngineException;

public interface Substitution extends Operation{

	public void execute(boolean replace) throws BasicCVLEngineException;
}
