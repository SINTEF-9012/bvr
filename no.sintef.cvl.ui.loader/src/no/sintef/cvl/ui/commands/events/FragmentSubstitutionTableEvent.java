package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.exceptions.UnimplementedUIError;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.VariationPoint;

public class FragmentSubstitutionTableEvent implements TableModelListener {

	private ConfigurableUnit cu;
	private ArrayList<ArrayList<DataItem>> data;
	private CVLView view;

	public FragmentSubstitutionTableEvent(ConfigurableUnit cu, ArrayList<ArrayList<DataItem>> data, CVLView view) {
		this.cu = cu;
		this.data = data;
		this.view = view;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getLastRow() == e.getFirstRow()){
				int rowIndex = e.getLastRow();
				int columnIndex = e.getColumn();
				DataItem modifiedCell = data.get(rowIndex).get(0);
				if(columnIndex == 0){
					FragmentSubstitution fs = (FragmentSubstitution) modifiedCell.getNamedElement();
					JLabel label = (JLabel) modifiedCell.getLabel();
					fs.setName(label.getText());
					view.notifyCVLRelalizationView();
				}
			}else{
				new UnimplementedUIError("Few rows were updated - not implemented");
			}
		}
	}
}
