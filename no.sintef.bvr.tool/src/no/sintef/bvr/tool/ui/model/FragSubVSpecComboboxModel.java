/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.primitive.impl.DataVSpecItem;

public class FragSubVSpecComboboxModel extends AbstractListModel<DataVSpecItem> implements
		ComboBoxModel<DataVSpecItem> {

	private static final long serialVersionUID = -4928670717941556052L;
	
	public ArrayList<DataVSpecItem> data;
	DataItem selectedItem = null;
	
	public FragSubVSpecComboboxModel(ArrayList<DataVSpecItem> list){
		data = list;
	}
	
	public FragSubVSpecComboboxModel(){
		data = new ArrayList<DataVSpecItem>();
	}

	@Override
	public DataVSpecItem getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object value) {
		selectedItem = (DataItem) value;
	}
}
