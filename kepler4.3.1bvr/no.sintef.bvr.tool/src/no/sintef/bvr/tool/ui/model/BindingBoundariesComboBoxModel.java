package no.sintef.bvr.tool.ui.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import no.sintef.bvr.tool.primitive.DataItem;

public class BindingBoundariesComboBoxModel extends AbstractListModel<DataItem>
		implements ComboBoxModel<DataItem> {

	private static final long serialVersionUID = 5126299116838742212L;
	
	private ArrayList<DataItem> data;
	private DataItem seletedItem = null;

	public BindingBoundariesComboBoxModel(ArrayList<DataItem> boundariesList){
		data = boundariesList;
	}
	
	@Override
	public DataItem getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public Object getSelectedItem() {
		return seletedItem;
	}

	@Override
	public void setSelectedItem(Object value) {
		seletedItem = (DataItem) value;
	}
}
