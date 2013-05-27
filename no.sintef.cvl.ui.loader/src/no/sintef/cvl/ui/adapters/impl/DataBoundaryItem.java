package no.sintef.cvl.ui.adapters.impl;

import javax.swing.JLabel;

import cvl.VariationPoint;
import no.sintef.cvl.ui.adapters.AbstractDataItem;

public class DataBoundaryItem extends AbstractDataItem {

	public DataBoundaryItem(JLabel label, VariationPoint boundaryElement){
		this.label = label;
		this.data = boundaryElement;
	}
}
