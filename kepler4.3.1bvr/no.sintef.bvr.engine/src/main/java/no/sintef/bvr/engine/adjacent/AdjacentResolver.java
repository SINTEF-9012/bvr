package no.sintef.bvr.engine.adjacent;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.fragment.FragSubHolder;

public interface AdjacentResolver {

	public void resolve(FragSubHolder fragmentHolder) throws BasicBVREngineException;
}
