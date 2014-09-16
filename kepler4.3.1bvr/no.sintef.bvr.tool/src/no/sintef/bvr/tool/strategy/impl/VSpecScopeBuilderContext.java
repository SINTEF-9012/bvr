package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.strategy.VSpecContextBuilderStrategy;
import bvr.CompoundNode;
import bvr.NamedElement;

public class VSpecScopeBuilderContext {
	
	private VSpecContextBuilderStrategy strategy;
	
	public VSpecScopeBuilderContext(){
		strategy = new VSpecContextBuilderStrategyImpl();
	}
	
	public void testVSpec(NamedElement parent, CompoundNode child){
		strategy.testVSpec(parent, child);
	}
	
	public void init(){
		strategy.reset();
	}
}
