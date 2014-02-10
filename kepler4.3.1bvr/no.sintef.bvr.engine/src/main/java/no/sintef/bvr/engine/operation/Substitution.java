package no.sintef.bvr.engine.operation;

import no.sintef.bvr.engine.error.BasicBVREngineException;

public interface Substitution extends Operation{

	public void execute(boolean replace) throws BasicBVREngineException;
}
