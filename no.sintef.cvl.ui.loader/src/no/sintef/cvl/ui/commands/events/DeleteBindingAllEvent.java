package no.sintef.cvl.ui.commands.events;

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
import cvl.NamedElement;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.VariationPoint;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.models.BindingTableModel;
import no.sintef.cvl.ui.models.FragSubTableModel;
import no.sintef.cvl.ui.primitives.DataItem;
import no.sintef.cvl.ui.primitives.impl.DataBindingItem;

public class DeleteBindingAllEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public DeleteBindingAllEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		if(!Utility.isBindingPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_BINDING_TAB_NO_FOCUS);
			return;
		}
		JScrollPane bindingPanel = (JScrollPane) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable bindingTable = Utility.getBindingTable(bindingPanel);
		if(bindingTable == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_CAN_NOT_LOCATE_BINDING_TABLE);
			return;
		}
		
		BindingTableModel model = (BindingTableModel) bindingTable.getModel();
		FragmentSubstitution fragmentSubstitution = model.getFragmentSubstitution();
		if(fragmentSubstitution == null)
			return;
		
		fragmentSubstitution.getBoundaryElementBinding().clear();
		
		views.get(tab).notifyRelalizationViewUpdate();
	}

}
