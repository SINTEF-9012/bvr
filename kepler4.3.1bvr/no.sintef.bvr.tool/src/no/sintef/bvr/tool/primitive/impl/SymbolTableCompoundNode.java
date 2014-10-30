package no.sintef.bvr.tool.primitive.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import bvr.CompoundNode;


public class SymbolTableCompoundNode extends HashSet<SymbolEObject> implements SymbolTableEObject {
	

	private static final long serialVersionUID = -5197571857964725230L;
	private CompoundNode rootNode;
	private HashSet<EObject> list;
	
	private SymbolTableEObject parent;
	private HashSet<SymbolTableEObject> children;
	

	public SymbolTableCompoundNode(CompoundNode root) {
		rootNode = root;
		children = new HashSet<SymbolTableEObject>();
		list = new HashSet<EObject>();
		list.add(rootNode);
	}
	
	@Override
	public SymbolEObject lookup(EObject element) {
		Iterator<SymbolEObject> iter = iterator();
		while(iter.hasNext()){
			SymbolEObject symbol = iter.next();
			if(symbol.equals(element))
				return symbol;
		}
		return null;
	}

	@Override
	public void insert(SymbolEObject symbolNamed) {
		super.add(symbolNamed);
		symbolNamed.setSymbolTable(this);
		list.add(symbolNamed.getSymbol());
	}

	@Override
	public SymbolEObject lookup(SymbolEObject symbol) {
		return (super.contains(symbol)) ? symbol : null;
	}

	@Override
	public SymbolTableEObject lookupTable(EObject eObject) {
		return (list.contains(eObject)) ? this : null;
	}

	@Override
	public void delete(SymbolEObject symbol) {
		list.remove(symbol.getSymbol());
		super.remove(symbol);
	}

	@Override
	public SymbolTableEObject getParent() {
		return parent;
	}
	
	@Override
	public void setParent(SymbolTableEObject parent){
		this.parent = parent;
	}

	@Override
	public HashSet<SymbolTableEObject> getChildren() {
		return children;
	}

	@Override
	public ArrayList<SymbolEObject> getSymbols() {
		return new ArrayList<SymbolEObject>(this);
	}	
}
