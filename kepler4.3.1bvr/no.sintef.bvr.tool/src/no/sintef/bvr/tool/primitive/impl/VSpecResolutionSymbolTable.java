package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.bvr.tool.primitive.AbstractSymbolTable;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;

import bvr.VSpecResolution;


public class VSpecResolutionSymbolTable extends AbstractSymbolTable {
	
	public VSpecResolutionSymbolTable(VSpecResolution vSpecResolution){
		parent = null;
		tableId = vSpecResolution;
		table = new HashMap<VSpecResolution, SymbolVSpec>();
		children = new HashMap<VSpecResolution, SymbolVSpecResolutionTable>();
	}
}
