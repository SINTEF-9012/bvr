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
