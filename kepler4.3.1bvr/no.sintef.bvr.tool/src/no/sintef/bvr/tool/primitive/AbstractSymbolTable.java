package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashMap;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractSymbolTable implements SymbolTable {
	
	protected VSpecResolution tableId;
	protected HashMap<VSpecResolution, Symbol> table;
	protected SymbolTable parent;
	protected HashMap<VSpecResolution, SymbolTable> children;
	protected BVRModel bvrModel;

	@Override
	public Symbol lookup(VSpecResolution vSpecResolution) {
		return table.get(vSpecResolution);
	}
	
	@Override
	public SymbolTable lookupTable(VSpecResolution vSpecResolution) {
		return children.get(vSpecResolution);
	}

	@Override
	public void insert(Symbol vSpecResolutionSymbol) {
		table.put(vSpecResolutionSymbol.getVSpecResolution(), vSpecResolutionSymbol);
	}

	@Override
	public void delete(Symbol vSpecResolutionSymbol) {
		table.remove(vSpecResolutionSymbol.getVSpecResolution());
	}

	@Override
	public void setParent(SymbolTable table) {
		parent = table;
	}
	
	@Override
	public void setChild(SymbolTable table) {
		children.put(table.getTableId(), table);
	}
	
	@Override
	public VSpecResolution getTableId() {
		return tableId;
	}
	
	@Override
	public ArrayList<SymbolTable> getChildren() {
		return new ArrayList<SymbolTable>(children.values());
	}
	
	@Override
	public SymbolTable getParent() {
		return parent;
	}
	
	@Override
	public ArrayList<Symbol> getSymbols() {
		return new ArrayList<Symbol>(table.values());
	}
	
	@Override
	public void setBVRModel(BVRModel bvrModel) {
		this.bvrModel = bvrModel;
	}
	
	@Override
	public BVRModel getBVRModel() {
		return this.bvrModel;
	}
}
