package no.sintef.cvl.ui.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import no.sintef.cvl.ui.primitive.DataItem;

public class FragSubVSpecComboboxModel extends AbstractListModel<DataItem> implements
		ComboBoxModel<DataItem> {

	private static final long serialVersionUID = -4928670717941556052L;
	
	ArrayList<DataItem> data;
	DataItem selectedItem = null;
	
	public FragSubVSpecComboboxModel(ArrayList<DataItem> list){
		data = list;
	}
	
	public FragSubVSpecComboboxModel(){
		data = new ArrayList<DataItem>();
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
		return this.selectedItem;
	}

	@Override
	public void setSelectedItem(Object value) {
		this.selectedItem = (DataItem) value;
	}
	
	public void setData(ArrayList<DataItem> items){
		data = items;
	}
}
