package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.editors.FragmentSubstitutionJTable;
import no.sintef.cvl.ui.exceptions.CVLModelException;
import no.sintef.cvl.ui.models.BindingTableModel;
import no.sintef.cvl.ui.models.FragSubTableModel;
import no.sintef.cvl.ui.models.SubFragTableModel;

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
				
				BindingTableModel bindingTableModel = (BindingTableModel) jtable.getBindingJTable().getModel();
				try {
					bindingTableModel.updateBindingEditor(fragmentSubstitution);
				} catch (CVLModelException e) {
					e.printStackTrace();
				}
			}else{
				throw new UnsupportedOperationException();
			}
		}
	}
}
