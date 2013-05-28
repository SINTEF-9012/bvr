package no.sintef.cvl.ui.editors;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.models.BindingBoundariesComboBoxModel;

public class BindingBoundariesComboBoxTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	private static final long serialVersionUID = 7072158898721982324L;
	
	private HashMap<DataItem, ArrayList<DataItem>> data;
	private DataItem editedBoundaryProperty;
	private HashMap<DataItem, JComboBox<DataItem>> editedBoundaryPropertyComboBoxMap;
	
	public BindingBoundariesComboBoxTableCellEditor(HashMap<DataItem, ArrayList<DataItem>> boundariesListMap){
		editedBoundaryProperty = null;
		data = boundariesListMap;
		editedBoundaryPropertyComboBoxMap = new HashMap<DataItem, JComboBox<DataItem>>();
	}
	
	@Override
	public Object getCellEditorValue() {
		return editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty).getSelectedItem();
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
			boolean isSelected, int rawIndex, int columnIndex) {
		editedBoundaryProperty = (DataItem) table.getModel().getValueAt(rawIndex, Constants.BINDING_PROP_CLMN);
		JComboBox<DataItem> editor = editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty);
		if(editor == null){
			ArrayList<DataItem> comboxData = data.get(editedBoundaryProperty);
			editor = new JComboBox<DataItem>(new BindingBoundariesComboBoxModel(comboxData));
			editedBoundaryPropertyComboBoxMap.put(editedBoundaryProperty, editor);
		}
		editor.getModel().setSelectedItem(table.getModel().getValueAt(rawIndex, columnIndex));
		return editor;
	}

}
