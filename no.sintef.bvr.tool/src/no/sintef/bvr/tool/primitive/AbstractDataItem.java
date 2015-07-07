/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;

import javax.swing.JLabel;

import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;

import bvr.NamedElement;

public abstract class AbstractDataItem implements DataItem {

	protected NamedElement data;
	protected JLabel label;

	@Override
	public JLabel getLabel(){
		return label;
	}
	
	@Override
	public NamedElement getNamedElement() {
		return data;
	}
	
	public boolean equals(Object object){
		if(object instanceof DataNamedElementItem){
			DataNamedElementItem item = (DataNamedElementItem) object;
			if(getNamedElement().equals(item.getNamedElement())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getNamedElement().hashCode();
	}
}
