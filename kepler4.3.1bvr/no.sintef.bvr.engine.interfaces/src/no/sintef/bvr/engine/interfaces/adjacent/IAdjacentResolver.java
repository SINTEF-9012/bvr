package no.sintef.bvr.engine.interfaces.adjacent;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;


public interface IAdjacentResolver {

	public void resolve(IFragSubHolder fragmentHolder) throws BasicBVREngineException;
}
