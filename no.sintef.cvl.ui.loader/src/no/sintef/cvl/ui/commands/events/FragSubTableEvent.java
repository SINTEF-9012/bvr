package no.sintef.cvl.ui.commands.events;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.adapters.DataItem;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.NullVSpec;
import no.sintef.cvl.ui.exceptions.UnimplementedUIError;
import no.sintef.cvl.ui.loader.CVLView;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.VSpec;
import cvl.VariationPoint;

public class FragSubTableEvent implements TableModelListener {

	private ConfigurableUnit cu;
	private ArrayList<ArrayList<DataItem>> data;
	private CVLView view;

	public FragSubTableEvent(ConfigurableUnit cu, ArrayList<ArrayList<DataItem>> data, CVLView view) {
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
				DataItem fragSubCell = data.get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
				VariationPoint vp = (VariationPoint) fragSubCell.getNamedElement();
				if(columnIndex == Constants.FRAG_SUBS_VARIATION_POINT_CLMN){
					JLabel label = (JLabel) fragSubCell.getLabel();
					String newName = label.getText();
					String currentName = vp.getName();
					if(!newName.equals(currentName)){
						vp.setName(label.getText());
						view.notifyCVLRelalizationView();
					}
				}
				if(columnIndex == Constants.FRAG_SUBS_VSPEC_CLMN){
					DataItem vspeCell = data.get(rowIndex).get(Constants.FRAG_SUBS_VSPEC_CLMN);
					VSpec vSpec = (VSpec) vspeCell.getNamedElement();
					if(vSpec instanceof NullVSpec){
						vp.setBindingVSpec(null);
					}else{
						vp.setBindingVSpec(vSpec);
					}
					//view.notifyCVLRelalizationView();
				}
			}else{
				new UnimplementedUIError("Few rows were updated - not implemented");
			}
		}
	}
}
