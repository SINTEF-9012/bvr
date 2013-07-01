package no.sintef.cvl.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.cvl.ui.command.event.BindingModelTableEvent;
import no.sintef.cvl.ui.command.event.BindingRowSelectionEvent;
import no.sintef.cvl.ui.dropdown.BoundariesDropDownCalculator;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.CVLModelException;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.observer.impl.ConfigurableUnitSubject;
import no.sintef.cvl.ui.observer.impl.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBindingItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;
import no.sintef.cvl.ui.renderer.BindingBindingCellRenderer;
import no.sintef.cvl.ui.renderer.BindingBoundariesCellRenderer;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;

public class BindingJTable extends JTable implements Observer {

	private static final long serialVersionUID = 8644097588893969285L;
	private FragmentSubstitution selectedFragmentSubstitution;
	private ArrayList<Subject> subjects;
	private BindingTableModel tableModel;

	public BindingJTable(ArrayList<Subject> arrayList) throws AbstractError{
		subjects = arrayList;
		for(Subject subject : subjects)
			subject.attach(this);
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
			((BindingTableModel) this.getModel()).updateBindingEditor(selectedFragmentSubstitution);
			BindingBoundariesComboBoxTableCellEditor editor = (BindingBoundariesComboBoxTableCellEditor) getDefaultEditor(DataBoundaryItem.class);
			HashMap<DataItem, ArrayList<DataItem>> boundariesMap = null;
			if(selectedFragmentSubstitution != null)
				boundariesMap = BoundariesDropDownCalculator.calulateAllowedBoundaries(selectedFragmentSubstitution);
			editor.setData(boundariesMap);
		} catch (AbstractError e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
}
