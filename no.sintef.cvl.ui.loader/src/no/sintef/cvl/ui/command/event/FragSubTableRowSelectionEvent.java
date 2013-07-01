package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;

import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.dropdown.BoundariesDropDownCalculator;
import no.sintef.cvl.ui.editor.BindingBoundariesComboBoxTableCellEditor;
import no.sintef.cvl.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.CVLModelException;
import no.sintef.cvl.ui.exception.PlacementReplacementNullException;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.model.FragSubTableModel;
import no.sintef.cvl.ui.model.SubFragTableModel;
import no.sintef.cvl.ui.observer.impl.ViewChanageManager;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class FragSubTableRowSelectionEvent implements ListSelectionListener {
	
	private FragmentSubstitutionJTable jtable;

	public FragSubTableRowSelectionEvent(FragmentSubstitutionJTable table){
		this.jtable = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!event.getValueIsAdjusting()){
			int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
			FragSubTableModel sourceModel = (FragSubTableModel) jtable.getModel();
			ArrayList<ArrayList<DataItem>> sourceData = sourceModel.getData();
			ArrayList<DataItem> selectedRow = sourceData.get(selectedIndex);
			DataNamedElementItem selectedFragSubData = (DataNamedElementItem) selectedRow.get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
			NamedElement variationPoint = selectedFragSubData.getNamedElement();
			if(variationPoint instanceof FragmentSubstitution){
				ObserverDataBulk data = new ObserverDataBulk();
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) variationPoint;
				data.setDataField("selectedFragmentSubstitution", fragmentSubstitution);
				ViewChanageManager.getChangeManager().updateSubjects(data, jtable);
			}else{
				throw new UnsupportedOperationException();
			}
		}
	}
}
