package no.sintef.bvr.tool.primitive;

import bvr.NamedElement;

public interface SymbolNamedElement {

		public void setSymbol(NamedElement element);
		
		public NamedElement getSymbol();
		
		public void setSymbolTable(SymbolTableNamedElement stable);
		
		public SymbolTableNamedElement getSymbolTable();
}
