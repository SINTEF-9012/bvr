package no.sintef.cvl.tool.primitive.impl;

import javax.swing.JLabel;

import cvl.NamedElement;
import cvl.VariationPoint;
import no.sintef.cvl.tool.primitive.AbstractDataItem;

public class DataBoundaryItem extends AbstractDataItem {
	
	public DataBoundaryItem(JLabel label, VariationPoint boundaryElement){
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
