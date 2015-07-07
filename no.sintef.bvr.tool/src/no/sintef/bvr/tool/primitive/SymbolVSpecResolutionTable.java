/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;

import bvr.BVRModel;
import bvr.VSpecResolution;

public interface SymbolVSpecResolutionTable {
	
	public SymbolVSpec lookup(VSpecResolution vSpecResolution);
	
	public SymbolVSpecResolutionTable lookupTable(VSpecResolution vSpecResolution);
	
	public void insert(SymbolVSpec vSpecResolutionSymbol);
	
	public void delete(SymbolVSpec vSpecResolutionSymbol);
	
	public void setParent(SymbolVSpecResolutionTable table);
	
	public SymbolVSpecResolutionTable getParent();
	
	public void setChild(SymbolVSpecResolutionTable table);
	
	public ArrayList<SymbolVSpecResolutionTable> getChildren();
	
	public VSpecResolution getTableId();
	
	public ArrayList<SymbolVSpec> getSymbols();
	
	void setBVRModel(BVRModel bvrModel);

	BVRModel getBVRModel();
}
