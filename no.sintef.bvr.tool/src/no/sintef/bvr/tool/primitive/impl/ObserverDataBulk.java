/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.bvr.tool.primitive.Keywords;

public class ObserverDataBulk implements Keywords {

	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	@Override
	public Object getDataField(String name) {
		return data.get(name);
	}

	@Override
	public void setDataField(String name, Object object) {
		data.put(name, object);
	}
	
	public boolean isFieldSet(String name){
		if(data.keySet().contains(name))
			return true;
		return false;
	}

}
