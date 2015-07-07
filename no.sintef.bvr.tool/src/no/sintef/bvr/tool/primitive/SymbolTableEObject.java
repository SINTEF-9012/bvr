/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;


public interface SymbolTableEObject {

	SymbolEObject lookup(EObject element);
	
	public void insert(SymbolEObject symbol);
	
	public void delete(SymbolEObject symbol);
	
	public SymbolEObject lookup(SymbolEObject symbol);
	
	public SymbolTableEObject lookupTable(EObject eObject);
	
	public SymbolTableEObject getParent();
	
	public void setParent(SymbolTableEObject parent);
	
	public HashSet<SymbolTableEObject> getChildren();
	
	public ArrayList<SymbolEObject> getSymbols();
}
