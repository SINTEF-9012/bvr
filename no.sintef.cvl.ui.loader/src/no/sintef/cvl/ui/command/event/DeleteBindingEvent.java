package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromReplacement;
import cvl.NamedElement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.VariationPoint;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.LoaderUtility;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.model.FragSubTableModel;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataBindingItem;

public class DeleteBindingEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public DeleteBindingEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		if(!LoaderUtility.isBindingPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_BINDING_TAB_NO_FOCUS);
			return;
		}
		JScrollPane bindingPanel = (JScrollPane) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable bindingTable = LoaderUtility.getBindingTable(bindingPanel);
		if(bindingTable == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_CAN_NOT_LOCATE_BINDING_TABLE);
			return;
		}
		
		int[] rowIndexes = bindingTable.getSelectedRows();
		BindingTableModel model = (BindingTableModel) bindingTable.getModel();
		FragmentSubstitution fragmentSubstitution = model.getFragmentSubstitution();
		if(fragmentSubstitution == null)
			return;
		
		for(int index : rowIndexes){
			DataBindingItem row = (DataBindingItem) model.getData().get(index).get(Constants.BINDING_TYPE_CLMN);
			NamedElement binding = row.getNamedElement();
			if(binding instanceof ToBinding){
				ToPlacement toPlacement = ((ToBinding) binding).getToPlacement();
				if(toPlacement.getInsideBoundaryElement().size() == 1 && toPlacement.getInsideBoundaryElement().get(0).getMOFRef() == null){
					fragmentSubstitution.getBoundaryElementBinding().remove(binding);
				}else{
					int result = JOptionPane.showConfirmDialog(filePane, Messages.DIALOG_MSG_BINDING_NOT_DUMMY, Messages.DIALOG_MSG_BINDING_REMOVE_TITLE, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						continue;
					fragmentSubstitution.getBoundaryElementBinding().remove(binding);
				}
			}
			if(binding instanceof FromBinding){
				FromReplacement fromReplacement = ((FromBinding) binding).getFromReplacement();
				if(fromReplacement.getInsideBoundaryElement().getMOFRef() == null){
					fragmentSubstitution.getBoundaryElementBinding().remove(binding);
				}else{
					int result = JOptionPane.showConfirmDialog(filePane, Messages.DIALOG_MSG_BINDING_NOT_DUMMY, Messages.DIALOG_MSG_BINDING_REMOVE_TITLE, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						continue;
					fragmentSubstitution.getBoundaryElementBinding().remove(binding);
				}
			}
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}

}
