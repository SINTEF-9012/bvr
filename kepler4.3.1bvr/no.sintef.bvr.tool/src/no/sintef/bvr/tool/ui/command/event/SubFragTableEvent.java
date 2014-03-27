package no.sintef.bvr.tool.ui.command.event;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;

import bvr.NamedElement;

public class SubFragTableEvent implements TableModelListener {

	private SubstitutionFragmentJTable jtable;

	public SubFragTableEvent(SubstitutionFragmentJTable table){
		jtable = table;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		SubFragTableModel tableModel = (SubFragTableModel) jtable.getModel();
		if(TableModelEvent.UPDATE == e.getType()){
			//when column is less than zero then the update event in a model was triggered by for example filtering not users selection 
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					if(columnIndex == Constants.SUB_FRAG_FRAG_CLMN){
						DataItem modifiedCell = (DataItem) tableModel.getData().get(rowIndex).get(columnIndex);
						NamedElement vp = (NamedElement) modifiedCell.getNamedElement();
						JLabel label = (JLabel) modifiedCell.getLabel();
						String newName = label.getText();
						String currentName = vp.getName();
						if(!newName.equals(currentName)){
							Context.eINSTANCE.getEditorCommands().setName(vp, label.getText());
							//vp.setName(label.getText());
							/*ArrayList<Subject> subjects = Context.eINSTANCE.getViewChangeManager().registeredSubjects(jtable);
							for(Subject subject : subjects)
								if(subject instanceof ConfigurableUnitSubject)
									Context.eINSTANCE.getViewChangeManager().refreshSubject(subject);*/
						}
					}
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}

	}

}
