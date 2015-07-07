/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.checker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.primitive.VisitableSymbolEObject;
import no.sintef.bvr.tool.strategy.impl.ScopeBuilderContext;
import no.sintef.bvr.tool.visitor.NodeVisitor;
import no.sintef.bvr.tool.visitor.PropertyCheckNodeVisitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;



public final class ModelChecker {
	
	public static ModelChecker eINSTANCE = getInstance();
	
	private static ModelChecker getInstance() {
		return (eINSTANCE != null) ? eINSTANCE : new ModelChecker();
	}

	private ScopeBuilderContext buildScopes;
	private SymbolTableEObject globalScope;
	private ArrayList<SymbolEObject> symbols;
	
	private HashSet<NodeVisitor> checkVisitors = new HashSet<NodeVisitor>(Arrays.asList(
			new PropertyCheckNodeVisitor()));
	
	public synchronized void execute(BVRModel model){
		symbols = new ArrayList<SymbolEObject>();
		buildScopes = new ScopeBuilderContext();
		buildScopes.init();
		traverse(model);
		globalScope = buildScopes.getRootScope();
		if(globalScope == null) {
			Context.eINSTANCE.problemLogger.warn("scope is not build, model is not checked");
			return;
		}
		collectSymbols(globalScope);
		for(NodeVisitor visitor : checkVisitors){
			for(SymbolEObject symbol : symbols){
				if(symbol instanceof VisitableSymbolEObject)
					((VisitableSymbolEObject) symbol).accept(visitor);
			}
		}
		
		
	}
	
	private void traverse(EObject root){
		EList<EObject> children = root.eContents();
		for(EObject child : children){
			traverse(root, child);
		}
		
	}
	
	private void traverse(EObject parent, EObject child){
		buildScopes.testEObject(parent, child);
		EList<EObject> children = child.eContents();
		for(EObject nextChild : children){
			traverse(child, nextChild);
		}
	}
	
	private void collectSymbols(SymbolTableEObject table){
		symbols.addAll(table.getSymbols());
		for(SymbolTableEObject t : table.getChildren()){
			collectSymbols(t);
		}
	}

}
