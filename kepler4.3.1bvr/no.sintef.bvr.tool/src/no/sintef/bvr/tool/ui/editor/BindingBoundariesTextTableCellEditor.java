package no.sintef.bvr.tool.ui.editor;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.primitive.DataItem;

public class BindingBoundariesTextTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {


	private static final long serialVersionUID = 8224223343848439557L;
	
	private JTextField editor;
	private DataItem editedValue = null;
	
	public BindingBoundariesTextTableCellEditor(){
		editor = new JTextField();
	}

	@Override
	public Object getCellEditorValue() {
		editedValue.getLabel().setText(editor.getText());
		return editedValue;
	}

	@Override
	public boolean isCellEditable(EventObject e) {
		if(e instanceof MouseEvent){
			return ((MouseEvent) e).getClickCount() >= Constants.BINDING_BOUNDARIES_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editedValue = ((DataItem) table.getModel().getValueAt(row, column));
		editor.setText(editedValue.getLabel().getText());
		return editor;
	}
}
