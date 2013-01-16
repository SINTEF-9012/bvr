package no.sintef.cvl.engine.adjacent;

import no.sintef.cvl.engine.error.GeneralCVLEngineException;
import no.sintef.cvl.engine.fragment.FragSubHolder;

public interface AdjacentResolver {

	public void resolve(FragSubHolder fragmentHolder) throws GeneralCVLEngineException;
}
