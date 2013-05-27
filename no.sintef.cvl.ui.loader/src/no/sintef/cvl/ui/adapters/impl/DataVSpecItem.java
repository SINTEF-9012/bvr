package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.AbstractDataItem;
import cvl.VSpec;

public class DataVSpecItem extends AbstractDataItem{
	
	public DataVSpecItem(JLabel label, VSpec vspec){
		this.label = label;
		this.data = vspec;
	}
}
