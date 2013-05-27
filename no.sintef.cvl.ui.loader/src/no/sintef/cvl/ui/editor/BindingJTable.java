package no.sintef.cvl.ui.editor;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.cvl.ui.adapters.impl.BindingBoundariesCellRenderer;
import no.sintef.cvl.ui.adapters.impl.BindingBoundariesComboBoxTableCellEditor;
import no.sintef.cvl.ui.adapters.impl.BindingBoundariesTextTableCellEditor;
import no.sintef.cvl.ui.adapters.impl.BindingTableModel;
import no.sintef.cvl.ui.adapters.impl.DataBoundaryItem;
import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.ConfigurableUnit;

public class BindingJTable extends JTable {

	private CVLView view;
	private ConfigurableUnit cu;

	public BindingJTable(ConfigurableUnit cu, CVLView view) throws AbstractError{
		this.cu = cu;
		this.view = view;
		
		setModel(new BindingTableModel(null));
		
		setDefaultRenderer(DataNamedElementItem.class, new BindingBoundariesCellRenderer());
		setDefaultRenderer(DataBoundaryItem.class, new BindingBoundariesCellRenderer());
		
		setDefaultEditor(DataNamedElementItem.class, new BindingBoundariesTextTableCellEditor());
		//setDefaultEditor(DataBoundaryItem.class, new BindingBoundariesTableCellEditor());
		
		getTableHeader().setReorderingAllowed(false);
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
}
