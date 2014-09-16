package no.sintef.bvr.tool.primitive;

import bvr.NamedElement;


public interface SymbolTableNamedElement {

	SymbolNamedElement lookup(NamedElement element);
	
	public SymbolTableNamedElement lookupTable(NamedElement element);
	
	public void insert(SymbolNamedElement symbolNamed);
	
	public void delete(SymbolNamedElement symbolNamed);
}
