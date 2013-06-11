package no.sintef.cvl.ui.primitives;

import java.util.ArrayList;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

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
	
	public void setConfigurableUnit(ConfigurableUnit cu);
	
	public ConfigurableUnit getConfigurableUnit();
}
