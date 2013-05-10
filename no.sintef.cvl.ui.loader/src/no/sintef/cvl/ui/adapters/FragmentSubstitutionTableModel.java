package no.sintef.cvl.ui.adapters;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import no.sintef.cvl.ui.commands.events.FragmentSubstitutionTableEvent;

import org.eclipse.emf.common.util.EList;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.VariationPoint;

public class FragmentSubstitutionTableModel extends AbstractTableModel
		implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6757147907729864204L;
	private ConfigurableUnit cu;
	private String[] columnNames = {"Fragment Substitution Name", "VSpec Name"};
	private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

	public FragmentSubstitutionTableModel(ConfigurableUnit cu){
		this.cu = cu;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				String nameFragSub = varPoint.getName();
				ArrayList<VSpec> referencedVSpecs = this.getAllVSpecs((FragmentSubstitution) varPoint);
				for(VSpec vSpec : referencedVSpecs){
					String vspecName = vSpec.getName();
					ArrayList<String> row = new ArrayList<String>(Arrays.asList(nameFragSub, vspecName));
					data.add(row);
				}
			}
		}
		addTableModelListener(new FragmentSubstitutionTableEvent(cu, data));
	}
	
	private ArrayList<VSpec> getAllVSpecs(FragmentSubstitution fragSubs){
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
		return data.get(rowIndex).get(columnIndex);
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
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data.get(rowIndex).set(columnIndex, (String) aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	

}
