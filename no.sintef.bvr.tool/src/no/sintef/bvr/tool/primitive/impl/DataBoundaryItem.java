/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive.impl;

import javax.swing.JLabel;

import bvr.NamedElement;
import bvr.VariationPoint;
import no.sintef.bvr.tool.primitive.AbstractDataItem;

public class DataBoundaryItem extends AbstractDataItem {
	
	public DataBoundaryItem(JLabel label, NamedElement boundaryElement){
		this.label = label;
		this.data = boundaryElement;
	}
	
	public boolean equals(Object object){
		if(object instanceof DataBoundaryItem){
			DataBoundaryItem item = (DataBoundaryItem) object;
			if(getNamedElement().equals(item.getNamedElement())){
				return true;
			}
		}
		return false;
	}
}
