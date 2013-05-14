package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.DataItem;

import cvl.NamedElement;
import cvl.VSpec;

public class DataVSpecItem implements DataItem{
	
	private JLabel label;
	private VSpec vspec;

	public DataVSpecItem(JLabel label, VSpec vspec){
		this.label = label;
		this.vspec = vspec;
	}
	
	@Override
	public JLabel getLabel(){
		return this.label;
	}
	
	@Override
	public NamedElement getNamedElement() {
		return this.vspec;
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
