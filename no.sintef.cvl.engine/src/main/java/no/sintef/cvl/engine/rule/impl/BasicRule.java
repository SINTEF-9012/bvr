package no.sintef.cvl.engine.rule.impl;

import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.context.Context;
import no.sintef.cvl.engine.rule.Rule;

public abstract class BasicRule implements Rule {

	protected int weight = 0;
	protected Context context;
	
	public void setContext(Context context){
		this.context = context;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public void beforeExecute(VSpecWTreeNode node) {

	}

	public void afterExecute(VSpecWTreeNode node) {

	}
}
