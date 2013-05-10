package no.sintef.cvl.ui.adapters;

import java.awt.Component;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.VSpec;

public class FragmentSubstitutionVSpecCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	private JComboBox editor;
	
	public FragmentSubstitutionVSpecCellEditor(EList<VSpec> vSpecs){
		HashMap<String, VSpec> vspecsMap = new HashMap<String, VSpec>();
		ArrayList<String> values = new ArrayList<String>();
		for(VSpec vspec : vSpecs){
			String value = vspec.getName();
			vspecsMap.put(value, vspec);
			values.add(value);
		}
		editor = new JComboBox(values.toArray());
		
	}
	
	@Override
	public Object getCellEditorValue() {
		return editor.getSelectedItem();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		return editor;
	}

}
