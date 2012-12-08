package no.sintef.cvl.engine.rule.impl;

import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.rule.Rule;

public class BuildRContainer extends BasicRuleContainer {

	@Override
	public void run(VSpecWTreeNode node) throws BasicCVLEngineException {
		for(Rule rule: this.rules){
			if(rule.isApplicable(node)){
				rule.beforeExecute(node);
				rule.execute(node);
				rule.afterExecute(node);
			}
		}
	}
}
