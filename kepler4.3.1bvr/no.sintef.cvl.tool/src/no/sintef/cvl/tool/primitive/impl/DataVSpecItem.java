package no.sintef.cvl.tool.primitive.impl;

import javax.swing.JLabel;

import no.sintef.cvl.tool.primitive.AbstractDataItem;
import cvl.VSpec;

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
