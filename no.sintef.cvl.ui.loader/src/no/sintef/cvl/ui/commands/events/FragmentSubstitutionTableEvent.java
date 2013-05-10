package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.cvl.ui.exceptions.UnimplementedUIError;

import cvl.ConfigurableUnit;

public class FragmentSubstitutionTableEvent implements TableModelListener {

	private ConfigurableUnit cu;
	private ArrayList<ArrayList<String>> data;

	public FragmentSubstitutionTableEvent(ConfigurableUnit cu,
			ArrayList<ArrayList<String>> data) {
		super();
		this.cu = cu;
		this.data = data;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getLastRow() == e.getFirstRow()){
				int rowIndex = e.getLastRow();
				int columnIndex = e.getColumn();
				System.out.println(data.get(rowIndex).get(columnIndex));
			}else{
				new UnimplementedUIError("Few rows were updated - not implemented");
			}
		}
	}

}
