package no.sintef.cvl.tool.ui.editor;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.primitive.impl.DataVSpecItem;
import no.sintef.cvl.tool.ui.model.FragSubVSpecComboboxModel;
import no.sintef.cvl.tool.ui.renderer.FragSubVSpecComboboxRenderer;

public class FragSubVSpecTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	private static final long serialVersionUID = 2993488539123070478L;
	private JComboBox<DataVSpecItem> editor;
	private FragSubVSpecComboboxModel model;
		
	public FragSubVSpecTableCellEditor(ArrayList<DataVSpecItem> vSpecMap) {
		model = new FragSubVSpecComboboxModel(vSpecMap);
		editor = new JComboBox<DataVSpecItem>(model);
		editor.setRenderer(new FragSubVSpecComboboxRenderer());
	}
	
	public FragSubVSpecTableCellEditor(){
		model = new FragSubVSpecComboboxModel();
		editor = new JComboBox<DataVSpecItem>(model);
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
	
	public FragSubVSpecComboboxModel getModel(){
		return model;
	}
	
	public void setData(ArrayList<DataVSpecItem> vSpecMap){
		model = new FragSubVSpecComboboxModel(vSpecMap);
		editor.setModel(model);
	}
}
