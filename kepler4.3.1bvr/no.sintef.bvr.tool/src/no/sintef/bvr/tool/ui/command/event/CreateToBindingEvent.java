package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;

import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.strategy.impl.BindingCalculatorContext;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;
import no.sintef.bvr.tool.strategy.impl.SingleDummyToPlacementBoundaryCalcStrategy;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.model.BindingTableModel;

public class CreateToBindingEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<BVRModel> models;
	private List<BVRView> views;

	public CreateToBindingEvent(JTabbedPane filePane, List<BVRModel> models, List<BVRView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		BVRModel m = models.get(tab);
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
		
		BindingTableModel bindingTableModel = (BindingTableModel) bindingTable.getModel();
		FragmentSubstitution fragmentSubstitution = bindingTableModel.getFragmentSubstitution();
		if(fragmentSubstitution == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_FRAG_SUB_DETECTED);
			return;
		}
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext singleToPlacementCrBoundryContext = new CreateBoundaryContext(new SingleDummyToPlacementBoundaryCalcStrategy(), null);
			singleToPlacementCrBoundryContext.creatBoundaries(fragmentSubstitution.getPlacement(), selectedObjects);
			
			BindingCalculatorContext bindingCalcContext = new BindingCalculatorContext();
			bindingCalcContext.generateBindings(fragmentSubstitution);
		} catch (AbstractError e1) {
			e1.printStackTrace();
		}
		
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
		//views.get(tab).notifyRelalizationViewUpdate();
	}
}
