package no.sintef.bvr.tool.primitive.impl;

import javax.swing.JLabel;

import bvr.BoundaryElementBinding;
import bvr.NamedElement;
import bvr.VariationPoint;
import no.sintef.bvr.tool.primitive.AbstractDataItem;
import no.sintef.bvr.tool.primitive.DataItem;

public class DataBindingItem extends AbstractDataItem {

	public DataBindingItem(JLabel label, BoundaryElementBinding binding){
		this.label = label;
		this.data = binding;
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
