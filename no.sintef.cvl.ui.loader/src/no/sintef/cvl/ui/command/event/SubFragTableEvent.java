package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.SubFragTableModel;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.observer.impl.ConfigurableUnitSubject;
import no.sintef.cvl.ui.observer.impl.ViewChanageManager;
import no.sintef.cvl.ui.primitive.DataItem;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VariationPoint;

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
							vp.setName(label.getText());
							ArrayList<Subject> subjects = jtable.getSubjects();
							for(Subject subject : subjects)
								if(subject instanceof ConfigurableUnitSubject)
									ViewChanageManager.getChangeManager().refreshSubject(subject);
						}
					}
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}

	}

}
