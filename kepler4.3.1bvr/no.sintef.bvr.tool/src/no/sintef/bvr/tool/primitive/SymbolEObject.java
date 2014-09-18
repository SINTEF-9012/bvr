package no.sintef.bvr.tool.primitive;

import org.eclipse.emf.ecore.EObject;


public interface SymbolEObject extends Symbol {

		public void setSymbol(EObject element);
		
		public EObject getSymbol();
		
		public void setSymbolTable(SymbolTableEObject stable);
		
		public SymbolTableEObject getSymbolTable();
}
