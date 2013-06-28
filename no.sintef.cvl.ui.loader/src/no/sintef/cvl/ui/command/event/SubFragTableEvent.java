package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.primitive.DataItem;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VariationPoint;

public class SubFragTableEvent implements TableModelListener {

	private ConfigurableUnit cu;
	private ArrayList<ArrayList<Object>> data;
	private CVLView view;
	
	public SubFragTableEvent(ConfigurableUnit cu, ArrayList<ArrayList<Object>> data, CVLView view){
		this.cu = cu;
		this.data = data;
		this.view = view;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			//when column is less than zero then the update event in a model was triggered by for example filtering not users selection 
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					if(columnIndex == 1){
						DataItem modifiedCell = (DataItem) data.get(rowIndex).get(columnIndex);
						NamedElement vp = (NamedElement) modifiedCell.getNamedElement();
						JLabel label = (JLabel) modifiedCell.getLabel();
						String newName = label.getText();
						String currentName = vp.getName();
						if(!newName.equals(currentName)){
							vp.setName(label.getText());
							view.notifyRelalizationViewUpdate();
						}
					}
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}

	}

}
