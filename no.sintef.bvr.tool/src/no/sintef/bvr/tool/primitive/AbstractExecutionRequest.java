/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;

import java.util.HashMap;

import javax.swing.JComponent;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractExecutionRequest implements ExecutionRequest {

	protected VSpecResolution vSpecResolution;
	protected SymbolVSpecResolutionTable table;
	protected BVRModel model;
	protected JComponent parentComponent;
	protected HashMap<String, Object> data;
	
	@Override
	public Object getDataField(String name){
		return data.get(name);
	}
	
	@Override
	public void setDataField(String string, Object object) {
		data.put(string, object);
	}
}
