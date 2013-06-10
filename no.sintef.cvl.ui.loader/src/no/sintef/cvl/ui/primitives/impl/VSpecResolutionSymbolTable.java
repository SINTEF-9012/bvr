package no.sintef.cvl.ui.primitives.impl;

import java.util.HashMap;

import no.sintef.cvl.ui.primitives.AbstractSymbolTable;
import no.sintef.cvl.ui.primitives.Symbol;
import no.sintef.cvl.ui.primitives.SymbolTable;

import cvl.VSpecResolution;


public class VSpecResolutionSymbolTable extends AbstractSymbolTable {
	
	public VSpecResolutionSymbolTable(VSpecResolution vSpecResolution){
		parent = null;
		tableId = vSpecResolution;
		table = new HashMap<VSpecResolution, Symbol>();
		children = new HashMap<VSpecResolution, SymbolTable>();
	}
}
