package no.sintef.cvl.tool.primitive.impl;

import javax.swing.JLabel;

import no.sintef.cvl.tool.primitive.AbstractDataItem;
import cvl.NamedElement;

public class DataNamedElementItem extends AbstractDataItem{

	public DataNamedElementItem(JLabel label, NamedElement namedElement){
		this.label = label;
		this.data = namedElement;
	}
}
