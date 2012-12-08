package no.sintef.cvl.engine.rule;

import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.error.BasicCVLEngineException;

public interface RuleContainer {

	public void run(VSpecWTreeNode node) throws BasicCVLEngineException;
	
}
