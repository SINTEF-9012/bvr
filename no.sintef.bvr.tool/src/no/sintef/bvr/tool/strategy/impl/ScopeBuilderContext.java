/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
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
