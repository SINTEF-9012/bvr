package no.sintef.cvl.tool.ui.editor;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.primitive.DataItem;

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

	
	@Override
	public boolean isCellEditable(EventObject e) {
		if (e instanceof MouseEvent) {
			return ((MouseEvent) e).getClickCount() >= Constants.SUB_FRAG_FS_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}
}
