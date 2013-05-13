package no.sintef.cvl.ui.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import no.sintef.cvl.ui.commands.events.FragmentSubstitutionTableEvent;
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

public class FragmentSubstitutionTableModel extends AbstractTableModel
		implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6757147907729864204L;
	private ConfigurableUnit cu;
	private String[] columnNames = {"Fragment Substitution Name", "VSpec Name"};
	private ArrayList<ArrayList<HashMap<JComponent, NamedElement>>> data = new ArrayList<ArrayList<HashMap<JComponent, NamedElement>>>();

	public FragmentSubstitutionTableModel(ConfigurableUnit cu, CVLView view){
		this.cu = cu;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) varPoint;
				ArrayList<VSpec> referencedVSpecs = this.getReferencedVSpecs(fragmentSubstitution);
				for(VSpec vSpec : referencedVSpecs){
					HashMap<JComponent, NamedElement> cellFSN = new HashMap<JComponent, NamedElement>();
					HashMap<JComponent, NamedElement> cellVSN = new HashMap<JComponent, NamedElement>();
					
					cellFSN.put(new JLabel(fragmentSubstitution.getName()), fragmentSubstitution);
					cellVSN.put(new JLabel(vSpec.getName()), varPoint);
					
					ArrayList<HashMap<JComponent, NamedElement>> row = new ArrayList<HashMap<JComponent, NamedElement>>(Arrays.asList(cellFSN, cellVSN));
					data.add(row);
				}
			}
		}
		addTableModelListener(new FragmentSubstitutionTableEvent(cu, data, view));
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
		HashMap<JComponent, NamedElement> cell = data.get(rowIndex).get(columnIndex);
		JLabel label = (JLabel) cell.keySet().iterator().next();
		return label.getText();
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch(columnIndex){
			case 0:{
				HashMap<JComponent, NamedElement> cell = data.get(rowIndex).get(columnIndex);
				JLabel label = (JLabel) cell.keySet().iterator().next();
				label.setText((String) aValue);
			};break;
			case 1:{
				data.get(rowIndex).set(columnIndex, (HashMap<JComponent, NamedElement>) aValue);
			}; break;
			default : {
				new UnimplementedUIError("table setter is not implemented for this column " + columnIndex);
			};break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	

}
