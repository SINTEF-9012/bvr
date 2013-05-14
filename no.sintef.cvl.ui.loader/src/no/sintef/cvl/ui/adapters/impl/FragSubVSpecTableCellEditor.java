package no.sintef.cvl.ui.adapters.impl;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;

import org.eclipse.emf.common.util.EList;

import cvl.NamedElement;
import cvl.VSpec;

public class FragSubVSpecTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993488539123070478L;
	private JComboBox editor;
		
	public FragSubVSpecTableCellEditor(ArrayList<DataItem> vSpecMap) {
		editor = new JComboBox(vSpecMap.toArray());
		editor.setRenderer(new FragSubComboxRenderer());
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
