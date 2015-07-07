/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashMap;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractSymbolTable implements SymbolVSpecResolutionTable {
	
	protected VSpecResolution tableId;
	protected HashMap<VSpecResolution, SymbolVSpec> table;
	protected SymbolVSpecResolutionTable parent;
	protected HashMap<VSpecResolution, SymbolVSpecResolutionTable> children;
	protected BVRModel bvrModel;

	@Override
	public SymbolVSpec lookup(VSpecResolution vSpecResolution) {
		return table.get(vSpecResolution);
	}
	
	@Override
	public SymbolVSpecResolutionTable lookupTable(VSpecResolution vSpecResolution) {
		return children.get(vSpecResolution);
	}

	@Override
	public void insert(SymbolVSpec vSpecResolutionSymbol) {
		table.put(vSpecResolutionSymbol.getVSpecResolution(), vSpecResolutionSymbol);
	}

	@Override
	public void delete(SymbolVSpec vSpecResolutionSymbol) {
		table.remove(vSpecResolutionSymbol.getVSpecResolution());
	}

	@Override
	public void setParent(SymbolVSpecResolutionTable table) {
		parent = table;
	}
	
	@Override
	public void setChild(SymbolVSpecResolutionTable table) {
		children.put(table.getTableId(), table);
	}
	
	@Override
	public VSpecResolution getTableId() {
		return tableId;
	}
	
	@Override
	public ArrayList<SymbolVSpecResolutionTable> getChildren() {
		return new ArrayList<SymbolVSpecResolutionTable>(children.values());
	}
	
	@Override
	public SymbolVSpecResolutionTable getParent() {
		return parent;
	}
	
	@Override
	public ArrayList<SymbolVSpec> getSymbols() {
		return new ArrayList<SymbolVSpec>(table.values());
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
