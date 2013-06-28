package no.sintef.cvl.ui.editor;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.cvl.ui.command.event.BindingModelTableEvent;
import no.sintef.cvl.ui.command.event.BindingRowSelectionEvent;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.primitive.impl.DataBindingItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.renderer.BindingBindingCellRenderer;
import no.sintef.cvl.ui.renderer.BindingBoundariesCellRenderer;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;

public class BindingJTable extends JTable {

	private static final long serialVersionUID = 8644097588893969285L;
	private CVLView view;
	private ConfigurableUnit cu;
	private FragmentSubstitution fs;

	public BindingJTable(ConfigurableUnit cu, CVLView view) throws AbstractError{
		this.cu = cu;
		this.view = view;
		init();
	}
	
	public BindingJTable(ConfigurableUnit cu, CVLView view, FragmentSubstitution fs) throws AbstractError{
		this.fs = fs;
		init();
	}
	
	private void init() throws AbstractError{
		BindingTableModel tableModel = new BindingTableModel(fs);
		setModel(tableModel);
		
		setDefaultRenderer(DataBindingItem.class, new BindingBindingCellRenderer());
		setDefaultRenderer(DataNamedElementItem.class, new BindingBoundariesCellRenderer());
		setDefaultRenderer(DataBoundaryItem.class, new BindingBoundariesCellRenderer());
		
		//setDefaultEditor(DataNamedElementItem.class, new BindingBoundariesTextTableCellEditor());
		
		setColumnSelectionAllowed(false);
		getTableHeader().setReorderingAllowed(false);
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getSelectionModel().addListSelectionListener(new BindingRowSelectionEvent(this));
		tableModel.addTableModelListener(new BindingModelTableEvent(cu, view));		
	}
}
