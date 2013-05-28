package no.sintef.cvl.ui.editors;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.models.FragSubVSpecComboboxModel;
import no.sintef.cvl.ui.renderes.FragSubVSpecComboboxRenderer;

import org.eclipse.emf.common.util.EList;

import cvl.NamedElement;
import cvl.VSpec;

public class FragSubVSpecTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993488539123070478L;
	private JComboBox<DataItem> editor;
		
	public FragSubVSpecTableCellEditor(ArrayList<DataItem> vSpecMap) {
		editor = new JComboBox<DataItem>(new FragSubVSpecComboboxModel(vSpecMap));
		editor.setRenderer(new FragSubVSpecComboboxRenderer());
	}

	@Override
	public Object getCellEditorValue() {
		return editor.getSelectedItem();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editor.getModel().setSelectedItem(table.getModel().getValueAt(row, column));
		return editor;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		if (e instanceof MouseEvent) {
			return ((MouseEvent) e).getClickCount() >= Constants.FRAG_SUB_VSPEC_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}
}
