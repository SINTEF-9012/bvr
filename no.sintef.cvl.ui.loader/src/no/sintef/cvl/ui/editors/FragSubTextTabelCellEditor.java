package no.sintef.cvl.ui.editors;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import javax.swing.AbstractCellEditor;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.primitives.DataItem;

public class FragSubTextTabelCellEditor extends AbstractCellEditor implements
		TableCellEditor {

	private static final long serialVersionUID = 7772738255299065846L;
	private JTextField  editor;
	private DataItem editedValue = null;
	
	public FragSubTextTabelCellEditor(){
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
	
	@Override
	public boolean isCellEditable(EventObject e) {
		if (e instanceof MouseEvent) {
			return ((MouseEvent) e).getClickCount() >= Constants.FRAG_SUB_FS_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}

}
