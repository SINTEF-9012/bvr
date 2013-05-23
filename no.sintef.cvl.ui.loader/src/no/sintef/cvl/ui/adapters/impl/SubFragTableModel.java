package no.sintef.cvl.ui.adapters.impl;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import no.sintef.cvl.ui.common.Constants;

import cvl.NamedElement;
import cvl.ReplacementFragmentType;

public class SubFragTableModel extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6105594044790311712L;
	private ArrayList<ArrayList<Object>> originalData;
	private ArrayList<ArrayList<Object>> data;
	private String[] columnNames = {Constants.SUB_FRAG_KIND_CLMN_NAME, Constants.SUB_FRAG_FRAG_CLMN_NAME};

	public SubFragTableModel(ArrayList<NamedElement> subFragList){
		data = new ArrayList<ArrayList<Object>>();
		originalData = new ArrayList<ArrayList<Object>>();
		for(NamedElement subFrag : subFragList){
			String typeName = (subFrag instanceof ReplacementFragmentType) ? Constants.SUB_FRAG_TYPE_RPLC_NAME : Constants.SUB_FRAG_TYPE_PLC_NAME;
			DataNamedElementItem item = new DataNamedElementItem(new JLabel(subFrag.getName()), subFrag);
			ArrayList<Object> row = new ArrayList<Object>();
			row.add(typeName);
			row.add(item);
			data.add(row);
			originalData.add(row);
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex == Constants.SUB_FRAG_KIND_CLMN) ? false : true;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class cl;
		switch(columnIndex){
			case Constants.SUB_FRAG_FRAG_CLMN : {
				cl = DataNamedElementItem.class;
			}; break;
			default : {
				cl = String.class;
			}; break;
		}
		return cl;
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data.get(rowIndex).set(columnIndex, aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public ArrayList<ArrayList<Object>> getData(){
		return this.data;
	}
	
	public ArrayList<ArrayList<Object>> getOriginalData(){
		return this.originalData;
	}
	
	public void setDisplayData(ArrayList<ArrayList<Object>> displayData){
		this.data = displayData;
		this.fireTableDataChanged();
	}
}
