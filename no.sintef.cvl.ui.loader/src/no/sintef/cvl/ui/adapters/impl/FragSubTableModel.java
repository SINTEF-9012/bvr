package no.sintef.cvl.ui.adapters.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.commands.events.FragSubTableEvent;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.NullVSpec;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.loader.CVLView;

import org.eclipse.emf.common.util.EList;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.VariationPoint;

public class FragSubTableModel extends AbstractTableModel
		implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6757147907729864204L;
	private ConfigurableUnit cu;
	private String[] columnNames = {Constants.FRAG_SUB_VP_CLMN_NAME, Constants.FRAG_SUB_VSPEC_CLMN_NAME};
	private ArrayList<ArrayList<DataItem>> data = new ArrayList<ArrayList<DataItem>>();

	public FragSubTableModel(ConfigurableUnit cu, ArrayList<DataItem> vSpecMap){
		this.cu = cu;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) varPoint;
				VSpec referenceVSpec = fragmentSubstitution.getBindingVSpec();
				if(referenceVSpec == null){
					DataNamedElementItem cellFSN = new DataNamedElementItem(new JLabel(fragmentSubstitution.getName()), fragmentSubstitution);
					//data item with null vspec is the first in the list
					DataVSpecItem cellVSN = (DataVSpecItem) vSpecMap.get(0);

					ArrayList<DataItem> row = new ArrayList<DataItem>(Arrays.asList(cellFSN, cellVSN));
					data.add(row);
				}else{
					DataNamedElementItem cellFSN = new DataNamedElementItem(new JLabel(fragmentSubstitution.getName()), fragmentSubstitution);
					DataVSpecItem cellVSN = this.getVSpecItem(referenceVSpec, vSpecMap);

					ArrayList<DataItem> row = new ArrayList<DataItem>(Arrays.asList(cellFSN, cellVSN));
					data.add(row);
				}
			}
		}
	}
	
	private DataVSpecItem getVSpecItem(VSpec vSpec, ArrayList<DataItem> vSpecMap){
		for(DataItem item : vSpecMap){
			if(item.getNamedElement().equals(vSpec)){
				return (DataVSpecItem) item;
			}
		}
		return null;
	}


	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DataItem item = data.get(rowIndex).get(columnIndex);
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch(columnIndex){
			case Constants.FRAG_SUBS_VARIATION_POINT_CLMN :{
				DataItem cell = data.get(rowIndex).get(columnIndex);
				JLabel label = cell.getLabel();
				label.setText((String) aValue);
			};break;
			case Constants.FRAG_SUBS_VSPEC_CLMN:{
				data.get(rowIndex).set(columnIndex, (DataItem) aValue);
			}; break;
			default : {
				throw new UnsupportedOperationException("table setter is not implemented for this column " + columnIndex);
			}
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class cl;
		switch(columnIndex) {
			case Constants.FRAG_SUBS_VSPEC_CLMN : cl = JComboBox.class;
				break;
			default : cl = String.class;
				break;
		}
		return cl;
	}
	

	public ArrayList<ArrayList<DataItem>> getData() {
		return data;
	}
	

}
