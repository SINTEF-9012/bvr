/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive.impl;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.VisitableSymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.visitor.NodeVisitor;
import bvr.CompoundNode;
import bvr.NamedElement;

public class SymbolCompoundNode extends VisitableSymbolEObject {

	CompoundNode node;
	SymbolTableCompoundNode table;
	
	public SymbolCompoundNode(CompoundNode element) {
		node = element;
	}

	@Override
	public NamedElement getSymbol() {
		return (NamedElement) node;
	}

	@Override
	public void setSymbolTable(SymbolTableEObject stable) {
		table = (SymbolTableCompoundNode) stable;
	}

	@Override
	public SymbolTableEObject getSymbolTable() {
		return table;
	}

	@Override
	public void setSymbol(EObject element) {
		node = (CompoundNode) element;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visitNamedElement(this);
	}

}
