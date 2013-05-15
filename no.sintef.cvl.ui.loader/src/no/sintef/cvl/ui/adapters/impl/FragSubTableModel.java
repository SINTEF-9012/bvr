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
import no.sintef.cvl.ui.exceptions.UnexpectedUIError;
import no.sintef.cvl.ui.exceptions.UnimplementedUIError;
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
	private String[] columnNames = {"Fragment Substitution Name", "VSpec Name"};
	private ArrayList<ArrayList<DataItem>> data = new ArrayList<ArrayList<DataItem>>();

	public FragSubTableModel(ConfigurableUnit cu, ArrayList<DataItem> vSpecMap){
		this.cu = cu;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) varPoint;
				ArrayList<VSpec> referencedVSpecs = this.getReferencedVSpecs(fragmentSubstitution);
				for(VSpec vSpec : referencedVSpecs){
					DataFragSubItem cellFSN = new DataFragSubItem(new JLabel(fragmentSubstitution.getName()), fragmentSubstitution);
					DataVSpecItem cellVSN = this.getVSpecItem(vSpec, vSpecMap);

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
	
	private HashMap<JComponent, NamedElement> findMap(VSpec vSpec, ArrayList<HashMap<JComponent, NamedElement>> vSpecMap){
		for(HashMap<JComponent, NamedElement> map : vSpecMap){
			if(map.values().iterator().next().equals(vSpec)){
				return map;
			}
		}
		return null;
	}

	private ArrayList<VSpec> getReferencedVSpecs(FragmentSubstitution fragSubs){
		ArrayList<VSpec> vSpecs = new ArrayList<VSpec>();
		VSpec vSpec = fragSubs.getBindingVSpec();
		Choice choice = fragSubs.getBindingChoice();
		VClassifier classifier = fragSubs.getBindingClassifier();
		if(vSpec != null){
			vSpecs.add(vSpec);
		}
		if(choice != null){
			vSpecs.add(choice);
		}
		if(classifier != null){
			vSpecs.add(classifier);
		}
		return vSpecs;
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
		//data.get(rowIndex).set(columnIndex, (DataItem) aValue);
		switch(columnIndex){
			case 0:{
				DataItem cell = data.get(rowIndex).get(columnIndex);
				JLabel label = cell.getLabel();
				label.setText((String) aValue);
			};break;
			case 1:{
				//data.get(rowIndex).set(columnIndex, (HashMap<JComponent, NamedElement>) aValue);
				data.get(rowIndex).set(columnIndex, (DataItem) aValue);
			}; break;
			default : {
				new UnimplementedUIError("table setter is not implemented for this column " + columnIndex);
			};break;
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
			case 1 : cl = JComboBox.class;
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
