package no.sintef.cvl.ui.primitives.impl;

import javax.swing.JLabel;

import cvl.BoundaryElementBinding;
import cvl.NamedElement;
import cvl.VariationPoint;
import no.sintef.cvl.ui.primitives.AbstractDataItem;
import no.sintef.cvl.ui.primitives.DataItem;

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
