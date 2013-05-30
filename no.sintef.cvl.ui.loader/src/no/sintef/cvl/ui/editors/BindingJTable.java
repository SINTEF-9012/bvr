package no.sintef.cvl.ui.editors;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.cvl.ui.adapters.impl.DataBoundaryItem;
import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.models.BindingTableModel;
import no.sintef.cvl.ui.renderes.BindingBoundariesCellRenderer;
import cvl.ConfigurableUnit;

public class BindingJTable extends JTable {

	private static final long serialVersionUID = 8644097588893969285L;
	private CVLView view;
	private ConfigurableUnit cu;

	public BindingJTable(ConfigurableUnit cu, CVLView view) throws AbstractError{
		this.cu = cu;
		this.view = view;
		
		setModel(new BindingTableModel(null));
		
		setDefaultRenderer(DataNamedElementItem.class, new BindingBoundariesCellRenderer());
		setDefaultRenderer(DataBoundaryItem.class, new BindingBoundariesCellRenderer());
		
		setDefaultEditor(DataNamedElementItem.class, new BindingBoundariesTextTableCellEditor());
		
		getTableHeader().setReorderingAllowed(false);
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
}