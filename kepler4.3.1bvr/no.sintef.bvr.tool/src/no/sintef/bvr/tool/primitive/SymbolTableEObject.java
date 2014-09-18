package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;


public interface SymbolTableEObject {

	SymbolEObject lookup(EObject element);
	
	public void insert(SymbolEObject symbol);
	
	public void delete(SymbolEObject symbol);
	
	public SymbolEObject lookup(SymbolEObject symbol);
	
	public SymbolTableEObject lookupTable(EObject eObject);
	
	public SymbolTableEObject getParent();
	
	public void setParent(SymbolTableEObject parent);
	
	public HashSet<SymbolTableEObject> getChildren();
	
	public ArrayList<SymbolEObject> getSymbols();
}
