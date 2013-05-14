package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.DataItem;

import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.VariationPoint;

public class DataFragSubItem implements DataItem{

	private VariationPoint varPoint;
	private JLabel label;

	public DataFragSubItem(JLabel label, VariationPoint varPoint){
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
		if(object instanceof DataFragSubItem){
			DataFragSubItem item = (DataFragSubItem) object;
			if(getNamedElement().equals(item.getNamedElement())){
				return true;
			}
		}
		return false;
	}

}
