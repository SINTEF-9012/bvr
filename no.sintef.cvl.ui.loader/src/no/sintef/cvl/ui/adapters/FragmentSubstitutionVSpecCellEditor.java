package no.sintef.cvl.ui.adapters;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.eclipse.emf.common.util.EList;

import cvl.NamedElement;
import cvl.VSpec;

public class FragmentSubstitutionVSpecCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993488539123070478L;
	private JComboBox editor;
	
	public FragmentSubstitutionVSpecCellEditor(EList<VSpec> vSpecs){
		ArrayList<HashMap<JComponent, NamedElement>> values = new ArrayList<HashMap<JComponent, NamedElement>>();
		for(VSpec vspec : vSpecs){
			JLabel label = new JLabel(vspec.getName());
			HashMap<JComponent, NamedElement> item = new HashMap<JComponent, NamedElement>();
			item.put(label, vspec);
			values.add(item);
		}
		editor = new JComboBox(values.toArray());
		editor.setRenderer(new FragmentSubstitutionComboxRenderer());
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
