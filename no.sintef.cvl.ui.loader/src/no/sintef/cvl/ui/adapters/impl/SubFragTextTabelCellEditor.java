package no.sintef.cvl.ui.adapters.impl;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;

public class SubFragTextTabelCellEditor extends AbstractCellEditor implements
		TableCellEditor {

	private JTextField  editor;
	private DataItem editedValue = null;
	
	public SubFragTextTabelCellEditor(){
		editor = new JTextField();
	}

	@Override
	public Object getCellEditorValue() {
		editedValue.getLabel().setText(editor.getText());
		return editedValue;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editedValue = (DataItem) table.getModel().getValueAt(row, column);
		editor.setText(editedValue.getLabel().getText());
		return editor;
	}

}
