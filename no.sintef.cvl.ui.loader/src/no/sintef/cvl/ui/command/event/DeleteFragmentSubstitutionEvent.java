package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import cvl.ConfigurableUnit;
import cvl.VariationPoint;

import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.FragSubTableModel;
import no.sintef.cvl.ui.primitive.DataItem;

public class DeleteFragmentSubstitutionEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public DeleteFragmentSubstitutionEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		if(!Utility.isVariationPointsPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, Messages.VARIATION_TAB_NO_FOCUS);
			return;
		}
		JPanel variationPanel = (JPanel) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable fragSubTable = Utility.getFragmentSibstitutionTable(variationPanel);
		if(fragSubTable == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_CAN_NOT_LOCATE_FRAG_SUB_TABLE);
			return;
		}
		if(fragSubTable.getSelectedRows().length == 0){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_SELECTION);
			return;
		}
		
		int[] rowIndexes = fragSubTable.getSelectedRows();
		FragSubTableModel model = (FragSubTableModel) fragSubTable.getModel();
		ArrayList<ArrayList<DataItem>> data = model.getData();
		for(int index : rowIndexes){
			DataItem element = data.get(index).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
			VariationPoint vp = (VariationPoint) element.getNamedElement();
			cu.getOwnedVariationPoint().remove(vp);
		}
		
		views.get(tab).notifyRelalizationViewUpdate();
	}

}
