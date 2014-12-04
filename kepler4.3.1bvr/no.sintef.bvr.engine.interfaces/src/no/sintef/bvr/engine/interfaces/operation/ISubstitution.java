package no.sintef.bvr.engine.interfaces.operation;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;

public interface ISubstitution extends IOperation{

	public void execute(boolean replace) throws BasicBVREngineException;
}
