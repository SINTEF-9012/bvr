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
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBoundaryItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;

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
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) variationPoint;
				PlacementFragment placement = fragmentSubstitution.getPlacement();
				ReplacementFragmentType replacement = fragmentSubstitution.getReplacement();
				
				SubFragTableModel subsFragModel = (SubFragTableModel) jtable.getSubstitutionFragmentJTable().getModel();
				ArrayList<ArrayList<Object>> subsFragData = subsFragModel.getOriginalData();
				ArrayList<ArrayList<Object>> newDisplayData = new ArrayList<ArrayList<Object>>();
				for(ArrayList<Object> row : subsFragData){
					DataNamedElementItem cellItem = (DataNamedElementItem) row.get(Constants.SUB_FRAG_FRAG_CLMN);
					NamedElement fragment = cellItem.getNamedElement();
					if(fragment instanceof PlacementFragment && ((PlacementFragment) fragment).equals(placement)){
						newDisplayData.add(row);
					}
					if(fragment instanceof ReplacementFragmentType && ((ReplacementFragmentType) fragment).equals(replacement)){
						newDisplayData.add(row);
					}
				}
				subsFragModel.setDisplayData(newDisplayData);
				
				//populate binding editor here
				BindingTableModel bindingTableModel = (BindingTableModel) jtable.getBindingJTable().getModel();
				try {
					bindingTableModel.updateBindingEditor(fragmentSubstitution);
				} catch (CVLModelException e) {
					e.printStackTrace();
				}
				HashMap<DataItem, ArrayList<DataItem>> boundariesMap = null;
				try {
					boundariesMap = BoundariesDropDownCalculator.calulateAllowedBoundaries(fragmentSubstitution);
				} catch (AbstractError e) {
					e.printStackTrace();
				}
				jtable.getBindingJTable().setDefaultEditor(DataBoundaryItem.class, new BindingBoundariesComboBoxTableCellEditor(boundariesMap));
			}else{
				throw new UnsupportedOperationException();
			}
		}
	}
}
