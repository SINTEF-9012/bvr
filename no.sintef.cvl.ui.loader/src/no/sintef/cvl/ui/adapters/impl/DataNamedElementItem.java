package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.adapters.AbstractDataItem;
import cvl.NamedElement;

public class DataNamedElementItem extends AbstractDataItem{

	public DataNamedElementItem(JLabel label, NamedElement varPoint){
		this.label = label;
		this.data = varPoint;
	}
}
