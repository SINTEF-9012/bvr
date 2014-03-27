package no.sintef.bvr.tool.ui.command.event;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.NullVSpec;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;

import bvr.VSpec;
import bvr.VariationPoint;

public class FragSubTableEvent implements TableModelListener {

	private FragmentSubstitutionJTable jtable;

	public FragSubTableEvent(FragmentSubstitutionJTable fragmentSubstitutionJTable) {
		jtable = fragmentSubstitutionJTable;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					ArrayList<Subject> subjects = Context.eINSTANCE.getViewChangeManager().registeredSubjects(jtable);
					FragSubTableModel model = (FragSubTableModel) jtable.getModel();
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					DataItem fragSubCell = model.getData().get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
					VariationPoint vp = (VariationPoint) fragSubCell.getNamedElement();
					if(columnIndex == Constants.FRAG_SUBS_VARIATION_POINT_CLMN){
						JLabel label = (JLabel) fragSubCell.getLabel();
						String newName = label.getText();
						String currentName = vp.getName();
						if(!newName.equals(currentName)){
							Context.eINSTANCE.getEditorCommands().setName(vp, label.getText());
						}
					}
					if(columnIndex == Constants.FRAG_SUBS_VSPEC_CLMN){
						DataItem vspeCell = model.getData().get(rowIndex).get(Constants.FRAG_SUBS_VSPEC_CLMN);
						VSpec vSpec = (VSpec) vspeCell.getNamedElement();
						if(vSpec instanceof NullVSpec){
							Context.eINSTANCE.getEditorCommands().setBindingVariationPoint(vp, null);
						}else{
							Context.eINSTANCE.getEditorCommands().setBindingVariationPoint(vp, vSpec);
						}
					}
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}
	}
}
