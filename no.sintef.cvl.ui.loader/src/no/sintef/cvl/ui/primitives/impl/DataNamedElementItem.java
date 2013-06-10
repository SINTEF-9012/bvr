package no.sintef.cvl.ui.primitives.impl;

import javax.swing.JLabel;

import no.sintef.cvl.ui.primitives.AbstractDataItem;
import cvl.NamedElement;

public class DataNamedElementItem extends AbstractDataItem{

	public DataNamedElementItem(JLabel label, NamedElement namedElement){
		this.label = label;
		this.data = namedElement;
	}
}
