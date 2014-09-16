package no.sintef.bvr.tool.primitive.impl;

import java.util.HashSet;

import bvr.NamedElement;
import bvr.Target;
import no.sintef.bvr.tool.primitive.SymbolNamedElement;
import no.sintef.bvr.tool.primitive.SymbolTableNamedElement;

public class SymbolTarget implements SymbolNamedElement {

	private Target target;
	private SymbolTableNamedElement table;
	private HashSet<SymbolNamedElement> refVSpecs;
	
	public SymbolTarget(Target trg) {
		target = trg;
		refVSpecs = new HashSet<SymbolNamedElement>();
	}
	
	@Override
	public void setSymbol(NamedElement element) {
		target = (Target) element;

	}

	@Override
	public NamedElement getSymbol() {
		return target;
	}

	@Override
	public void setSymbolTable(SymbolTableNamedElement stable) {
		table = stable;
	}

	@Override
	public SymbolTableNamedElement getSymbolTable() {
		return table;
	}
	
	public void addReferencedSymbols(SymbolNamedElement SymbolNamedElement) {
		refVSpecs.add(SymbolNamedElement);
	}
	
	public HashSet<SymbolNamedElement> getReferencedSymbols() {
		return refVSpecs;
	}

}
