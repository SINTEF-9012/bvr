package no.sintef.bvr.tool.primitive.impl;

import javax.swing.JLabel;

import no.sintef.bvr.tool.primitive.AbstractDataItem;
import bvr.VSpec;

public class DataVSpecItem extends AbstractDataItem{
	
	public DataVSpecItem(JLabel label, VSpec vspec){
		this.label = label;
		this.data = vspec;
	}
	
	public boolean equals(Object object){
		if(object instanceof DataVSpecItem){
			DataVSpecItem item = (DataVSpecItem) object;
			if(getNamedElement().equals(item.getNamedElement())){
				return true;
			}
		}
		return false;
	}
}
