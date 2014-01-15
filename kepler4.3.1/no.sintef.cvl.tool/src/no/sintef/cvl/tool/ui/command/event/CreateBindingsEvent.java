package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.common.LoaderUtility;
import no.sintef.cvl.tool.common.Messages;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.primitive.DataItem;
import no.sintef.cvl.tool.strategy.impl.BindingCalculatorContext;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.model.FragSubTableModel;

public class CreateBindingsEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public CreateBindingsEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		if(!LoaderUtility.isVariationPointsPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, Messages.VARIATION_TAB_NO_FOCUS);
			return;
		}
		JPanel variationPanel = (JPanel) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable fragSubTable = LoaderUtility.getFragmentSibstitutionTable(variationPanel);
		if(fragSubTable == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_CAN_NOT_LOCATE_FRAG_SUB_TABLE);
			return;
		}
		if(fragSubTable.getSelectedRows().length == 0){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_SELECTION);
			return;
		}
		if(fragSubTable.getSelectedRows().length > 1){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_MORE_THEN_ONE_SELECTION);
			return;
		}
		
		int rowIndex = fragSubTable.getSelectedRows()[0];
		FragSubTableModel model = (FragSubTableModel) fragSubTable.getModel();
		ArrayList<ArrayList<DataItem>> data = model.getData();
		DataItem element = data.get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
		VariationPoint vp = (VariationPoint) element.getNamedElement();
		
		if(!(vp instanceof FragmentSubstitution)){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NOT_FRAG_SUB_SELECTION);
			return;
		}
		
		FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) vp;
		BindingCalculatorContext bindingCalculator = new BindingCalculatorContext();
		try {
			bindingCalculator.generateBindings(fragmentSubstitution);
		} catch (AbstractError error) {
			error.printStackTrace();
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}
}
