package no.sintef.bvr.tool.primitive.impl;

import no.sintef.bvr.tool.primitive.SymbolNamedElement;
import no.sintef.bvr.tool.primitive.SymbolTableNamedElement;
import bvr.CompoundNode;
import bvr.NamedElement;

public class SymbolCompoundNode implements SymbolNamedElement {

	CompoundNode node;
	SymbolTableCompoundNode table;
	
	public SymbolCompoundNode(CompoundNode element) {
		node = element;
	}
	
	@Override
	public void setSymbol(NamedElement element) {
		node = (CompoundNode) element;
	}

	@Override
	public NamedElement getSymbol() {
		return (NamedElement) node;
	}

	@Override
	public void setSymbolTable(SymbolTableNamedElement stable) {
		table = (SymbolTableCompoundNode) stable;
	}

	@Override
	public SymbolTableNamedElement getSymbolTable() {
		return table;
	}

}
