/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import bvr.BVRModel;
import bvr.PosResolution;

public interface TableBuilderStrategy {

	public SymbolVSpecResolutionTable buildSymbolTable(BVRModel bvrModel, PosResolution posResolution);
}
