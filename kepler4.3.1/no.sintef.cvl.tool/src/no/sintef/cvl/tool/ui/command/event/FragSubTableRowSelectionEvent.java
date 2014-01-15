package no.sintef.cvl.tool.ui.command.event;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cvl.FragmentSubstitution;
import cvl.NamedElement;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.primitive.DataItem;
import no.sintef.cvl.tool.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.tool.primitive.impl.ObserverDataBulk;
import no.sintef.cvl.tool.ui.context.StaticUICommands;
import no.sintef.cvl.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.tool.ui.model.FragSubTableModel;

public class FragSubTableRowSelectionEvent implements ListSelectionListener {
	
	private FragmentSubstitutionJTable jtable;

	public FragSubTableRowSelectionEvent(FragmentSubstitutionJTable table){
		this.jtable = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		try{
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
					Context.eINSTANCE.getViewChangeManager().updateSubjects(data, jtable);
				}else{
					throw new UnsupportedOperationException("FragmentSubstitution should be passed when you select a row, but we have " + variationPoint);
				}
			}
		}catch (Exception error){
			Context.eINSTANCE.logger.error("some error on selection", error);
			StaticUICommands.showMessageErrorDialog(jtable, error, "some error on selection");
		}
	}
}
