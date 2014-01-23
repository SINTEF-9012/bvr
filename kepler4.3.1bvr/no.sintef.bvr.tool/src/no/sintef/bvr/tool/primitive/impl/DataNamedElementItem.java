package no.sintef.bvr.tool.primitive.impl;

import javax.swing.JLabel;

import no.sintef.bvr.tool.primitive.AbstractDataItem;
import bvr.NamedElement;

public class DataNamedElementItem extends AbstractDataItem{

	public DataNamedElementItem(JLabel label, NamedElement namedElement){
		this.label = label;
		this.data = namedElement;
	}
}
