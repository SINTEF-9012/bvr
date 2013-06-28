package no.sintef.cvl.ui.primitive.impl;

import java.util.HashMap;

import no.sintef.cvl.ui.primitive.AbstractSymbolTable;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.cvl.ui.primitive.SymbolTable;

import cvl.VSpecResolution;


public class VSpecResolutionSymbolTable extends AbstractSymbolTable {
	
	public VSpecResolutionSymbolTable(VSpecResolution vSpecResolution){
		parent = null;
		tableId = vSpecResolution;
		table = new HashMap<VSpecResolution, Symbol>();
		children = new HashMap<VSpecResolution, SymbolTable>();
	}
}
