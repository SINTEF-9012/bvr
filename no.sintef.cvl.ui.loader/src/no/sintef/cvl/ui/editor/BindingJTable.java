package no.sintef.cvl.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.cvl.ui.command.event.BindingModelTableEvent;
import no.sintef.cvl.ui.command.event.BindingRowSelectionEvent;
import no.sintef.cvl.ui.dropdown.BoundariesDropDownCalculator;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBindingItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.renderer.BindingBindingCellRenderer;
import no.sintef.cvl.ui.renderer.BindingBoundariesCellRenderer;
import no.sintef.cvl.ui.subject.ConfigurableUnitSubject;
import no.sintef.cvl.ui.subject.SelectedFragmentSubstitutionSubject;
import cvl.FragmentSubstitution;

public class BindingJTable extends JTable implements Observer {

	private static final long serialVersionUID = 8644097588893969285L;
	private FragmentSubstitution selectedFragmentSubstitution;
	private BindingTableModel tableModel;

	public BindingJTable() throws AbstractError{
		tableModel = new BindingTableModel(selectedFragmentSubstitution);
		setModel(tableModel);
		
		setDefaultRenderer(DataBindingItem.class, new BindingBindingCellRenderer());
		setDefaultRenderer(DataNamedElementItem.class, new BindingBoundariesCellRenderer());
		setDefaultRenderer(DataBoundaryItem.class, new BindingBoundariesCellRenderer());
		setDefaultEditor(DataBoundaryItem.class, new BindingBoundariesComboBoxTableCellEditor());
		
		//setDefaultEditor(DataNamedElementItem.class, new BindingBoundariesTextTableCellEditor());
		
		setColumnSelectionAllowed(false);
		getTableHeader().setReorderingAllowed(false);
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getSelectionModel().addListSelectionListener(new BindingRowSelectionEvent(this));
		tableModel.addTableModelListener(new BindingModelTableEvent(this));	
	}
	
	@Override
	public void update(Subject subject) {
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			selectedFragmentSubstitution = ((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution();
			updateBindingEditor();

		}
		if(subject instanceof ConfigurableUnitSubject){
			updateBindingEditor();
		}
		
	}

	private void updateBindingEditor(){
		try {
			((BindingTableModel) getModel()).updateBindingEditor(selectedFragmentSubstitution);
			BindingBoundariesComboBoxTableCellEditor editor = (BindingBoundariesComboBoxTableCellEditor) getDefaultEditor(DataBoundaryItem.class);
			HashMap<DataItem, ArrayList<DataItem>> boundariesMap = null;
			if(selectedFragmentSubstitution != null)
				boundariesMap = BoundariesDropDownCalculator.calulateAllowedBoundaries(selectedFragmentSubstitution);
			editor.setData(boundariesMap);
		} catch (AbstractError e) {
			throw new UnsupportedOperationException(e);
		}
	}
}
