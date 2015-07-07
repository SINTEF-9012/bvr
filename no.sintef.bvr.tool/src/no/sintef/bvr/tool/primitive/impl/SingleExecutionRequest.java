/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.tool.primitive.AbstractExecutionRequest;

public class SingleExecutionRequest extends AbstractExecutionRequest {
		
	public SingleExecutionRequest(HashMap<String, Object> keywords){
		data = new HashMap<String, Object>();
		for(Map.Entry<String, Object> item : keywords.entrySet()){
			data.put(item.getKey(), item.getValue());
		}
	}
}
