package no.sintef.bvr.tool.strategy.impl;

import java.util.HashMap;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VType;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import no.sintef.bvr.tool.primitive.SymbolNamedElement;
import no.sintef.bvr.tool.primitive.SymbolTableNamedElement;
import no.sintef.bvr.tool.primitive.impl.SymbolCompoundNode;
import no.sintef.bvr.tool.primitive.impl.SymbolTableCompoundNode;
import no.sintef.bvr.tool.strategy.VSpecContextBuilderStrategy;

public class VSpecContextBuilderStrategyImpl implements VSpecContextBuilderStrategy {

	private SymbolTableNamedElement globalScope;
	private HashMap<NamedElement, SymbolTableNamedElement> map;
	
	
	@Override
	public void testVSpec(NamedElement parent, CompoundNode child) {
		if((parent.eContainer() instanceof BVRModel) && (globalScope == null) && (parent instanceof CompoundNode)){
			globalScope = new SymbolTableCompoundNode((CompoundNode) parent);
			SymbolCompoundNode symbol = new SymbolCompoundNode((CompoundNode) parent);
			((SymbolTableCompoundNode) globalScope).insert(symbol);
			map.put(parent, globalScope);
		}
		if(globalScope == null)
			return;
		if(!(child instanceof VType)){
			SymbolTableCompoundNode table = new SymbolTableCompoundNode(child);
			table.insert(new SymbolCompoundNode(child));
			map.put((NamedElement) child, table);
		}else {
			SymbolTableNamedElement table = map.get(parent);
			if(table == null)
				throw new UnexpectedException("parent element is not added to any symbol table");
			((SymbolTableCompoundNode) table).insert(new SymbolCompoundNode((CompoundNode) child));
			map.put((NamedElement) child, table);
		}
	}

	@Override
	public void reset() {
		globalScope = null;
		map = new HashMap<NamedElement, SymbolTableNamedElement>();
	}
	
	

}
