package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;

import bvr.BVRModel;
import bvr.VSpecResolution;

public interface SymbolTable {
	
	public Symbol lookup(VSpecResolution vSpecResolution);
	
	public SymbolTable lookupTable(VSpecResolution vSpecResolution);
	
	public void insert(Symbol vSpecResolutionSymbol);
	
	public void delete(Symbol vSpecResolutionSymbol);
	
	public void setParent(SymbolTable table);
	
	public SymbolTable getParent();
	
	public void setChild(SymbolTable table);
	
	public ArrayList<SymbolTable> getChildren();
	
	public VSpecResolution getTableId();
	
	public ArrayList<Symbol> getSymbols();
	
	void setBVRModel(BVRModel bvrModel);

	BVRModel getBVRModel();
}
