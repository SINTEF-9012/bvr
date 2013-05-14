package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.DataItem;

import cvl.FragmentSubstitution;
import cvl.NamedElement;

public class DataFragSubItem implements DataItem{

	private FragmentSubstitution fragSub;
	private JLabel label;

	public DataFragSubItem(JLabel label, FragmentSubstitution fragSub){
		this.label = label;
		this.fragSub = fragSub;
	}
	
	@Override
	public JLabel getLabel(){
		return this.label;
	}
	
	@Override
	public NamedElement getNamedElement() {
		return this.fragSub;
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
