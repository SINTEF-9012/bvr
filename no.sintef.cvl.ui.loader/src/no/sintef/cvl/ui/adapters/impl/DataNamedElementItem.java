package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.DataItem;

import cvl.NamedElement;
import cvl.VariationPoint;

public class DataNamedElementItem implements DataItem{

	private NamedElement varPoint;
	private JLabel label;

	public DataNamedElementItem(JLabel label, NamedElement varPoint){
		this.label = label;
		this.varPoint = varPoint;
	}
	
	@Override
	public JLabel getLabel(){
		return this.label;
	}
	
	@Override
	public NamedElement getNamedElement() {
		return this.varPoint;
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

}
