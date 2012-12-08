package no.sintef.cvl.engine.rule;

import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.error.BasicCVLEngineException;

public interface Rule {

	public boolean isApplicable(VSpecWTreeNode node);
	
	public void beforeExecute(VSpecWTreeNode node);
	
	public void execute(VSpecWTreeNode node) throws BasicCVLEngineException;
	
	public void afterExecute(VSpecWTreeNode node);
	
	public int getWeight();
}
