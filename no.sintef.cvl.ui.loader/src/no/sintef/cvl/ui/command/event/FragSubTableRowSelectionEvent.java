package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cvl.FragmentSubstitution;
import cvl.NamedElement;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.ui.model.FragSubTableModel;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class FragSubTableRowSelectionEvent implements ListSelectionListener {
	
	private FragmentSubstitutionJTable jtable;

	public FragSubTableRowSelectionEvent(FragmentSubstitutionJTable table){
		this.jtable = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
		if(!event.getValueIsAdjusting() && selectedIndex >= 0){
			FragSubTableModel sourceModel = (FragSubTableModel) jtable.getModel();
			ArrayList<ArrayList<DataItem>> sourceData = sourceModel.getData();
			ArrayList<DataItem> selectedRow = sourceData.get(selectedIndex);
			DataNamedElementItem selectedFragSubData = (DataNamedElementItem) selectedRow.get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
			NamedElement variationPoint = selectedFragSubData.getNamedElement();
			if(variationPoint instanceof FragmentSubstitution){
				ObserverDataBulk data = new ObserverDataBulk();
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) variationPoint;
				data.setDataField("selectedFragmentSubstitution", fragmentSubstitution);
				Context.eINSTANCE.getViewChnageManager().updateSubjects(data, jtable);
			}else{
				throw new UnsupportedOperationException();
			}
		}
	}
}
