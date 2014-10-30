package no.sintef.bvr.tool.strategy.impl;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.strategy.ContextBuilderStrategy;


public class ScopeBuilderContext {
	
	private ContextBuilderStrategy strategy;
	
	public ScopeBuilderContext(){
		strategy = new CompoundNodeScopeBuilderStrategy();
	}
	
	public ScopeBuilderContext(ContextBuilderStrategy builderStrategy){
		strategy = builderStrategy;
	}
	
	public void testEObject(EObject parent, EObject child){
		strategy.testEObject(parent, child);
	}
	
	public void init(){
		strategy.reset();
	}
	
	public SymbolTableEObject getRootScope(){
		return strategy.getRootScope();
	}
}
