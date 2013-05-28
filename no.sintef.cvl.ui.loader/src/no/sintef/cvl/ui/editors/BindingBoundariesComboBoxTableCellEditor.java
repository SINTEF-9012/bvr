package no.sintef.cvl.ui.editors;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.exceptions.UnexpectedException;
import no.sintef.cvl.ui.models.BindingBoundariesComboBoxModel;
import no.sintef.cvl.ui.renderes.BindingBoundariesCellRenderer;
import no.sintef.cvl.ui.renderes.BindingBoundariesComboBoxRenderer;

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
		JComboBox<DataItem> editor = editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty);
		if(editor == null){
			try {
				throw new UnexpectedException("editor should not ever be null here, or at least we assume that. We should set an editor on a getTableCellEditorComponent call");
			} catch (UnexpectedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(editor.getSelectedItem());
		return editor.getSelectedItem();
	}
		
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rawIndex, int columnIndex) {
		JComboBox<DataItem> editor = null;
		if(data != null){
			editedBoundaryProperty = (DataItem) table.getModel().getValueAt(rawIndex, Constants.BINDING_PROP_CLMN);
			editor = editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty);
			if(editor == null){
				ArrayList<DataItem> comboxData = data.get(editedBoundaryProperty);
				editor = new JComboBox<DataItem>(new BindingBoundariesComboBoxModel(comboxData));
				editor.setRenderer(new BindingBoundariesComboBoxRenderer());
				editedBoundaryPropertyComboBoxMap.put(editedBoundaryProperty, editor);
			}
			System.out.println(table.getModel().getValueAt(rawIndex, columnIndex));
			editor.getModel().setSelectedItem(table.getModel().getValueAt(rawIndex, columnIndex));
		}
		return editor;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		if(e instanceof MouseEvent){
			return ((MouseEvent) e).getClickCount() >= Constants.BINDING_BOUNDARIES_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}

}
