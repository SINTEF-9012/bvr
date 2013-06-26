package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;

import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.models.BindingTableModel;
import no.sintef.cvl.ui.strategies.impl.BindingCalculatorContext;
import no.sintef.cvl.ui.strategies.impl.CreateBoundaryContext;
import no.sintef.cvl.ui.strategies.impl.DefaultSingleToPlacementCalculatorStrategy;
import no.sintef.cvl.ui.strategies.impl.GetSelectionContext;

public class CreateToBindingEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public CreateToBindingEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
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
		
		BindingTableModel bindingTableModel = (BindingTableModel) bindingTable.getModel();
		FragmentSubstitution fragmentSubstitution = bindingTableModel.getFragmentSubstitution();
		if(fragmentSubstitution == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_FRAG_SUB_DETECTED);
			return;
		}
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext singleToPlacementCrBoundryContext = new CreateBoundaryContext(new DefaultSingleToPlacementCalculatorStrategy(), null);
			singleToPlacementCrBoundryContext.creatBoundaries(fragmentSubstitution.getPlacement(), selectedObjects);
			
			BindingCalculatorContext bindingCalcContext = new BindingCalculatorContext();
			bindingCalcContext.generateBindings(fragmentSubstitution);
		} catch (AbstractError e1) {
			e1.printStackTrace();
		}
		
		views.get(tab).notifyRelalizationViewUpdate();
	}
}
