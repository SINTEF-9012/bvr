package no.sintef.cvl.ui.primitive.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.primitive.AbstractDataItem;
import cvl.NamedElement;

public class DataNamedElementItem extends AbstractDataItem{

	public DataNamedElementItem(JLabel label, NamedElement namedElement){
		this.label = label;
		this.data = namedElement;
	}
}
