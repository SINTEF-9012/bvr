package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.exceptions.UnimplementedUIError;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.VariationPoint;

public class FragmentSubstitutionTableEvent implements TableModelListener {

	private ConfigurableUnit cu;
	private ArrayList<ArrayList<HashMap<JComponent, NamedElement>>> data;
	private CVLView view;

	public FragmentSubstitutionTableEvent(ConfigurableUnit cu,
			ArrayList<ArrayList<HashMap<JComponent, NamedElement>>> data,
			CVLView view) {
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
				HashMap<JComponent, NamedElement> modifiedCell = data.get(rowIndex).get(0);
				if(columnIndex == 0){
					FragmentSubstitution fs = (FragmentSubstitution) modifiedCell.values().iterator().next();
					JLabel label = (JLabel) modifiedCell.keySet().iterator().next();
					fs.setName(label.getText());
					view.notifyCVLRelalizationView();
				}
			}else{
				new UnimplementedUIError("Few rows were updated - not implemented");
			}
		}
	}
	

	private FragmentSubstitution getFragmentSubstitution(int rowIndex, int columnIndex){
		HashMap<JComponent, NamedElement> fragSubMap = data.get(rowIndex).get(0);
		return (FragmentSubstitution) fragSubMap.values().iterator().next();
	}
}
