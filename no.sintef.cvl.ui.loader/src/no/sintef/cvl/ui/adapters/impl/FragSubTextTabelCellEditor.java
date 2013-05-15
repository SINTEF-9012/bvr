package no.sintef.cvl.ui.adapters.impl;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import javax.swing.AbstractCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;

public class FragSubTextTabelCellEditor extends AbstractCellEditor implements
		TableCellEditor {

	private JTextField  editor;
	
	public FragSubTextTabelCellEditor(){
		editor = new JTextField();
	}

	@Override
	public Object getCellEditorValue() {
		return editor.getText();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		DataItem item = (DataItem) table.getModel().getValueAt(row, column);
		editor.setText(item.getLabel().getText());
		return editor;
	}

}
